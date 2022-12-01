import java.util.Scanner;

public class FieldTrip {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		int[] sections = new int[N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += sections[i] = console.nextInt();
		}
		console.close();
		int busPop = total / 3;
		int firstBusEnd = 0;
		if (busPop * 3 == total) {
			int curBusPop = 0;
			for (int i = 1; i <= N && curBusPop < busPop; i++) {
				curBusPop += sections[i - 1];
				if(curBusPop == busPop) {
					curBusPop = 0;
					if(firstBusEnd == 0) {
						firstBusEnd = i;
					}else {
						System.out.println(firstBusEnd + " " + i);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
