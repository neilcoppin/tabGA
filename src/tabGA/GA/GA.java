package tabGA.GA;

import tabGA.Score;
import tabGA.Tab;

public class GA {
	
	//Set mutation rate etc here
	public static final Integer POPULATION_SIZE = 100;
	
	Score score;
	Tab bestCandidate;
	
	
	public Tab start(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		this.score = score;
		Population initialPop;
		
		initialPop = new Population(this.score);
		
		System.out.println(initialPop.toString());
		
		bestCandidate = FitnessFunction.getFittestIndividual(initialPop);
		
		
		
		return bestCandidate;
		
	}

}
