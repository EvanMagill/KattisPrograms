import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Evan Magill
 * @date 2022-09-26
 */
public class A1PaperV2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] papers = new int[n - 1];
		double A2SideLength = Math.pow(2, -3.0/4.0);
		for(int i = 0; i < n - 1; i ++) {
			papers[i] = input.nextInt();
		}
		input.close();
		double lengthOfTape = tape(papers, A2SideLength);
		if(lengthOfTape < A2SideLength) {
			System.out.println("impossible");
		}else {
			System.out.println(lengthOfTape);
		}
		
	}
	public static double tape(int[] papers, double A2SideLength) {
		double lengthOfTape = A2SideLength;
		if(papers[0] > 1) {
			return lengthOfTape;
		}
		for(int i = 0; i < papers.length; i ++) {
			while(papers[i] > 1) {
				lengthOfTape += propagateTape(papers, A2SideLength, i);
				if(papers[0] > 1) {
					return lengthOfTape;
				}
			}
		}
		if(papers[0] > 1) {
			return lengthOfTape;
		}
		return -1.0;
	}
	private static double propagateTape(int[] papers, double A2SideLength, int i) {
		double result = 0.0;
		while(papers[i] > 1 && i > 0) {
			papers[i-1] ++;
			papers[i] -= 2;
			result += A2SideLength/Math.pow(Math.sqrt(2), i);
			i --;
		}
		return result;
	}
}
