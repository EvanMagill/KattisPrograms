import java.util.Scanner;
import java.util.Arrays;

public class DASort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTests = input.nextInt();
		for(int i = 0; i < numTests; i ++) {
			int testNumber = input.nextInt();
			int arrayLength = input.nextInt();
			int[] arrayToSort = new int[arrayLength];
			for(int j = 0; j < arrayLength; j ++) {
				arrayToSort[j] = input.nextInt();
			}
			int[] testing = Arrays.copyOf(arrayToSort, arrayLength);
			Arrays.sort(arrayToSort);
			int matched = 0;
			for(int j = 0; j < arrayLength; j ++) {
				if(testing[j] == arrayToSort[matched]) {
					matched ++;
				}
			}
			System.out.println(testNumber + " " + (arrayLength - matched));
		}
		input.close();
	}

}
