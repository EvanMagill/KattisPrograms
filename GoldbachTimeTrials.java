import java.util.ArrayList;

public class GoldbachTimeTrials {
	public static ArrayList<Integer> orderedPrimes;
	public static void main(String[] args) {
		orderedPrimes = new ArrayList<Integer>();
		orderedPrimes.add(2);
		int[] testCases = {1000000};
		int cases = testCases.length;
		int highestNumber = 2;
		for(int curCase = 0; curCase < cases; curCase ++) {
			int currentNumber = testCases[curCase];
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
				//System.out.println(solutions[solution] + "+" + (currentNumber - solutions[solution]));
			}
			//System.out.println();
			if(currentNumber > highestNumber) {
				highestNumber = currentNumber;
			}
		}
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
