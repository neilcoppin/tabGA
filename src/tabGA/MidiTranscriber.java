package tabGA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @deprecated The Class MidiTranscriber is no longer used. .
 */
public class MidiTranscriber extends Transcriber {

	/**
	 *@deprecated
	 * Transcribe midi pitch.
	 *
	 * @param event the event
	 * @param pw the pw
	 * @throws Exception the exception
	 */
	public void transcribeMidiPitch(String event, PrintWriter pw)
			throws Exception {
		char eventFirstChar = event.charAt(0);
		System.out.println("Event counter: " + eventCounter);
		System.out.println("event = " + event);

		// Check for valid note
		boolean functionFound = false;
		while (!functionFound) {
			int searchNum = 1;
			
			if (eventFirstChar == 'R') {
				// Handle rest note
				System.out.println("Skipping rest note");
				functionFound = true;
			} else if (eventFirstChar == '@') {
				System.out.println("Found '@' event");
				commitEventToTranscript(event,pw);
				functionFound = true;
			} else if (searchNum == Note.VALID_NOTES.length) {
				System.out.println("BAD EVENT: " + eventFirstChar);
			} else {
			
			for (int i = 0; i < Note.VALID_NOTES.length; i++) {

				if (eventFirstChar == Note.VALID_NOTES[i]) {
					System.out.println("TRSC: FOUND NOTE");
					Note note = getNoteDetails(eventFirstChar, event);
					String midiPitch = getMidiPitchString(note);
					commitEventToTranscript(midiPitch, pw);
					eventCounter++;
					functionFound = true;
				} else {
					searchNum++;
				}
				
			}

			}
		}
	}

	/**
	 * @deprecated
	 * Gets the midi pitch string.
	 *
	 * @param note the note
	 * @return the midi pitch string
	 */
	private String getMidiPitchString(Note note) {
		return note.getMidiPitch().toString();
	}

	/**
	 * @deprecated
	 * Commit event to transcript.
	 *
	 * @param midiPitch the midi pitch
	 * @param pw the pw
	 */
	private void commitEventToTranscript(String midiPitch, PrintWriter pw) {

		String printMe = new String(midiPitch);
		pw.println(printMe);

	}
	
	

}