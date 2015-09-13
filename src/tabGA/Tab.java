package tabGA;

import java.util.ArrayList;

public class Tab {

	public ArrayList<FingeredNote> tab = new ArrayList<FingeredNote>();
	public int cost = 0;

	public Tab(ArrayList<FingeredNote> tb) {

		this.tab = tb;

	}

	public Tab(Tab anotherTab) {
		this.tab = anotherTab.tab;
		this.cost = anotherTab.cost;
	}

	public String toString() {

		String str = new String();
		for (int i = 0; i < tab.size(); i++) {
			str = str + tab.get(i).toString();
			str = str + "; ";
		}

		return str;

	}

	public FingeredNote getFingeredNote(int i) {
		return tab.get(i);
	}

	public int getSize() {

		return tab.size();
	}

	public void setCost(int cost) {

		this.cost = cost;

	}

	public int getCost() {

		return cost;
	}

	public void replaceFingeredNote(int i, FingeredNote newFNote) {

		tab.set(i, newFNote);

	}

	public int countSingleNotes() {

		int lastEventNum = tab.get(0).getEventNum();
		int currentEventNum;
		int nextEventNum;
		int singleNotes = 0;

		for (int i = 1; i < (tab.size() - 1); i++) {
			currentEventNum = tab.get(i).getEventNum();
			nextEventNum = tab.get(i + 1).getEventNum();

			if (currentEventNum != lastEventNum
					&& currentEventNum != nextEventNum) {
				singleNotes++;
			}

			lastEventNum = currentEventNum;

		}

		return singleNotes;
	}
	
	public int countChords(){
		
		int chords=0;
		
		chords = (tab.get(tab.size()-1).eventNum) - countSingleNotes();
		
		return chords;
	}

}
