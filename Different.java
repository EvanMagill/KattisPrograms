import java.util.Scanner;
import java.lang.Math;

public class Different {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLong()) {
			long int1 = input.nextLong();
			long int2 = input.nextLong();
			System.out.println(Math.abs(int1 - int2));
		}
		input.close();
	}
}