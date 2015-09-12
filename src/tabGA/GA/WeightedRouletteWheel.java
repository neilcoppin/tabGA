package tabGA.GA;

import java.util.Random;
import java.util.TreeMap;

import tabGA.Tab;

public class WeightedRouletteWheel {

	TreeMap<Double, Tab> wheel;
	Random spin = new Random();

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

	private Double fitness(Tab i) {
		return (1.0 / (i.getCost() + 1));
	}

	public Tab nextIndividual() {
		return getIndividual(spin.nextDouble());
	}

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
