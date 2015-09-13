package tabGA.GA;

import tabGA.Tab;

public class FretJumpCostFunc {

	public static int getCost(Tab tab) {

		int score = 0;
		int currentEvent;
		int lastEvent = -1;
		int currentFret;
		int lastFret = 0;
		int sizeOfTab = tab.getSize();

		for (int i = 1; i < sizeOfTab; i++) {

			currentEvent = tab.getFingeredNote(i).getEventNum();
			currentFret = tab.getFingeredNote(i).getFret();


			if (currentEvent != lastEvent) {
				
				//System.out.println("current event " + currentEvent + " last event " + lastEvent);
				
				if(lastFret != currentFret && currentFret != 0 && lastFret != 0){
					score += getGapPenalty(lastFret, currentFret);
				}
				
			}
			
			lastEvent = currentEvent;
			lastFret = currentFret;
		}

		return score;

	}

	private static int getGapPenalty(int lastFret, int currentFret) {
		
		int penalty;
		
		//System.out.println("lastFret " + lastFret + " currentFret " + currentFret);
		
		if(currentFret > lastFret){
			penalty = (currentFret - lastFret);
		} else {
			penalty = (lastFret - currentFret);
		}
		
		if(penalty<=5){
			penalty=0;
		}
		
		penalty = penalty * FitnessFunction.PENALTY_CLASS_C;
		
		//System.out.println("penalty " + penalty);
		
		return penalty;
	}
	
	
	
}
