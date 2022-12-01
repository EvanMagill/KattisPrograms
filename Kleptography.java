import java.util.Scanner;

public class Kleptography {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		input.nextLine();
		String endWord = input.nextLine();
		String encrypted = input.nextLine();
		int keyLength = n + m;
		int[] key = new int[keyLength];
		String primer = "";// just for fun.
		String message = "";
		for(int i = m; i < keyLength; i ++) {
			key[i] = endWord.charAt(i - m) - 'a';
		}
		for(int i = keyLength - 1; i > n; i --) {
			key[i - n] = (encrypted.charAt(i - n) - 'a' - key[i] + 26) % 26;
		}
		for(int i = n; i < keyLength; i ++) {
			message += (char)(key[i] + 'a');
		}
		for(int i = 0; i < n; i ++) {
			primer += (char)(key[i] + 'a');
		}
		System.out.println(message);
		//System.out.println(primer);
	}

}
