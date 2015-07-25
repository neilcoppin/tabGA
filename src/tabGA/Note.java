package tabGA;

public class Note {
	
	Integer pitch;
	Integer eventNum;
	
	public Note(Integer pitch, Integer eventNum){
		
		this.pitch = pitch;
		this.eventNum = eventNum;
		
	}
	
	public Note(String pitch, Integer eventNum){
		
		this.pitch = Integer.parseInt(pitch);
		this.eventNum = eventNum;
		
	}

	public String toString(){
		return "Pitch: " + pitch + ", Event num: " + eventNum;
	}
	
}
