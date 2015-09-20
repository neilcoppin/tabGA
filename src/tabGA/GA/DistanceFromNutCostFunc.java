package tabGA.GA;

import tabGA.FingeredNote;
import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class DistanceFromNutCostFunc penalises tabs that play frets
 * unnecessarily high up the neck of the lute.
 */
public class DistanceFromNutCostFunc {

	/**
	 * Gets the cost.
	 *
	 * @param tab the tab
	 * @return the cost
	 */
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
	
	/**
	 * Gets the cost optimised.
	 *
	 * @param tab the tab
	 * @return the cost optimised
	 */
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
