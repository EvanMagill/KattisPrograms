import java.math.BigInteger;
import java.util.Scanner;

public class Popcorn {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		BigInteger N = new BigInteger(console.next());
		console.close();
		BigInteger FOUR = new BigInteger("4");
		N = N.divide(FOUR);
		N = N.multiply(N.subtract(BigInteger.ONE)).multiply(BigInteger.TWO).add(FOUR);
		System.out.println(N);
	}

}
