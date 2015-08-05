package tabGA.GA;

import tabGA.FingeredNote;
import tabGA.Tab;

public class FitnessFunction {

	public static Tab getFittestIndividual(Population pop) {
		Tab fittest = null;
		Tab currentTab = null;
		int bestScore = Integer.MAX_VALUE;
		int currentScore = 0;

		for (int i = 0; i < pop.getSize(); i++) {
			currentTab = pop.population.get(i);
			currentScore = getFitness(currentTab);

			if (currentScore < bestScore) {
				fittest = currentTab;
				bestScore = currentScore;
			};
			//System.out.println(currentScore);

		}
		System.out.println("The best score: " + bestScore);
		
		return fittest;
	}

	//returns the cost/fitness of the tab and assigns this cost to the tab object 
	private static int getFitness(Tab tab) {
		int score = 0;
		FingeredNote currentFingeredNote = null;
		
		for (int i=0; i<tab.tab.size(); i++){
			currentFingeredNote = tab.tab.get(i);
			
			score = score + currentFingeredNote.getFret();
			
		}
		
		//assign the value to the tab
		tab.setCost(score);
		
		return score;
	}

}
