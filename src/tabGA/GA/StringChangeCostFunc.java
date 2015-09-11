package tabGA.GA;

import tabGA.Tab;

public class StringChangeCostFunc {

	public static int getCost(Tab tab) {

		int score = 0;
		int currentEvent;
		int nextEvent = 0;
		int lastEvent = -1;
		int currentString;
		int lastString = 0;
		int sizeOfTab = tab.getSize();

		for (int i = 1; i < sizeOfTab; i++) {

			currentEvent = tab.getFingeredNote(i).getEventNum();
			currentString = tab.getFingeredNote(i).getCourse();

			if (i < (sizeOfTab - 1)) {
				nextEvent = tab.getFingeredNote((i + 1)).getEventNum();
			}

			if (currentEvent != lastEvent && currentEvent != nextEvent) {
				/*System.out.println("Single note:: current: " + currentEvent
						+ " last: " + lastEvent + " next: " + nextEvent);*/
				if (currentString == lastString) {
					score -= 10;
					//System.out.println("Same string @ event: " + currentEvent);
				}
			} else if (i == sizeOfTab) {
				if (currentString == lastString) {
					score -= 10;
					/*System.out.println("LAST EVENT!");
					System.out.println("Same string @ event: " + currentEvent);*/
				}

			}
			
			lastEvent = currentEvent;
			lastString = currentString;
		}

		// System.out.println("Score for tab: " + score);
		return score;

	}
}
