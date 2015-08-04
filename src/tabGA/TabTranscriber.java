package tabGA;

import java.io.PrintWriter;

public class TabTranscriber extends Transcriber{

	public void convertToCrippsTAB(Tab tab, Score score, PrintWriter pw){
		
		int lastEventNum = 1;
		int currentEventNum;
		TabBuilder tBuilder = new TabBuilder();
		
		for (int i=0; i<tab.getSize();i++){
			
			if(i%16==0){
				pw.println('b');
				pw.println();
				pw.println('b');
			}
			
			currentEventNum = score.getNoteAt(i).getEventNum();
			
			if(currentEventNum==lastEventNum){
				tBuilder.addFingeredNote(tab.getFingeredNote(i));
			} else {
				tBuilder.commitLine(pw);
				tBuilder.newLine();
				tBuilder.addFingeredNote(tab.getFingeredNote(i));

			}
			
			lastEventNum = currentEventNum;
			
		}
		
	}
	
}
