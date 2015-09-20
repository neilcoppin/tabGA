package tabGA.GA;

import java.util.ArrayList;
import java.util.Random;

import tabGA.FingeredNote;
import tabGA.Lute;
import tabGA.Note;
import tabGA.Score;
import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class Population represents a population of candidate tabs.
 */
public class Population {
	
	/** The population. */
	ArrayList<Tab> population;
	
	/**
	 * Instantiates a new population.
	 */
	public Population(){
		population = new ArrayList<Tab>();
	}

	/**
	 * Instantiates a new population.
	 *
	 * @param score the score
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public Population(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		population = new ArrayList<Tab>();
		//System.out.println("POPULATION: About to build pop");
		
		for (int i = 0; i < GA.POPULATION_SIZE; i++) {

			population.add(getRandomTab(score));
			System.out.print(i+" ; ");
		}
		
		
		
	}

	/**
	 * Gets the random tab.
	 *
	 * @param score the score
	 * @return the random tab
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public static Tab  getRandomTab(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		ArrayList<FingeredNote> tab = new ArrayList<FingeredNote>();
				
		for (int i = 0; i<score.length(); i++){
			
			Note currentNote = score.getNoteAt(i);
			//System.out.println("POPULATION: current Note is: " + currentNote);
			ArrayList<FingeredNote> legalPositions = Lute.getLegalPositions(currentNote.getPitch(),currentNote.getEventNum());
			//System.out.println("POPULATION: legal positions are: " + legalPositions);
			Random randomGenerator = new Random();
			tab.add(legalPositions.get(randomGenerator.nextInt(legalPositions.size())));
			
			
		}
		
		
		
		Tab newTab = new Tab(tab);

		
		return newTab;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		
		String str = new String();
				
		for (int i = 0; i < population.size(); i++){
			
			str = str + population.get(i).toString();
			str = str + " NEXT TAB: ";
			//System.out.println(str);
		}
		
		return str;
		
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize(){
		return population.size();
	}
	
	/**
	 * Gets the tab at.
	 *
	 * @param i the i
	 * @return the tab at
	 */
	public Tab getTabAt(int i){
		return population.get(i);
	}

	/**
	 * Adds the individual.
	 *
	 * @param tab the tab
	 */
	public void addIndividual(Tab tab){
		population.add(tab);
	}
	

}
