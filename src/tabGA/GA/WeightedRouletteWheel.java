package tabGA.GA;

import java.util.Random;
import java.util.TreeMap;

import tabGA.Tab;

public class WeightedRouletteWheel {

	TreeMap<Double, Tab> wheel;
	Random spin = new Random();

	public WeightedRouletteWheel(Population pop) {
		double total_fitness = 0.0;
		// for (Tab i : pop)
		for (int i = 0; i < pop.getSize(); i++) {
			total_fitness += fitness(pop.getTabAt(i));
		}
		wheel = new TreeMap<Double, Tab>();
		double key = 0.0;
		// for (Tab i : pop)
		for (int i = 0; i < pop.getSize(); i++) {
			double likelihood = fitness(pop.getTabAt(i)) / total_fitness;
			key += likelihood;
			wheel.put(key, pop.getTabAt(i));
		}
	}

	private Double fitness(Tab i) {
		return (1.0 / (i.getCost() + 1));
	}

	public Tab nextIndividual() {
		return getIndividual(spin.nextDouble());
	}

	
	public Tab getIndividual(double pocket) {
		Tab individual = wheel.get(wheel.tailMap(pocket).firstKey());
		if (individual == null) {
			throw new NullPointerException(
					"WeightedRouletteWheel: No individual at " + pocket);
		}
		return individual;
	}

}
