import java.util.Scanner;

public class Arithmetic {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String octal = console.next();
		console.close();
		while(octal.length() % 4 != 0) {
			octal = '0' + octal;
		}
		for(int i = 3; i < octal.length(); i += 4) {
			int twelveBits = 0;
			for(int j = 0; j < 4; ++j) {
				int octalBit = octal.charAt(i - j) - '0';
				twelveBits += (octalBit << (j*3));
			}
			if(i == 3) {
				System.out.printf("%X", twelveBits);
			}else {
				System.out.printf("%03X", twelveBits);
			}
		}
	}
}