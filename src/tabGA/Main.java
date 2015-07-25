package tabGA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		Scanner scanner = new Scanner(new File("input.txt"));
		Score score = new Score();
		Integer eventNum = 1;
		GA ga = new GA();
		

		while (scanner.hasNext()) {

			Note nte = new Note(scanner.next(),eventNum);
			//System.out.println(nte.toString());
			score.addNote(nte);
			eventNum++;
		}
		
		scanner.close();

		ga.start(score);
		

	}

}
