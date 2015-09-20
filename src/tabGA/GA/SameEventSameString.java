package tabGA.GA;

import java.util.ArrayList;

import tabGA.Tab;

// TODO: Auto-generated Javadoc
/**
 * The Class SameEventSameString is used penalise tabs that attempt
 * to play two FNs within a chord on the same course.
 */
public class SameEventSameString {

	/**
	 * Gets the cost.
	 *
	 * @param tab the tab
	 * @return the cost
	 */
	public static int getCost(Tab tab){
		
		int score = 0;
		int currentEvent;
		int lastEvent = 0;
		//ArrayList<Boolean> coursesInUse = new ArrayList<Boolean>();
		boolean[] coursesInUse = new boolean[7];
		
		for (int i=1; i<tab.getSize(); i++){
			
			currentEvent = tab.getFingeredNote(i).getEventNum();
			//System.out.println("This fingered note event: " + currentEvent + " and course: "+ tab.getFingeredNote(i).getCourse());
						
			if(currentEvent==lastEvent){
				//System.out.println("Same event trigger: course " );
				if(coursesInUse[tab.getFingeredNote(i).getCourse() - 1] == true){
					score += FitnessFunction.PENALTY_CLASS_A;
				}
				
				coursesInUse[tab.getFingeredNote(i).getCourse() - 1] = true;
				
			} else {
				for (int c= 0; c==5; c++){
					coursesInUse[c]=false;
				}
				
				coursesInUse[tab.getFingeredNote(i).getCourse() - 1] = true;
			}
			
			lastEvent = currentEvent;
			
		}
		
		//System.out.println("Score for tab: " + score);
		return score;
	}
	
}
