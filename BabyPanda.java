import java.util.Scanner;

public class BabyPanda {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long day = input.nextLong();
		long total = input.nextLong();
		//int firstBit = (int)Math.floor(Math.log(total)/Math.log(2));
		int count = 0;
		while(total > 0) {
			if(total%2 == 1) {
				count ++;
				total --;
			}else {
				total /= 2;
			}
		}
		System.out.println(count);
	}

}
