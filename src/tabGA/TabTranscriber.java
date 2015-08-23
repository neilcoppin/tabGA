package tabGA;

import java.io.PrintWriter;

public class TabTranscriber extends Transcriber{

	public void convertToCrippsTAB(Tab tab, Score score, PrintWriter pw) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		int lastEventNum = 1;
		int currentEventNum;
		TabBuilder tBuilder = new TabBuilder();
		tBuilder.newLine();
		
		for (int i=0; i<tab.getSize();i++){
			
			
			if(i%4==0){
				pw.println('b');
			}
			
			if(i%16==0){
				pw.println('b');
				pw.println();
				pw.println('b');
			}
			
			currentEventNum = score.getNoteAt(i).getEventNum();
			//System.out.println("Current event: " + currentEventNum +" Last Event: "+ lastEventNum);
			if(currentEventNum==lastEventNum){
				tBuilder.addFingeredNote(tab.getFingeredNote(i));
			} else {
				tBuilder.commitLine(pw);
				//System.out.println("Fingers/notes added: " + tBuilder.getCount());
				tBuilder.newLine();
				//System.out.println("Committing new line. Event " + currentEventNum);
				tBuilder.addFingeredNote(tab.getFingeredNote(i));

			}
			
			lastEventNum = currentEventNum;
			
		}
		
	}
	
}
