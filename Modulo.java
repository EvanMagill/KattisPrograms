import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] results = new int[42];
		for(int i = 0; i < 10; i ++) {
			results[input.nextInt()%42] ++;
		}
		int result = 0;
		for(int i = 0; i < 42; i ++) {
			if(results[i] != 0) {
				result ++;
			}
		}
		System.out.print(result);
	}

}
