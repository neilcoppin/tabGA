package tabGA.GA;

import tabGA.FingeredNote;
import tabGA.Tab;

public class DistanceFromNutCostFunc {

	public static int getCost(Tab tab) {
		int score = 0;
		FingeredNote currentFingeredNote = null;
		
		for (int i=0; i<tab.tab.size(); i++){
			currentFingeredNote = tab.tab.get(i);
			
			score = score + currentFingeredNote.getFret();
			
		}
		
		return score;
	}

	
}
