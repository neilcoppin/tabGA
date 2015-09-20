package tabGA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Transcriber.
 */
public class Transcriber {

	/** The event counter. */
	int eventCounter = 0;
	
	/** The commit counter. */
	int commitCounter = 0;
	
	/** The last time stamp. */
	String lastTimeStamp;
	
	/** The string builder. */
	StringBuilder stringBuilder = new StringBuilder();
	
	/** The tab. */
	TabBuilder tab = new TabBuilder();
	
	/** The pause commit. */
	boolean pauseCommit = false;

			
	/**
	 * @deprecated
	 * Gets the note details.
	 *
	 * @param noteName the note name
	 * @param event the event
	 * @return the note details
	 * @throws Exception the exception
	 */
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
	

	/**
	 * Gets the note position.
	 *
	 * @param note the note
	 * @return the note position
	 */
	public void getNotePosition(String note) {

	}

	/**
	 * Sets the time signature.
	 *
	 * @param val the new time signature
	 */
	public void setTimeSignature(String val) {
		System.out.println("Time Sig is: " + val);

	}

	/**
	 * Sets the tempo.
	 *
	 * @param val the new tempo
	 */
	public void setTempo(Integer val) {
		System.out.println("Tempo is: " + val);

	}

	/**
	 * Sets the key signature.
	 *
	 * @param val the new key signature
	 */
	public void setKeySignature(String val) {
		System.out.println("Key Sig is: " + val);
	}

}