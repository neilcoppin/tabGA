package tabGA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Transcriber {

	int eventCounter = 0;
	int commitCounter = 0;
	String lastTimeStamp;
	StringBuilder stringBuilder = new StringBuilder();
	TabBuilder tab = new TabBuilder();
	boolean pauseCommit = false;

			
	public Note getNoteDetails(char noteName, String event) throws Exception {

		Note note = new Note();

		// Handle rest notes
		if (noteName == 'R') {
			note.setName('X');
			char currentChar = event.charAt(1);
			note.setDuration(currentChar);
			System.out.println(note.toString());
			return note;
		}

		note.setName(noteName);

		int i = 1;
		char currentChar = event.charAt(i);

		if (currentChar == 'b') {
			note.setAccidental(currentChar);
			i++;
			currentChar = event.charAt(i);
		} else if (currentChar == '#') {
			note.setAccidental(currentChar);
			i++;
			currentChar = event.charAt(i);
		}
		// else {}

		note.setOctave(currentChar);
		i++;
		currentChar = event.charAt(i);

		// handle decimal value NOT COMPLETE! DEFAULTS TO x
		if (currentChar == '/') {
			System.out
					.println("ALERT DECIMAL VALUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Note.decimalDurationToString(Double.parseDouble(event
					.substring(i + 1)));
		}
		note.setDuration(currentChar);
		note.setNotePitch();
		System.out.println("NOTE: new note - " + note.toString());
		return note;

	}
	

	public void getNotePosition(String note) {

	}

	public void setTimeSignature(String val) {
		System.out.println("Time Sig is: " + val);

	}

	public void setTempo(Integer val) {
		System.out.println("Tempo is: " + val);

	}

	public void setKeySignature(String val) {
		System.out.println("Key Sig is: " + val);
	}

}