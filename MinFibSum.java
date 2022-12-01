import java.util.Scanner;
import java.util.ArrayList;

public class MinFibSum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer> fibonacciNumbers = new ArrayList<Integer>();
		fibonacciNumbers.add(1);
		for(int i = 1; i <= n;) {
			fibonacciNumbers.add(i);
			i = fibonacciNumbers.get(fibonacciNumbers.size() - 2) + fibonacciNumbers.get(fibonacciNumbers.size() - 1);
		}
		//System.out.println(fibonacciNumbers);
		ArrayList<Integer> minSum = new ArrayList<Integer>();
		for(int i = fibonacciNumbers.size() - 1; i > -1; i--) {
			while(n >= fibonacciNumbers.get(i)) {
				n -= fibonacciNumbers.get(i);
				minSum.add(fibonacciNumbers.get(i));
			}
		}
		//System.out.println(minSum);
		for(int i = minSum.size() - 1; i > -1; i--) {
			System.out.print(minSum.get(i) + " ");
		}
	}
}
