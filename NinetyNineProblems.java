import java.util.Scanner;

public class NinetyNineProblems {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int curPrice = console.nextInt();
		int offset = curPrice % 100 + 1;
		console.close();
		if(curPrice < 149) {
			System.out.println(99);
			return;
		}
		if(offset >= 50) {
			offset = -100 + offset;
		}
		System.out.println(curPrice - offset);
	}

}
