import java.util.Arrays;
import java.util.Scanner;

public class Accounting {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		int[] values = new int[N+1];
		boolean[] overwrittenFromFill = new boolean[N+1];
		int filledWith = 0;
		int Q = console.nextInt();
		for(int i = 0; i < Q; i ++) {
			String instruction = console.next();
			switch(instruction.length()) {
				case 7:
					filledWith = console.nextInt();
					overwrittenFromFill = new boolean[N+1];
					//Arrays.fill(values, console.nextInt());
					break;
				case 5:
					int position = console.nextInt();
					if(overwrittenFromFill[position]) {
						System.out.println(values[position]);
					}else {
						System.out.println(filledWith);
					}
					break;
				default:
					int posToChange = console.nextInt();
					values[posToChange] = console.nextInt();
					overwrittenFromFill[posToChange] = true;
			}
		}
		console.close();
	}

}
