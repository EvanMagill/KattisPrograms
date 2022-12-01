import java.util.Scanner;

public class ThreeDPrintedStatuesV2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int statues = input.nextInt();
		input.close();
		System.out.println((int)Math.max(1, Math.floor(Math.log(statues-1)/Math.log(2)) + 2));
	}

}
