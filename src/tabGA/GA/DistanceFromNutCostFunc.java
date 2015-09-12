package tabGA.GA;

import tabGA.FingeredNote;
import tabGA.Tab;

public class DistanceFromNutCostFunc {

	public static int getCost(Tab tab) {
		int score = 0;
		FingeredNote currentFingeredNote = null;
		int currentFret; 
		
		for (int i=0; i<tab.tab.size(); i++){
			currentFingeredNote = tab.tab.get(i);
			currentFret = currentFingeredNote.getFret();
			
			// added multiplication and rewarded open string after optimisation
			if(currentFret == 0){
				//System.out.println("I love open strings! Score before: " + score);
				score += FitnessFunction.REWARD_CLASS_A;
				//System.out.println("I love open strings! Score after : " + score);
			} else {
				score += (currentFret * FitnessFunction.PENALTY_CLASS_B);	
			}
			
		}
		
		return score;
	}
	
	public static int getCostOptimised(Tab tab) {
		int score = 0;
		FingeredNote currentFingeredNote = tab.tab.get(0);
		FingeredNote nextFingeredNote = null;
		int currentFret = currentFingeredNote.getFret(); 
		int currentEventNum = currentFingeredNote.getEventNum();
		int nextEventNum;
		int lastEventNum = -1;
		
		for (int i=1; i<tab.tab.size(); i++){
			nextFingeredNote = tab.tab.get(i);
			nextEventNum = nextFingeredNote.getEventNum();
			
			if(currentEventNum!=)
			
			
			currentFret = nextFingeredNote.getFret();
			lastEventNum = currentEventNum;
			currentEventNum = nextEventNum;
			
			
			
			
			
			// added multiplication and rewarded open string after optimisation
			if(currentFret == 0){
				//System.out.println("I love open strings! Score before: " + score);
				score += FitnessFunction.REWARD_CLASS_A;
				//System.out.println("I love open strings! Score after : " + score);
			} else {
				score += (currentFret * FitnessFunction.PENALTY_CLASS_B);	
			}
			
		}
		
		return score;
	}

	
}
