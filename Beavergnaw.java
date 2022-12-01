import java.util.Scanner;

public class Beavergnaw {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int D = input.nextInt();
		int V = input.nextInt();
		while(D != 0 || V != 0) {
			double d = Math.cbrt((D * D * D) - ((6*V)/Math.PI));
			System.out.println(d);
			D = input.nextInt();
			V = input.nextInt();
		}
		input.close();
	}

}
