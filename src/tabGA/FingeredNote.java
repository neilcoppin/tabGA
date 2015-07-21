package tabGA;

public class FingeredNote {
    int course;
    int fret;
    
    // Places a finger at chosen string, fret location
    public FingeredNote(int string, int fret){
        this.course = string;
        this.fret = fret;
    }
    
    public FingeredNote(String str){
    	
    	this.course = (int)str.charAt(0);
    	this.fret = (int)Integer.parseInt(str.substring(1, str.length()));
    	
    }
    
    // Gets x coordinate
    public int getString(){
        return this.course;
    }
    
    // Gets y coordinate
    public int getFret(){
        return this.fret;
    }
    
    // Gets the distance between two finger positions
    public double distanceTo(FingeredNote fingeredNote){
        int xDistance = Math.abs(getString() - fingeredNote.getString());
        int yDistance = Math.abs(getFret() - fingeredNote.getFret());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getString()+", "+getFret();
    }
}