package tabGA;

import java.util.ArrayList;
import java.util.Random;

public class Population {
	
	ArrayList<Tab> population;

	public Population(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		population = new ArrayList<Tab>();
		
		for (int i = 0; i < GA.POPULATION_SIZE; i++) {

			population.add(getRandomTab(score));
			//System.out.println(population.get(i).toString());
		}
		
		
		
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
	
	public String toString(){
		
		String str = new String();
				
		for (int i = 0; i < population.size(); i++){
			
			str = str + population.get(i).toString();
			str = str + " NEXT TAB: ";
			//System.out.println(str);
		}
		
		return str;
		
	}

	

}
