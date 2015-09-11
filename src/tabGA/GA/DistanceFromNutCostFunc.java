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
				score -= 10000;
			} else {
				score += (currentFret * 10000);	
			}
			
		}
		
		return score;
	}

	
}
