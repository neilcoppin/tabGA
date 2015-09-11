package tabGA.GA;

import tabGA.Score;
import tabGA.Tab;

public class GA {
	
	//Set mutation rate etc here
	public static final Integer POPULATION_SIZE = 60;
	public static final Integer NUM_OF_GENERATIONS = 50;
	
	Score score;
	Tab bestCandidate;
	Tab bestCandidateOfInitialPop;
	
	
	public Tab start(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		this.score = score;
		Population initialPop;
		
		System.out.println("GA: creating initial Population");
		initialPop = new Population(this.score);
		System.out.println(initialPop.toString());
		bestCandidateOfInitialPop = FitnessFunction.getFittestIndividual(initialPop);
		
		Population lastPop = initialPop;
		Population currentPop = new Population();
		Tab currentBestTab;
		Tab overallBestTab = null;
		int bestScore = 1000000000;
				
		for (int i=0; i<NUM_OF_GENERATIONS.intValue(); i++){
			currentPop = Evolver.createNextGeneration(lastPop);
			currentBestTab = FitnessFunction.getFittestIndividual(currentPop);
			if(currentBestTab.cost < bestScore){
				overallBestTab = currentBestTab;
				bestScore = overallBestTab.cost;
			}
			lastPop = currentPop;
		}
		
		//System.out.println("CURRENT POP SIZE: "+currentPop.getSize());
		
		bestCandidate = FitnessFunction.getFittestIndividual(currentPop);
		
		System.out.println("Score of best in initial pop: "  + bestCandidateOfInitialPop.cost);
		System.out.println("Best score achieved: " + bestScore);
		
		//return bestCandidate;
		return overallBestTab;
		
	}

}
