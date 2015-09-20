package tabGA;

import java.util.ArrayList;


/**
 * The Class FingeredNote represents the action of fretting
 * a note on the neck of the lute at the given fret and course.
 */
public class FingeredNote {
    
    /** The course being fingered. */
    int course;
    
    /** The fret being fingered. */
    int fret;
    
    /** The MIDI pitch of the note. */
    int pitch;
    
    /** The event number. */
    int eventNum;
    
    /** The lowest neck position. */
    boolean lowestNeckPosition;
    
    /**
     * Instantiates a new fingered note.
     *
     * @param course The course
     * @param fret The fret
     */
    // Places a finger at chosen string, fret location
    public FingeredNote(int course, int fret){
        this.course = course;
        this.fret = fret;
    }
    
    /**
     * Instantiates a new fingered note.
     *
     * @param str Accepts a fingeredNote expressed as a string.
     */
    public FingeredNote(String str){
    	
    	//this.course = (int)str.charAt(0);
    	this.course = Integer.parseInt(str.substring(0, 1));
    	this.fret = (int)Integer.parseInt(str.substring(1, str.length()));
    	
    }
    
    /**
     * Instantiates a new fingered note given a string and pitch.
     *
     * @param str the str
     * @param pitch the pitch
     */
    public FingeredNote(String str, int pitch){
    	this(str);
    	this.pitch = pitch;
    }
    
    /**
     * Instantiates a new fingered note.
     *
     * @param str the str
     * @param pitch the pitch
     * @param eventNum the event num
     */
    public FingeredNote(String str, int pitch, int eventNum){
    	this(str);
    	this.pitch = pitch;
    	this.eventNum = eventNum;
    }
    
    /**
     * Instantiates a new fingered note, handed with the size of the array for all legal
     * positions and the place of this option in that array. This enables the object to be
     * identified as the optimal solution, assuming that is the case.
     *
     * @param str The str
     * @param pitch The pitch
     * @param eventNum The event num
     * @param possOptions The number of poss options for this pitch
     * @param thisOption The poistion of this option in the array of options
     */
    public FingeredNote(String str, int pitch, int eventNum, int possOptions, int thisOption){
    	this(str);
    	this.pitch = pitch;
    	this.eventNum = eventNum;
    	
    	if(possOptions>(thisOption+1)){
    		lowestNeckPosition= false;
    		//System.out.println("Better alt available! Pitch:" + pitch + " Course: " + course + " Fret: " + fret);
    	} else {
    		lowestNeckPosition = true;
    		//System.out.println("Best option! Pitch:" + pitch + " Course: " + course + " Fret: " + fret);
    	}
    	
    	
    }
    
    /**
     * Lowest neck position.
     *
     * @return true if this FN is the optimal position
     */
    public boolean lowestNeckPosition(){
    	return lowestNeckPosition;
    }
    
    /**
     * Gets the course of the FN.
     *
     * @return the course
     */
    // Gets x coordinate
    public int getCourse(){
        return this.course;
    }
    
    /**
     * Gets the fret of the FN.
     *
     * @return the fret
     */
    // Gets y coordinate
    public int getFret(){
        return this.fret;
    }
    
    /**
     * Distance between the this object and a another given FN.
     *
     * @param fingeredNote the fingered note to compare against
     * @return a double
     */
    // Gets the distance between two finger positions
    public double distanceTo(FingeredNote fingeredNote){
        int xDistance = Math.abs(getCourse() - fingeredNote.getCourse());
        int yDistance = Math.abs(getFret() - fingeredNote.getFret());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return getCourse()+", "+getFret();
    }

	/**
	 * Gets a random alternative fingered note.
	 *
	 * @return the random alternative
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
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
	
	/**
	 * Gets the event num.
	 *
	 * @return the event num
	 */
	public int getEventNum(){
		return eventNum;
	}
	
	
	
}