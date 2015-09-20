package tabGA.GA;

import tabGA.FingeredNote;
import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class FitnessFunction holds the constants for scoring 
 * and methods to cost and rank tabs.
 */
public class FitnessFunction {
	
	/** The Constant PENALTY_CLASS_A. */
	public static final int PENALTY_CLASS_A = 3;
	
	/** The Constant PENALTY_CLASS_B. */
	public static final int PENALTY_CLASS_B = 2;
	
	/** The Constant PENALTY_CLASS_C. */
	public static final int PENALTY_CLASS_C = 1;
	
	/** The Constant REWARD_CLASS_A. */
	public static final int REWARD_CLASS_A = -3;
	
	/** The Constant REWARD_CLASS_B. */
	public static final int REWARD_CLASS_B = -2;
	
	/** The Constant REWARD_CLASS_C. */
	public static final int REWARD_CLASS_C = -1;

	/**
	 * Gets the fittest individual.
	 *
	 * @param pop the pop
	 * @return the fittest individual
	 */
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

	/**
	 * Gets the fitness.
	 *
	 * @param tab the tab
	 * @return the fitness
	 */
	//returns the cost/fitness of the tab and assigns this cost to the tab object 
	private static int getFitness(Tab tab) {
		int score = 0;
		
		
		
		//Pre-optimisation config
		//score += DistanceFromNutCostFunc.getCost(tab);
		score += SameEventSameString.getCost(tab);
		
		// Optimisation
		score += FingerStretchCostFunc.getCost(tab);
		score += StringChangeCostFunc.getCost(tab);
		score += FretJumpCostFunc.getCost(tab);
		score += BarrePreferredCostFunc.getCost(tab);
		score += DistanceFromNutCostFunc.getCostOptimised(tab);
		
		//assign the value to the tab
		tab.setCost(score);
		
		
		
		return score;
	}
	
	/**
	 * Gets the worst individual.
	 *
	 * @param pop the pop
	 * @return the worst individual
	 */
	public static Tab getWorstIndividual(Population pop) {
		Tab worst = null;
		Tab currentTab = null;
		int bestWorstScore = Integer.MIN_VALUE;
		int currentScore = 0;

		for (int i = 0; i < pop.getSize(); i++) {
			currentTab = pop.population.get(i);
			currentScore = currentTab.cost;

			if (currentScore > bestWorstScore) {
				worst = currentTab;
				bestWorstScore = currentScore;
			};
			//System.out.println(currentScore);

		}
		//System.out.println("The best score: " + bestScore);
		
		return worst;
	}

	
}
