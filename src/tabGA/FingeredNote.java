package tabGA;

import java.util.ArrayList;

public class FingeredNote {
    int course;
    int fret;
    int pitch;
    int eventNum;
    
    // Places a finger at chosen string, fret location
    public FingeredNote(int course, int fret){
        this.course = course;
        this.fret = fret;
    }
    
    public FingeredNote(String str){
    	
    	//this.course = (int)str.charAt(0);
    	this.course = Integer.parseInt(str.substring(0, 1));
    	this.fret = (int)Integer.parseInt(str.substring(1, str.length()));
    	
    }
    
    public FingeredNote(String str, int pitch){
    	this(str);
    	this.pitch = pitch;
    }
    
    public FingeredNote(String str, int pitch, int eventNum){
    	this(str);
    	this.pitch = pitch;
    	this.eventNum = eventNum;
    }
    
    // Gets x coordinate
    public int getCourse(){
        return this.course;
    }
    
    // Gets y coordinate
    public int getFret(){
        return this.fret;
    }
    
    // Gets the distance between two finger positions
    public double distanceTo(FingeredNote fingeredNote){
        int xDistance = Math.abs(getCourse() - fingeredNote.getCourse());
        int yDistance = Math.abs(getFret() - fingeredNote.getFret());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getCourse()+", "+getFret();
    }

	public FingeredNote getRandomAlternative() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		ArrayList<FingeredNote> possibleFingeredNotes = Lute.getLegalPositions(pitch, eventNum);
		FingeredNote newFNote = null;
		
		if(possibleFingeredNotes.size()<=1){
			return this;
		}
		
		String currentPosition = Integer.toString(course) + Integer.toString(fret);
		
		boolean unique = false;
		while(!unique)
		
			for(int i=0;i<possibleFingeredNotes.size();i++){
								
				String potentialPosition = Integer.toString(possibleFingeredNotes.get(i).getCourse()) + Integer.toString(possibleFingeredNotes.get(i).getFret());
				if(currentPosition.equalsIgnoreCase(potentialPosition)){
					//do nothing
				} else {
					newFNote = possibleFingeredNotes.get(i);
					unique = true;
				}
				
								
			}
			
		return newFNote;
	}
	
	public int getEventNum(){
		return eventNum;
	}
	
	
	
}