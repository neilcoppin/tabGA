package tabGA;

import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class TabTranscriber.
 */
public class TabTranscriber extends Transcriber{

	/**
	 * Convert to cripps tab.
	 *
	 * @param tab the tab
	 * @param score the score
	 * @param pw the pw
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public void convertToCrippsTAB(Tab tab, Score score, PrintWriter pw) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		int lastEventNum = 0;
		int currentEventNum;
		TabBuilder tBuilder = new TabBuilder();
		tBuilder.newLine();
		int lineBreakCounter = 0;
		
		for (int i=0; i<tab.getSize();i++){
			
			/*
			if(i%4==0){
				pw.println('b');
			}
			
			if(i%16==0){
				pw.println('b');
				pw.println();
				pw.println('b');
			}
			*/
			
			currentEventNum = score.getNoteAt(i).getEventNum();
			//System.out.println("Current event: " + currentEventNum +" Last Event: "+ lastEventNum);
			if(currentEventNum==lastEventNum){
				tBuilder.addFingeredNote(tab.getFingeredNote(i));
			} else {
				//System.out.println("currentEventNum: " + currentEventNum + " ; lasteventnum: " + lastEventNum);
				tBuilder.commitLine(pw);
				//System.out.println("Fingers/notes added: " + tBuilder.getCount());
				tBuilder.newLine();
				//System.out.println("Committing new line. Event " + currentEventNum);
				tBuilder.addFingeredNote(tab.getFingeredNote(i));
				
				lineBreakCounter++;
				if (lineBreakCounter==16){
					pw.println('b');
					pw.println();
					pw.println('b');
					lineBreakCounter=0;
				}else if (lineBreakCounter==12){
					pw.println('b');
				}else if (lineBreakCounter==8){
					pw.println('b');
				}else if (lineBreakCounter==4){
					pw.println('b');
				}

			}
			
			
			
			lastEventNum = currentEventNum;
			
		}
		
	}
	
}
