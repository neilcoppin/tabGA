package tabGA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;

import tabGA.GA.GA;

public class Main {

	public static void main(String[] args) throws Exception {

		File inputFolder = new File("C:/inputFolder");
		File outputFolder = new File("C:/outputFolder");
		File midiFile = inputFolder.listFiles()[0];
		String fileName = midiFile.getName().trim();
		String midiOutputFileName = new String("midiOutput.txt");
		String tabFileName = new String(fileName + ".txt");
		System.out.println("Found file: " + fileName);
		
		
		MidiTranscriber midiTrsc = new MidiTranscriber();
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"), true);
		PrintWriter pw2 = new PrintWriter(new FileWriter(midiOutputFileName),
				true);
		PrintWriter pw3 = new PrintWriter(new FileWriter("GAInput.txt"), true);
		

		MidiParser.midiToString(midiFile, pw2);
		
		Scanner scanner = new Scanner(midiOutputFileName);
		//scanner.useDelimiter("\\s");

		String event = new String();

		boolean foundNote = false;

		// K = key sig; V = voice; I = instrument; T = tempo;
		/*
		while (!foundNote) {
			event = scanner.next();
			for (int i = 0; i < Note.VALID_NOTES.length; i++) {
				if (event.charAt(0) == Note.VALID_NOTES[i]) {
					foundNote = true;
					break;
				} else if ((event.length() > 4)
						&& (event.substring(0, 5).equals("TIME:"))) {
					System.out.println("Found Time Sig");
					midiTrsc.setTimeSignature(event.substring(5));
					break;
				} else if (event.charAt(0) == 'T') {
					System.out.println("Found Tempo");
					midiTrsc.setTempo(Integer.parseInt(event.substring(1)));
					break;
				} else if (event.charAt(0) == 'K') {
					midiTrsc.setKeySignature(event.substring(1));
					break;
				} else {
					// do nothing
				}

			}
		}
		*/
		
		event = scanner.next();

		while (scanner.hasNextLine()) {
			// OLD SYSTEM COMMENCE
			// System.out.println("Raw data: " + event);
			// pw2.println(event);
			// trsc.transcribeEvent(event, pw);
			// OLD SYSTEM FINISH (except event = scanner.next)

			midiTrsc.transcribeMidiPitch(event, pw3);

			event = scanner.next();
		}

		System.out.println("All done, ending doc");
		
		scanner.close();
		pw2.close();
		pw3.close();

		Scanner midiOutputScanner = new Scanner(new File(midiOutputFileName));
		Score score = new Score();
		Integer eventNum = 0;
		GA ga = new GA();
		Tab bestCandidate = null;
		String currentEvent = " ";
		//String lastEvent = " ";

		while (midiOutputScanner.hasNext()) {

			if (currentEvent.startsWith("#")) {
				//System.out.println("MAIN: @ found");
				
				eventNum++;
			}

			currentEvent = midiOutputScanner.next();

			//if (currentEvent.charAt(0) == '#') {
			if (currentEvent.startsWith("#")) {
				//System.out.println("MAIN: Not recording #");
			} else {

				//System.out.println("event num is :: " + eventNum);
				Note nte = new Note(currentEvent, eventNum);
				System.out.println(nte.toString());
				score.addNote(nte);

			}

			//lastEvent = currentEvent;

		}

		midiOutputScanner.close();

		System.out.println("MAIN: Starting GA");
		
		score.transposeByOctave();
		
		bestCandidate = ga.start(score);
		System.out.println("The best tab is: " + bestCandidate.toString());
		System.out.println("Length of score: " + score.length());
		System.out.println("Length of tab: " + bestCandidate.getSize());
		
		pw.println("b");
		TabTranscriber tabTrsc = new TabTranscriber();
		tabTrsc.convertToCrippsTAB(bestCandidate, score, pw);
		pw.println("b");
		pw.println("e");
		pw.close();
		
		
		File outputFile = new File(outputFolder, tabFileName);
		Files.move(new File("output.txt").toPath(), outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Finished!");
		
	}

}
