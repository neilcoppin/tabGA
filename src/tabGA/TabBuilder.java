package tabGA;

import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class TabBuilder constructs a Cripps TAB formatted string.
 */
public class TabBuilder {

	/** The line. */
	StringBuilder line = new StringBuilder("x       ");
	
	/** The counter. */
	int counter = 0;
		
	/**
	 * New line.
	 */
	public void newLine(){
		line.delete(0, 8);
		line.append("x       ");
		counter = 0;
	}
	
/**
 * Adds the fingered note.
 *
 * @param fingNote the fing note
 * @throws IllegalArgumentException the illegal argument exception
 * @throws IllegalAccessException the illegal access exception
 * @throws NoSuchFieldException the no such field exception
 * @throws SecurityException the security exception
 */
public void addFingeredNote(FingeredNote fingNote) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		counter++;
		//System.out.println("Prior to adding note: " + line.toString());
		int intCourse = fingNote.getCourse();
		int intFret = fingNote.getFret();
		byte course = (byte)intCourse;
		char fret = Lute.FRET_POSITIONS[intFret];
		
		//until ready to handle durations
		char dur = 'x';
		
		// write duration
		//System.out.println("TABBUILDER: Duration line.insert: " + dur);
		//line.deleteCharAt(0);
		//line.insert(0, dur);
		
		//write finger position
		//System.out.println("TABBUILDER: Fingering line.insert: " + course + fret);
		
		if(line.charAt(intCourse)==' '){
			line.deleteCharAt(course);
			line.insert(course, fret);
		} else {
			
			FingeredNote altFingNote = fingNote.getRandomAlternative();
			//System.out.println("I was supposed to write " + course+", "+ intFret);
			/*
			if(intCourse == altFingNote.getCourse()){
				
			}*/
			
			intCourse = altFingNote.getCourse();
			intFret = altFingNote.getFret();
			course = (byte)intCourse;
			fret = Lute.FRET_POSITIONS[intFret];
			//System.out.println("But instead I wrote " + course+", "+ intFret);
			line.deleteCharAt(course);
			line.insert(course, fret);
			
			
		}
		
		//System.out.println("After adding note: " + line.toString());
		
	}
	
	/**
	 * Commit line.
	 *
	 * @param pw the printwriter
	 */
	public void commitLine(PrintWriter pw){
		pw.println(line.toString());
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {

		return counter;
	}
	
	
		
}
