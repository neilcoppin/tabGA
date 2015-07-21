package tabGA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("input.txt"));
		Score score = new Score();
		Integer eventNum = new Integer(0);
		GA ga = new GA();

		while (scanner.hasNext()) {

			eventNum++;
			System.out.println(scanner.next());
			score.addNote(new Note(scanner.next(), eventNum));

		}
		scanner.close();

		ga.start(score);
		

	}

}
