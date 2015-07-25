package tabGA;

import java.util.ArrayList;

public class Tab {
	
	ArrayList<FingeredNote> tab = new ArrayList<FingeredNote>();
	
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
		
}
