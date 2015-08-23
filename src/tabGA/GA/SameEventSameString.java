package tabGA.GA;

import java.util.ArrayList;

import tabGA.Tab;

public class SameEventSameString {

	public static int getCost(Tab tab){
		
		int score = 0;
		int currentEvent;
		int lastEvent = 0;
		//ArrayList<Boolean> coursesInUse = new ArrayList<Boolean>();
		boolean[] coursesInUse = new boolean[6];
		
		for (int i=1; i<tab.getSize(); i++){
			
			currentEvent = tab.getFingeredNote(i).getEventNum();
			//System.out.println("This fingered note event: " + currentEvent + " and course: "+ tab.getFingeredNote(i).getCourse());
						
			if(currentEvent==lastEvent){
				//System.out.println("Same event trigger: course " );
				if(coursesInUse[tab.getFingeredNote(i).getCourse() - 1] == true){
					score += 100;
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
