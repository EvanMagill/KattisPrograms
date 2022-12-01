import java.util.Scanner;

public class ThreeDPrintedStatues {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int statues = input.nextInt();
		input.close();
		int sum = 1;
		int comparison = 1;
		while(statues > comparison) {
			sum ++;
			comparison = comparison << 1;
		}
		System.out.println(sum);
	}

}
