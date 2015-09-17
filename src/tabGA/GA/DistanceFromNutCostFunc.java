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
			} else if (currentFingeredNote.lowestNeckPosition() == true )	{
				score += FitnessFunction.REWARD_CLASS_A;
				//System.out.println("Bonus for optimal option!");
			} else {
				score += (currentFret * FitnessFunction.PENALTY_CLASS_A);
				//System.out.println("BADNESS");
			}
			
		}
		
		return score;
	}

	
}
