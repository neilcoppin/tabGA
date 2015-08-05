package tabGA.GA;

import tabGA.Score;
import tabGA.Tab;

public class GA {
	
	//Set mutation rate etc here
	public static final Integer POPULATION_SIZE = 100;
	public static final Integer NUM_OF_GENERATIONS = 100;
	
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
		Population currentPop;
		
		for (int i=0; i<NUM_OF_GENERATIONS; i++){
			
		}
		
		
		
		
		
		return bestCandidate;
		
	}

}
