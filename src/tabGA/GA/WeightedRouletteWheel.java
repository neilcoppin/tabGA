package tabGA.GA;

import java.util.Random;
import java.util.TreeMap;

import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class WeightedRouletteWheel is used for probability distribution 
 * and represents a weighted roulette wheel.
 */
public class WeightedRouletteWheel {

	/** The wheel. */
	TreeMap<Double, Tab> wheel;
	
	/** The spin. */
	Random spin = new Random();

	/**
	 * Instantiates a new weighted roulette wheel from a population.
	 *
	 * @param pop the pop
	 */
	public WeightedRouletteWheel(Population pop) {
		double totalFitness = 0.0;
		// for (Tab i : pop)
		for (int i = 0; i < pop.getSize(); i++) {
			totalFitness += fitness(pop.getTabAt(i));
		}
		//System.out.println("Total Fitness: " + totalFitness);
		wheel = new TreeMap<Double, Tab>();
		double key = 0.0;
		// for (Tab i : pop)
		for (int i = 0; i < pop.getSize(); i++) {
			double likelihood = fitness(pop.getTabAt(i)) / totalFitness;
			key += likelihood;
			wheel.put(key, pop.getTabAt(i));
			//System.out.println("WRW: Tab fitness: " + fitness(pop.getTabAt(i))
				//	+ " ; Key: " + key);
		}
		 
	}

	/**
	 * Fitness.
	 *
	 * @param i the i
	 * @return the double
	 */
	private Double fitness(Tab i) {
		return (1.0 / (i.getCost() + 1));
	}

	/**
	 * Next individual.
	 *
	 * @return the tab
	 */
	public Tab nextIndividual() {
		return getIndividual(spin.nextDouble());
	}

	/**
	 * Gets the individual.
	 *
	 * @param pocket the pocket
	 * @return the individual
	 */
	public Tab getIndividual(double pocket) {
		// Double getDub = wheel.tailMap(pocket).firstKey();
		// Tab individual = wheel.get(getDub);
		Tab individual = wheel.get(wheel.tailMap(pocket).firstKey());
		if (individual == null) {
			throw new NullPointerException(
					"WeightedRouletteWheel: No individual at " + pocket);
		}
		 //System.out.println("Pocket: " + pocket + " ; individual: " + individual.getCost());
		 //System.out.println("Pocket: " + pocket);
		
		return individual;
	}

	

}
