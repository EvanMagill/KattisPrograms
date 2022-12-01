import java.util.ArrayList;
import java.util.Scanner;

public class Goldbach2 {
	public static ArrayList<Integer> orderedPrimes;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		orderedPrimes = new ArrayList<Integer>();
		orderedPrimes.add(2);
		int cases = input.nextInt();
		int[] testCases = new int[cases];
		int highestNumber = 2;
		for(int curCase = 0; curCase < cases; curCase ++) {
			int currentNumber = input.nextInt();
			testCases[curCase] = currentNumber;
			for(int i = highestNumber + 1; i < currentNumber; i += 2) {
				if(isPrime(i)) {
					orderedPrimes.add(i);
				}
			}
			int numSolutions = 0;
			int[] solutions = new int[currentNumber/3];
			for(int addendIndex = 0; orderedPrimes.get(addendIndex) <= currentNumber/2; addendIndex ++) {
				int addend1 = orderedPrimes.get(addendIndex);
				int addend2 = currentNumber - addend1;
				if(isPrime(addend2)) {
					solutions[numSolutions] = addend1;
					numSolutions ++;
				}
			}
			System.out.println(currentNumber + " has " + numSolutions + " representation(s)");
			for(int solution = 0; solution < numSolutions; solution ++) {
				System.out.println(solutions[solution] + "+" + (currentNumber - solutions[solution]));
			}
			System.out.println();
			if(currentNumber > highestNumber) {
				highestNumber = currentNumber;
			}
		}
		input.close();
	}
	public static boolean isPrime(int n) {
		boolean result = true;
		for(int i = 0; orderedPrimes.get(i) <= Math.sqrt(n); i ++) {
			if(n % orderedPrimes.get(i) == 0) {
				result = false;
			}
		}
		return result;
	}
}
