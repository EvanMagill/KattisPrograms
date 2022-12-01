import java.util.Scanner;

public class ForcedChoice {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int P = input.nextInt();
		int S = input.nextInt();
		input.nextLine();
		for(int i = 0; i < S; i ++) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			boolean guessContainsDesiredCard = false;
			int numberOfInts = lineScan.nextInt();
			for(int j = 0; j < numberOfInts; j ++) {
				if(lineScan.nextInt() == P) {
					guessContainsDesiredCard = true;
				}
			}
			lineScan.close();
			String decision = "REMOVE";
			if(guessContainsDesiredCard) {
				decision = "KEEP";
			}
			System.out.println(decision);
		}
		input.close();
	}

}
