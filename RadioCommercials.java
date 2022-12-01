import java.util.Scanner;

public class RadioCommercials {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int breaks = console.nextInt();
		int price = console.nextInt();
		int curProfit = 0;
		int bestProfit = 0;
		for(int i = 0; i < breaks; i++) {
			int curBreak = console.nextInt() - price;
			curProfit += curBreak;
			if(curProfit < 0) {
				curProfit = 0;
			}else if(curProfit > bestProfit) {
				bestProfit = curProfit;
			}
		}
		console.close();
		System.out.println(bestProfit);
	}
}
