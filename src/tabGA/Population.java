package tabGA;

import java.util.ArrayList;
import java.util.Random;

public class Population {

	public Population(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		ArrayList<Tab> population = new ArrayList<Tab>(GA.POPULATION_SIZE);

		for (int i = 0; i < population.size(); i++) {

			population.add(getRandomTab(score));
			
		}
		
		System.out.println(population.toString());

	}

	public static Tab  getRandomTab(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		ArrayList<FingeredNote> tab = new ArrayList<FingeredNote>();
				
		for (int i = 0; i<score.length(); i++){
			
			Note currentNote = score.getNoteAt(i);
			ArrayList<FingeredNote> legalPositions = Lute.getLegalPositions(currentNote.pitch);
			Random randomGenerator = new Random();
			tab.add(legalPositions.get(randomGenerator.nextInt(legalPositions.size())));
			
			
		}
		
		Tab newTab = new Tab(tab);

		
		return newTab;
	}

	

}
