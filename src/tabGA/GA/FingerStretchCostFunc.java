package tabGA.GA;

import tabGA.Tab;

public class FingerStretchCostFunc {

	public static int getCost(Tab tab) {
		
		int score = 0;
		int fretA = 0;
		int fretB = 0;
		
		for (int i=0; i<(tab.getSize()-1);i++){
			fretA = tab.getFingeredNote(i).getFret();
			fretB = tab.getFingeredNote((i+1)).getFret();
			
			//score =+ getStretch(fretA, fretB);
			int newScore = getStretch(fretA, fretB);
			if(newScore>score){
				score = newScore;
			}
			
		}
		
		
		return score;
	}
	
	private static int getStretch(int fretA, int fretB){
		
		return Math.abs(fretA - fretB);
		
	}

}
