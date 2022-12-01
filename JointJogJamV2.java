import java.util.Scanner;

public class JointJogJamV2 {

	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		int[] d = new int[8];
		for(int j=0;j<8;j++) {
			d[j] = i.nextInt();
		}
		System.out.println(Math.max(D(d[0],d[1],d[2],d[3]),D(d[4],d[5],d[6],d[7])));
	}
	
	public static double D(int a, int b, int c, int d) {
		return Math.sqrt((a-c)*(a-c) + (b-d)*(b-d));
	}
}
