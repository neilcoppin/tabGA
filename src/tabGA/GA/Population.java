package tabGA.GA;

import java.util.ArrayList;
import java.util.Random;

import tabGA.FingeredNote;
import tabGA.Lute;
import tabGA.Note;
import tabGA.Score;
import tabGA.Tab;

public class Population {
	
	ArrayList<Tab> population;
	
	public Population(){
		population = new ArrayList<Tab>();
	}

	public Population(Score score) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		population = new ArrayList<Tab>();
		//System.out.println("POPULATION: About to build pop");
		
		for (int i = 0; i < GA.POPULATION_SIZE; i++) {

			population.add(getRandomTab(score));
			//System.out.println(population.get(i).toString());
		}
		
		
		
	}

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
	
	public String toString(){
		
		String str = new String();
				
		for (int i = 0; i < population.size(); i++){
			
			str = str + population.get(i).toString();
			str = str + " NEXT TAB: ";
			//System.out.println(str);
		}
		
		return str;
		
	}
	
	public int getSize(){
		return population.size();
	}
	
	public Tab getTabAt(int i){
		return population.get(i);
	}

	public void addIndividual(Tab tab){
		population.add(tab);
	}
	

}
