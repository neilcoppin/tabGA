package tabGA;

import java.util.ArrayList;

public class Tab {
	
	public ArrayList<FingeredNote> tab = new ArrayList<FingeredNote>();
	public int cost = 0;
	
	public Tab(ArrayList<FingeredNote> tb){
		
		this.tab = tb;
		
	}
	
	public String toString(){
		
		String str = new String();
		for (int i=0; i<tab.size(); i++){
			str = str + tab.get(i).toString();
			str = str + "; ";
		}
		
		return str;
		
	}
	
	public FingeredNote getFingeredNote(int i){
		return tab.get(i);
	}
	
	public int getSize(){
		
		return tab.size();
	}
		
}
