package tabGA.GA;

import java.util.Random;

import tabGA.FingeredNote;
import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class Evolver handles the evolutionary process of passing
 * genes from two parents to the children when creating the next
 * population.
 */
public class Evolver {
	
	/** The Constant MUTATION_RATE. */
	private final static double MUTATION_RATE = 0.08;

	/**
	 * Creates the next generation.
	 *
	 * @param pop the pop
	 * @return the population
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public static Population createNextGeneration(Population pop) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		WeightedRouletteWheel wheel = new WeightedRouletteWheel(pop);
		Population newPop = new Population();

		while (pop.getSize()>newPop.getSize()){
			Tab[] parents = getParents(wheel);
			Tab[] children = crossover(parents);
			mutate(children[0]);
			mutate(children[1]);
			newPop.addIndividual(children[0]);
			newPop.addIndividual(children[1]);
		}
		
		//System.out.println(FitnessFunction.getFittestIndividual(newPop).toString());
		
		return newPop;

	}

	/**
	 * Mutate.
	 *
	 * @param child the child
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	private static void mutate(Tab child) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Random rand = new Random();
				
		for(int i=0;i<child.getSize();i++){
			if(rand.nextDouble()<MUTATION_RATE){
				FingeredNote newFNote = child.getFingeredNote(i).getRandomAlternative();
				//System.out.println("MUTATING! Replacing Note: " + child.getFingeredNote(i).toString() + " with " + newFNote.toString());
				child.replaceFingeredNote(i, newFNote);
				
			}
		}
		
	}

	/**
	 * Crossover.
	 *
	 * @param parents the parents
	 * @return the tab[]
	 */
	private static Tab[] crossover(Tab[] parents) {

		Random rand = new Random();
		Tab x = parents[0];
		Tab y = parents[1];
				
				
		boolean[] pattern = new boolean[x.getSize()];
		for(int i=0; i<x.getSize(); i++){
			pattern[i] = rand.nextBoolean(); 
		}
		
		/*
		System.out.print("The crossover pattern is: ");
		for (boolean i : pattern){
			System.out.print(i + "; ");
		}
		*/
		
		
		for(int i=0; i<x.getSize(); i++){
			
			if(pattern[i]==true){
				FingeredNote temp = x.getFingeredNote(i);
				x.replaceFingeredNote(i, y.getFingeredNote(i));
				y.replaceFingeredNote(i, temp);
			} else {
				//do nothing
			}
			
		}
		
		return new Tab[]{x,y};
		
	}

	

	/**
	 * Gets the parents.
	 *
	 * @param wheel the wheel
	 * @return the parents
	 */
	private static Tab[] getParents(WeightedRouletteWheel wheel) {
		
		Tab[] parents;
		
		Tab parentX = wheel.nextIndividual();
		Tab parentY = wheel.nextIndividual();
		
		parents = new Tab[] {parentX, parentY};
		
		return parents;
	}

	

}
