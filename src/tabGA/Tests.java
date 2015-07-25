package tabGA;

import java.util.ArrayList;

public class Tests {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		ArrayList<FingeredNote> str = Lute.getLegalPositions(50);
		
		for (int i = 0; i<str.size(); i++){
			System.out.println(str.get(i));
		}
		
	}

}
