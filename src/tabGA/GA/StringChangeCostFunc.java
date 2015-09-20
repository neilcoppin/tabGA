package tabGA.GA;

import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class StringChangeCostFunc is used to cost a given tab
 * based on the number of string/course changes.
 */
public class StringChangeCostFunc {

	/**
	 * Gets the cost.
	 *
	 * @param tab the tab
	 * @return the cost
	 */
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
					score += FitnessFunction.REWARD_CLASS_A;
					//System.out.println("Same string @ event: " + currentEvent);
				}
			} else if (i == sizeOfTab) {
				if (currentString == lastString) {
					score += FitnessFunction.REWARD_CLASS_A;
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
