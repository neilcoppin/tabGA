package tabGA;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

//import org.jfugue.midi.MidiFileManager;
//import org.jfugue.pattern.Pattern;
//import org.jfugue.player.Player;

public class MidiParser {
	
	public static final int NOTE_ON = 0x90;
	public static final int NOTE_OFF = 0x80;
	public static final String[] NOTE_NAMES = { "C", "C#", "D", "D#", "E", "F",
			"F#", "G", "G#", "A", "A#", "B" };

	
	public static void midiToString(File midiFile, PrintWriter pw) throws IOException, InvalidMidiDataException, MidiUnavailableException {
	
	Sequence sequence = MidiSystem.getSequence(midiFile);
	Sequencer sequencer = MidiSystem.getSequencer();
	sequencer.setSequence(sequence);
	Float bpm = sequencer.getTempoInBPM();
	  
	int trackNumber = 0;
	for (Track track : sequence.getTracks()) {
		trackNumber++;
		System.out.println("Track " + trackNumber + ": size = "
				+ track.size());
		System.out.println();
		System.out.println("Ticks per quarter note "+sequence.PPQ);
		System.out.println(bpm+"BPM");
		
		long currentTick;
		long lastTick = 0;
		
		for (int i = 0; i < track.size(); i++) {
			MidiEvent event = track.get(i);
			currentTick = event.getTick();
			System.out.print("@" + event.getTick() + " ");
			MidiMessage message = event.getMessage();
			
			if (currentTick != lastTick){
				pw.println("#");
			}
			
			if (message instanceof ShortMessage) {
				ShortMessage sm = (ShortMessage) message;
				System.out.print("Channel: " + sm.getChannel() + " ");
				if (sm.getCommand() == NOTE_ON) {
					int key = sm.getData1();
					int octave = (key / 12) - 1;
					int note = key % 12;
					String noteName = NOTE_NAMES[note];
					int velocity = sm.getData2();
					System.out.println("Note on, " + noteName + octave
							+ " key=" + key + " velocity: " + velocity);
					pw.println(key);
				} else if (sm.getCommand() == NOTE_OFF) {
					int key = sm.getData1();
					int octave = (key / 12) - 1;
					int note = key % 12;
					String noteName = NOTE_NAMES[note];
					int velocity = sm.getData2();
					System.out.println("Note off, " + noteName + octave
							+ " key=" + key + " velocity: " + velocity);
				} else {
					System.out.println("Command:" + sm.getCommand());
				}
			} else {
				System.out.println("Other message: " + message.getClass());
			}
			lastTick = currentTick;
		}

		System.out.println();
	}

}

	
	
	//old method - proved unreliable
	/*
	public static String midiToString(File midiFile) throws IOException, InvalidMidiDataException {
		
		//Player player = new Player();
		Pattern pattern = MidiFileManager.loadPatternFromMidi(midiFile);
	    //System.out.println(pattern);
		
	    
	    String output = pattern.toString();
	    //System.out.println(output);
	    
	    return output;
		
	}
	*/
	
	public static char decDurationToChar(double val){
		String strDur = org.jfugue.theory.Note.getDurationString(round(val, 1));
		System.out.println("strDur = " + strDur);
		char duration = strDur.charAt(0);
					
		return duration;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
