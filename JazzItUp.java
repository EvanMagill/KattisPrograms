import java.util.ArrayList;
import java.util.Scanner;

public class JazzItUp {
	private static ArrayList<Integer> orderedPrimes = new ArrayList<Integer>();
	
	public static int lowestUnusedPrimeFactor(int n) {
		int result = n;
		for (int i = 0; orderedPrimes.get(i) <= n; i++) {
			if (n % orderedPrimes.get(i) != 0) {
				result = orderedPrimes.get(i);
				return result;
			}
			if (i + 1 == orderedPrimes.size()) {
				int nextPrime = Math.max(3, orderedPrimes.get(i)) + 2;// Don't want even numbers (2 + 2).
				while (lowestPrimeFactor(nextPrime) != nextPrime) {
					nextPrime += 2;
				}
				orderedPrimes.add(nextPrime);
			}
		}
		return result;
	}
	
	public static int lowestPrimeFactor(int n) {
		int result = n;
		for (int i = 0; orderedPrimes.get(i) <= Math.sqrt(n); i++) {
			if (n % orderedPrimes.get(i) == 0) {
				result = orderedPrimes.get(i);
				return result;
			}
			if (i + 1 == orderedPrimes.size()) {
				int nextPrime = Math.max(3, orderedPrimes.get(i)) + 2;// Don't want even numbers (2 + 2).
				while (lowestPrimeFactor(nextPrime) != nextPrime) {
					nextPrime += 2;
				}
				orderedPrimes.add(nextPrime);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		orderedPrimes.add(2);
		orderedPrimes.add(3);
		orderedPrimes.add(5);
		orderedPrimes.add(7);
		Scanner console = new Scanner(System.in);
		System.out.println(lowestUnusedPrimeFactor(console.nextInt()));
		console.close();
	}

}
