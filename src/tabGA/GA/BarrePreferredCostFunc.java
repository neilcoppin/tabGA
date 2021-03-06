package tabGA.GA;

import java.util.ArrayList;
import java.util.Arrays;

import tabGA.FingeredNote;
import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class BarrePreferredCostFunc rewards barre chords.
 */
public class BarrePreferredCostFunc {
	
	/** The chord. */
	static int[] chord = new int[7];

	/**
	 * Gets the cost.
	 *
	 * @param tab the tab
	 * @return the cost
	 */
	public static int getCost(Tab tab) {

		clearChord();
		int score = 0;
		int currentEvent = 0;
		int lastEvent = -1;
		int sizeOfTab = tab.getSize();
		FingeredNote fingNote = null;

		for (int i = 1; i < sizeOfTab; i++) {

			fingNote = tab.getFingeredNote(i);
			currentEvent = fingNote.getEventNum();
			
			
			if(currentEvent==lastEvent){
				addFingerToChord(fingNote.getCourse(), fingNote.getFret());
			} else {
				score -= scoreFretsInUse();
				clearChord();
				addFingerToChord(fingNote.getCourse(), fingNote.getFret());
			}
			
			
			lastEvent = currentEvent;
		}

		// System.out.println("Score for tab: " + score);
		return score;

	}

	/**
	 * Score frets in use.
	 *
	 * @return the int
	 */
	private static int scoreFretsInUse() {

		int score = 0;
		
		Arrays.sort(chord);
		
		for(int i=1; i<chord.length; i++){
			//System.out.println("Checked course " + (i) + " value is " + chord[i]);
			if(chord[i] == chord[(i-1)] && chord[i] != -1) {
				score += FitnessFunction.REWARD_CLASS_A;
			}
		}
		//System.out.println("Score is: " + score);
		return score;
	}

	/**
	 * Clear chord.
	 */
	private static void clearChord() {

		//System.out.println("Clearing chord!");
		for (int i = 0; i< chord.length; i++){
			chord[i] = -1;
		}
		
	}

	/**
	 * Adds the finger to chord.
	 *
	 * @param course the course
	 * @param fret the fret
	 */
	private static void addFingerToChord(int course, int fret) {
		
		
		chord[(course-1)] = fret;
		//System.out.print("State of array: ");
		//for (int i = 0; i< chord.length; i++){
		//	System.out.print(chord[i] + ", ");
		//}
		//System.out.println();
		
		
	}
}
