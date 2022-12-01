import java.util.Scanner;

public class PeriodicStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		String test;
		input.close();
		for(int k = 1; k < s.length(); k ++) {
			test = s.substring(0, k);
			for(int i = 0; i + k <= s.length(); i += k) {
				if(!test.equals(s.substring(i, i + k))) {
					break;
				}else if(i + k >= s.length()) {
					System.out.println(k);
					return;
				}
				test = test.charAt(k - 1) + test.substring(0, k - 1);
			}
		}
		System.out.println(s.length());
	}
}
