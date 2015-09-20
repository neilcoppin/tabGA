package tabGA;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Score represents a musical score, based on the source
 * MIDI file.
 */
public class Score {

	/** The notes that construct the composition. */
	private ArrayList<Note> notes = new ArrayList<Note>();

	/**
	 * Adds the note.
	 *
	 * @param note the note
	 */
	public void addNote(Note note) {

		notes.add(note);

	}

	/**
	 * Length.
	 *
	 * @return the int
	 */
	public int length() {

		return notes.size();

	}

	/**
	 * Gets the note at.
	 *
	 * @param i the i
	 * @return the note at
	 */
	public Note getNoteAt(int i) {

		return notes.get(i);

	}

	/**
	 * Transpose for lute by average.
	 */
	public void transposeForLuteByAverage() {

		Integer total = 0;
		int idealPitch = 49;
		int averagePitch;

		for (int i = 0; i < length(); i++) {
			total = (total + getNoteAt(i).getMidiPitch());
		}

		averagePitch = (total / length());

		moveAllNotesByInterval(averagePitch,idealPitch);

	}
	
	/**
	 * Transpose by octave.
	 */
	public void transposeByOctave() {

		int lowestNote = getLowestNote();
		int octAdjust = 0;
		
		
		while(lowestNote>=Lute.LOWEST_NOTE){
			System.out.println("Current LN " + lowestNote);
			if((lowestNote-12)>=Lute.LOWEST_NOTE){
				octAdjust = (octAdjust-1);
				lowestNote = (lowestNote-12);
				System.out.println("Now LN is " + lowestNote);
			} else if ((lowestNote-12)<Lute.LOWEST_NOTE){
				break;
			}
		}
		System.out.println("Lowest note found to be: " + lowestNote);
		moveAllNotesByOctave(octAdjust);
		

		
	}

	/**
	 * Move all notes by octave.
	 *
	 * @param oct the oct
	 */
	public void moveAllNotesByOctave(int oct) {

		int transposition = (12*oct);
		
		System.out.println("Setting transposition at: " + transposition);

		for (int i = 0; i < length(); i++) {
			getNoteAt(i).setTranposition(transposition);
		}

	}
	
	/**
	 * Move all notes by interval.
	 *
	 * @param from the from
	 * @param to the to
	 */
	public void moveAllNotesByInterval(int from, int to) {

		int transposition;
		
		if (from < to) {
			transposition = (to - from);
		} else {
			transposition = (from - to);
		}

		System.out.println("Setting transposition at: " + transposition);

		for (int i = 0; i < length(); i++) {
			getNoteAt(i).setTranposition(transposition);
		}

	}

	/**
	 * Move lowest note in score to root on sixth.
	 */
	public void moveLowestNoteInScoreToRootOnSixth() {

		int lowestNote = getLowestNote();
		int transposition;

		if (lowestNote < Lute.LOWEST_NOTE) {
			transposition = (Lute.LOWEST_NOTE - lowestNote);
		} else {
			transposition = (lowestNote - Lute.LOWEST_NOTE);
		}

		System.out.println("Setting transposition at: " + transposition);

		for (int i = 0; i < length(); i++) {
			getNoteAt(i).setTranposition(transposition);
		}

	}

	/**
	 * Gets the lowest note.
	 *
	 * @return the lowest note
	 */
	private int getLowestNote() {

		int lowestNote = 127;
		int currentNote = 0;

		for (int i = 0; i < length(); i++) {
			currentNote = getNoteAt(i).getMidiPitch();
			if (currentNote < lowestNote) {
				lowestNote = currentNote;
			}
		}
		return lowestNote;
	}

}
