import java.util.Scanner;

public class Stockbroker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int days = input.nextInt();
		long money = 100l;
		int shares = 0;
		int[] sharePrice = new int[days];
		sharePrice[0] = input.nextInt();
		for(int day = 1; day < days; day ++) {
			int todaysPrice = sharePrice[day - 1];
			int tomorrowsPrice = input.nextInt();
			sharePrice[day] = tomorrowsPrice;
			if(money >= todaysPrice && tomorrowsPrice > todaysPrice && shares != 100000) {
				int priceMaxShares = (100000 - shares) * todaysPrice;
				int newShares;
				if(money > priceMaxShares) {
					newShares = 100000 - shares;
				}else {
					newShares = (int)(money/todaysPrice);
				}
				money -= newShares * todaysPrice;
				shares += newShares;
				//System.out.println(money);
			}else if(todaysPrice > tomorrowsPrice) {
				if(shares * todaysPrice < 0) {
					//System.out.println("shares: " + shares);
					//System.out.println("today's price: " + todaysPrice);
					//System.out.println("tomorrow's price: " + tomorrowsPrice);
				}
				money += shares * todaysPrice;
				shares = 0;
				//System.out.println(money);
			}
		}
		money += shares * sharePrice[sharePrice.length - 1];
		System.out.println(money);
		input.close();
	}

}
