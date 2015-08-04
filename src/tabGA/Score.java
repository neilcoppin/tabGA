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
	
	public Note getNoteAt(int i){
		
		return notes.get(i);
		
	}
	

}
