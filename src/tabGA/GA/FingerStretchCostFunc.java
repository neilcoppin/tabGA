package tabGA.GA;

import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class FingerStretchCostFunc penalises chords which contain wide fret stretches.
 */
public class FingerStretchCostFunc {

	/**
	 * Gets the cost.
	 *
	 * @param tab the tab
	 * @return the cost
	 */
	public static int getCost(Tab tab) {

		int score = 0;
		int fretA = 0;
		int fretB = 0;
		int currentEvent;
		int lastEvent = -1;

		for (int i = 0; i < (tab.getSize() - 1); i++) {

			currentEvent = tab.getFingeredNote(i).getEventNum();
			if (currentEvent == lastEvent) {

				fretA = tab.getFingeredNote(i).getFret();
				fretB = tab.getFingeredNote((i - 1)).getFret();

				
				score += getStretch(fretA, fretB) * FitnessFunction.PENALTY_CLASS_A;
				

			}
			
			lastEvent = currentEvent;

		}

		return score;
	}

	/**
	 * Gets the stretch.
	 *
	 * @param fretA the fret a
	 * @param fretB the fret b
	 * @return the stretch
	 */
	private static int getStretch(int fretA, int fretB) {

		return Math.abs(fretA - fretB);

	}

}
