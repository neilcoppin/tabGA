package tabGA;

import java.util.ArrayList;

public class Score {

	private ArrayList<Note> notes = new ArrayList<Note>();

	public void addNote(Note note) {

		notes.add(note);

	}

	public int length() {

		return notes.size();

	}

	public Note getNoteAt(int i) {

		return notes.get(i);

	}

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

	public void moveAllNotesByOctave(int oct) {

		int transposition = (12*oct);
		
		System.out.println("Setting transposition at: " + transposition);

		for (int i = 0; i < length(); i++) {
			getNoteAt(i).setTranposition(transposition);
		}

	}
	
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
