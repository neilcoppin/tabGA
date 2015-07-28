package tabGA;

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
			System.out.println(currentScore);

		}
		
		return fittest;
	}

	private static int getFitness(Tab tab) {
		int score = 0;
		FingeredNote currentFingeredNote = null;
		
		for (int i=0; i<tab.tab.size(); i++){
			currentFingeredNote = tab.tab.get(i);
			
			score = score + currentFingeredNote.getFret();
			
		}
		
		return score;
	}

}
