import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Evan Magill
 * @date 2022-09-26
 */
public class A1PaperV1 {

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
		boolean solved = false;
		while(!solved) {
			if(papers[0] > 1) {
				solved = true;
				if(papers[0] > 2) {
					//System.out.println("Overshot");
				}
				return lengthOfTape;
			}
			boolean combined = false;
			int i = 1;
			while(!combined) {
				if(i >= papers.length) {
					return -1.0;//Unsolvable
				}
				if(papers[i] > 1) {
					papers[i] -= 2;
					papers[i - 1] ++;
					lengthOfTape += A2SideLength/Math.pow(Math.sqrt(2), i);
					combined = true;
				}
				i ++;
			}
		}
		return -1.0;//Should have already returned a quantity.
	}
}
