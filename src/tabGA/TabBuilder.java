package tabGA;

import java.io.PrintWriter;

public class TabBuilder {

	StringBuilder line = new StringBuilder("x      ");
		
	public void newLine(){
		line.delete(0, 7);
		line.append("x      ");
	}
	
public void addFingeredNote(FingeredNote fingNote){
		
		int intCourse = fingNote.getCourse();
		int intFret = fingNote.getFret();
		byte course = (byte)intCourse;
		char fret = Lute.FRET_POSITIONS[intFret];
		
		//until ready to handle durations
		char dur = 'x';
		
		// write duration
		//System.out.println("TABBUILDER: Duration line.insert: " + dur);
		line.deleteCharAt(0);
		line.insert(0, dur);
		
		//write finger position
		//System.out.println("TABBUILDER: Fingering line.insert: " + course + fret);
		line.deleteCharAt(course);
		line.insert(course, fret);
	}
	
	public void commitLine(PrintWriter pw){
		pw.println(line.toString());
	}
	
	
		
}
