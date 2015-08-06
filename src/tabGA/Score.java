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

	public void transposeForLute() {

		Integer total = 0;
		int idealPitch = 49;
		int averagePitch;

		for (int i = 0; i < length(); i++) {
			total = (total + getNoteAt(i).getMidiPitch());
		}

		averagePitch = (total / length());

		moveAllNotes(averagePitch,idealPitch);

	}

	public void moveAllNotes(int from, int to) {

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

		int lowestNote = 0;
		int currentNote = 0;

		for (int i = 0; i < length(); i++) {
			currentNote = getNoteAt(i).getMidiPitch();
			if (currentNote > lowestNote) {
				lowestNote = currentNote;
			}
		}
		return lowestNote;
	}

}
