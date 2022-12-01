import java.util.Arrays;
import java.util.Scanner;

public class FinancialPlanning implements Comparable<FinancialPlanning> {
	public int dailyProfit;
	public int initialCost;
	public int firstProfitDay;
	
	public FinancialPlanning(int dailyProfit, int initialCost) {
		this.dailyProfit = dailyProfit;
		this.initialCost = initialCost;
		firstProfitDay = firstDayToProfit(dailyProfit, initialCost);
	}
	
	public static int firstDayToProfit(int dailyProfit, int initialCost) {
		return initialCost/dailyProfit + 1;
	}
	
	public int profitOnDay(int day) {
		return dailyProfit * day - initialCost;
	}
	
	public int compareTo(FinancialPlanning other) {
		return firstProfitDay - other.firstProfitDay;
	}
	
	@Override
	public String toString() {
		return "First day to profit: " + firstProfitDay + ", Daily profit: " + dailyProfit + ", Initial cost: " + initialCost;
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int investmentOptions = console.nextInt();
		int moneyToRetire = console.nextInt();
		FinancialPlanning[] investments = new FinancialPlanning[investmentOptions];
		for(int i = 0; i < investmentOptions; i ++) {
			investments[i] = new FinancialPlanning(console.nextInt(), console.nextInt());
		}
		console.close();
		Arrays.sort(investments);
		for(int i = 0; i < investments.length; i++) {
			System.out.println(investments[i].toString());
		}
		
		int day = 1;
		int curDailyProfits = 0;
		int curInitialCosts = 0;
		int investmentIndex = 0;
		while(curDailyProfits * day < curInitialCosts + moneyToRetire) {
			for(; investmentIndex < investments.length;) {
				if(day >= investments[investmentIndex].firstProfitDay) {
					curDailyProfits += investments[investmentIndex].dailyProfit;
					curInitialCosts += investments[investmentIndex].initialCost;
					investmentIndex ++;
				}else if(curDailyProfits == 0) {
					day ++;
					System.out.println(day);
				}else {
					break;
				}
			}
			
			day = Math.max(day, (curInitialCosts + moneyToRetire)/curDailyProfits);
			if(investmentIndex < investments.length) {
				day = Math.min(investments[investmentIndex].firstProfitDay, day);
			}
		}
		System.out.println(day);
	}
}
