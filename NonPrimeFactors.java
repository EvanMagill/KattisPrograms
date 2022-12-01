import java.util.ArrayList;
import java.util.Scanner;

public class NonPrimeFactors {
	private static ArrayList<Integer> orderedPrimes = new ArrayList<Integer>();

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

	public static ArrayList<Integer> getPrimeFactors(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int index = 0;
		while (n > 1) {
			int nextPrime = lowestPrimeFactor(n);
			while (n % nextPrime == 0) {
				n /= nextPrime;
				result.add(nextPrime);
			}
		}
		return result;
	}

	public static ArrayList<Integer> numOccurrencesOfSortedElements(ArrayList<Integer> sortedList) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (sortedList.size() == 0) {
			return result;
		}
		int count = 1;
		int num = sortedList.get(0);
		for (int i = 1; i < sortedList.size(); i++) {
			if (sortedList.get(i) == num) {
				count++;
			} else {
				result.add(count);
				num = sortedList.get(i);
				count = 1;
			}
		}
		result.add(count);
		return result;
	}

	public static int numNonPrimeFactors(int n) {
		int result = 1;
		ArrayList<Integer> occurrenceOfPrimeFactors = numOccurrencesOfSortedElements(getPrimeFactors(n));
		for (int i = 0; i < occurrenceOfPrimeFactors.size(); i++) {
			result *= occurrenceOfPrimeFactors.get(i) + 1;
		}
		result -= occurrenceOfPrimeFactors.size();
		return result;
	}

	public static void main(String[] args) {
		orderedPrimes.add(2);
		orderedPrimes.add(3);
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		for (int i = 0; i < numCases; i++) {
			System.out.println(numNonPrimeFactors(input.nextInt()));
		}
	}

}
