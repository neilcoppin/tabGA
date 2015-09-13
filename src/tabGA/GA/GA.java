package tabGA.GA;

import tabGA.Score;
import tabGA.Tab;

public class GA {
	
	//Set mutation rate etc here
	public static final Integer POPULATION_SIZE = 100;
	public static final Integer NUM_OF_GENERATIONS = 500;
	
	Score score;
	Tab bestCandidate;
	Tab bestCandidateOfInitialPop;
	Tab worstCandidateOfInitialPop;
	
	
	public Tab start(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		this.score = score;
		Population initialPop;
		
		System.out.println("GA: creating initial Population");
		initialPop = new Population(this.score);
		//System.out.println(initialPop.toString());
		bestCandidateOfInitialPop = FitnessFunction.getFittestIndividual(initialPop);
		worstCandidateOfInitialPop = FitnessFunction.getWorstIndividual(initialPop);
		
		
		Population lastPop = initialPop;
		Population currentPop = new Population();
		Tab currentBestTab;
		Tab currentWorstTab;
		Tab overallBestTab = new Tab(bestCandidateOfInitialPop);
		//Tab overallWorstTab = new Tab(worstCandidateOfInitialPop);
		int bestScore = 1000000000;
		int currentScore = 1000000000;
		int currentWorstScore = 0;
		int bestWorstScore = 0;
				
		System.out.print("Generation: ");
		for (int i=0; i<NUM_OF_GENERATIONS.intValue(); i++){
			//System.out.print(i + " | ");
			currentPop = Evolver.createNextGeneration(lastPop);
			currentBestTab = FitnessFunction.getFittestIndividual(currentPop);
			currentWorstTab = FitnessFunction.getWorstIndividual(currentPop);
			currentScore = currentBestTab.cost;
			currentWorstScore = currentWorstTab.cost;
			if(bestScore > currentScore){
				System.out.println("Swapping out: bestScore " + bestScore + " currentScore " + currentScore);
				overallBestTab = new Tab(currentBestTab);
				bestScore = overallBestTab.cost;
			}
			if(currentWorstScore>bestWorstScore){
				bestWorstScore = currentWorstScore;
			}
			System.out.println("Generation " + "(" + i + ") Current best/worst: " + currentScore + " // " + currentWorstScore);
			lastPop = currentPop;
		}
		
		System.out.println();
		//System.out.println("CURRENT POP SIZE: "+currentPop.getSize());
		
		bestCandidate = FitnessFunction.getFittestIndividual(currentPop);
		
		System.out.println("Score of best in initial pop: "  + bestCandidateOfInitialPop.cost);
		System.out.println("Best score achieved: " + bestScore);
		System.out.println("Resulting tab score: " + bestCandidate.cost);
		System.out.println("Resulting overallBestTab score: " + overallBestTab.cost);

		
		//return bestCandidate;
		return overallBestTab;
		//return bestCandidateOfInitialPop;
		
	}

}
