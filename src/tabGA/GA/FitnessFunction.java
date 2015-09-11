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
		//System.out.println("The best score: " + bestScore);
		
		return fittest;
	}

	//returns the cost/fitness of the tab and assigns this cost to the tab object 
	private static int getFitness(Tab tab) {
		int score = 0;
		
		//Pre-optimisation config
		score += DistanceFromNutCostFunc.getCost(tab);
		score += SameEventSameString.getCost(tab);
		
		// Optimisation
		score += FingerStretchCostFunc.getCost(tab);
		score += StringChangeCostFunc.getCost(tab);
		score += FretJumpCostFunc.getCost(tab);
		score += BarrePreferredCostFunc.getCost(tab);
		
		//assign the value to the tab
		tab.setCost(score);
		
		return score;
	}

	
}
