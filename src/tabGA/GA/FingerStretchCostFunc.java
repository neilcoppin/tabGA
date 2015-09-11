package tabGA.GA;

import tabGA.Tab;

public class FingerStretchCostFunc {

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

				
				score += getStretch(fretA, fretB) * 100;

			}
			
			lastEvent = currentEvent;

		}

		return score;
	}

	private static int getStretch(int fretA, int fretB) {

		return Math.abs(fretA - fretB);

	}

}
