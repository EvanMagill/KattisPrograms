import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Evan Magill
 * @date 2022-09-26
 */
public class A1Paper {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] papers = new int[n - 1];
		double A2SideLength = Math.pow(2, -3.0/4.0);
		for(int i = 0; i < n - 1; i ++) {
			papers[i] = input.nextInt();
		}
		input.close();
		papers = removeUnnecessaryPapers(papers);
		if(papers[0] != -1) {
			double lengthOfTape = tape(papers, A2SideLength);
			System.out.println(lengthOfTape);
		}else {
			System.out.println("impossible");
		}
	}
	
	public static int[] removeUnnecessaryPapers(int[] papers) {
		double curSum = 0.0;
		double toAdd = 0.0;
		for(int i = 0; i < papers.length; i ++) {
			toAdd = papers[i] * Math.pow(0.5, i + 1);
			double evalSum = curSum + toAdd;
			if(evalSum >= 1.0) {
				papers = Arrays.copyOf(papers, i + 1);
				if(evalSum == 1.0) {
					return papers;
				}else {
					papers[i] = (int)((1.0 - curSum)/Math.pow(0.5, i + 1));
					return papers;
				}
			}
			curSum += toAdd;
		}
		papers[0] = -1;
		return papers;
	}
	
	public static double tape(int[] papers, double A2SideLength) {
		double sum = 0.0;
		double root2 = Math.sqrt(2);
		for(int i = papers.length - 1; i > 0; i --) {
			sum += (papers[i]/2)*A2SideLength/Math.pow(root2, i);
			papers[i - 1] += papers[i]/2;
		}
		sum += A2SideLength;
		return sum;
		
	}
}
