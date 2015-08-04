package tabGA;

public class FingeredNote {
    int course;
    int fret;
    
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
}