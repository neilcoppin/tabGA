package tabGA;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Tab represents a tab in the population.
 */
public class Tab {

	/** The tab. */
	public ArrayList<FingeredNote> tab = new ArrayList<FingeredNote>();
	
	/** The cost. */
	public int cost = 0;

	/**
	 * Instantiates a new tab.
	 *
	 * @param tb the tb
	 */
	public Tab(ArrayList<FingeredNote> tb) {

		this.tab = tb;

	}

	/**
	 * Instantiates a new tab.
	 *
	 * @param anotherTab the another tab
	 */
	public Tab(Tab anotherTab) {
		this.tab = anotherTab.tab;
		this.cost = anotherTab.cost;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		String str = new String();
		for (int i = 0; i < tab.size(); i++) {
			str = str + tab.get(i).toString();
			str = str + "; ";
		}

		return str;

	}

	/**
	 * Gets the fingered note.
	 *
	 * @param i the i
	 * @return the fingered note
	 */
	public FingeredNote getFingeredNote(int i) {
		return tab.get(i);
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {

		return tab.size();
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(int cost) {

		this.cost = cost;

	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public int getCost() {

		return cost;
	}

	/**
	 * Replace fingered note.
	 *
	 * @param i the i
	 * @param newFNote the new f note
	 */
	public void replaceFingeredNote(int i, FingeredNote newFNote) {

		tab.set(i, newFNote);

	}

	/**
	 * Count single notes.
	 *
	 * @return the int
	 */
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
	
	/**
	 * Count chords.
	 *
	 * @return the int
	 */
	public int countChords(){
		
		int chords=0;
		
		chords = (tab.get(tab.size()-1).eventNum) - countSingleNotes();
		
		return chords;
	}

}
