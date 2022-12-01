import java.util.Scanner;

public class GoodMorning {
	public static boolean validNext(int curDigit, int nextDigit) {
		if (curDigit == nextDigit) {
			return true;// The same number can be pressed twice.
		} else if (curDigit == 0) {
			return false;// Only 0 is valid after 0.
		}
		int curRow = (curDigit - 1) / 3;
		int curCol = (curDigit - 1) % 3;
		if (nextDigit == 0) {
			return curCol <= 1;// 0 is valid to follow a number in the 0th or 1st column.
		}
		int nextRow = (nextDigit - 1) / 3;
		int nextCol = (nextDigit - 1) % 3;
		return nextRow >= curRow && nextCol >= curCol;
	}

	public static int powerOf10(int power) {
		int result = 1;
		for (int i = 0; i < power; i++) {
			result *= 10;
		}
		return result;
	}

	public static int minimum(int digit, int power) {
		if (validNext(digit, 0)) {
			return digit * powerOf10(power);
		}
		int result = 0;
		for (int i = 0; i <= power; i++) {
			result += digit * powerOf10(i);
		}
		return result;
	}

	public static int maximum(int digit, int power) {
		int result = digit * powerOf10(power);
		if (validNext(digit, 9)) {
			for (int i = power - 1; i >= 0; i--) {
				result += 9 * powerOf10(i);
			}
		}
		return result;
	}

	public static int getLastDigit(int lastLow, int power) {
		int roundBy = powerOf10(power);
		return (getReferencePortion(lastLow, power) - getReferencePortion(lastLow, power + 1)) / roundBy;
	}

	public static int getReferencePortion(int lastLow, int power) {
		int roundBy = powerOf10(power);
		return lastLow / roundBy * roundBy;
	}
	
	public static boolean exactPossible(int n) {
		int highestPower = (int) Math.log10(n);
		for (int power = highestPower; power > 0; power--) {
			if(!validNext(getLastDigit(n, power), getLastDigit(n, power-1))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		for (int testCase = 0; testCase < numCases; testCase++) {
			int currentCase = input.nextInt();
			if(exactPossible(currentCase)) {
				System.out.println(currentCase);
				continue;
			}
			int highestPower = (int) Math.log10(currentCase);
			int lowAttempt = 0;
			int highAttempt = maximum(9, highestPower);
			int lastDigit = 1;
			int referencePortion = 0;
			for (int power = highestPower; power > -1; power--) {
				for (int highDigit = 9; highDigit > -1; highDigit--) {
					if (validNext(lastDigit, highDigit)) {
						int testHigh = referencePortion + minimum(highDigit, power);
						if (testHigh < highAttempt) {
							if (testHigh > currentCase) {
								highAttempt = testHigh;
							} else {
								int lowerHigh = referencePortion + maximum(highDigit, power);
								if(lowerHigh > currentCase) {
									highAttempt = lowerHigh;
								}
								break;
							}
						}
					}
				}
				for (int lowDigit = 0; lowDigit < 10; lowDigit++) {
					if (validNext(lastDigit, lowDigit)) {
						int testLow = referencePortion + maximum(lowDigit, power);
						if (testLow > lowAttempt) {
							if (testLow < currentCase) {
								lowAttempt = testLow;
							} else {
								int higherLow = referencePortion + minimum(lowDigit, power);
								if (higherLow < currentCase) {
									lowAttempt = higherLow;
								}
								lastDigit = getLastDigit(lowAttempt, power);
								referencePortion = getReferencePortion(lowAttempt, power);
								break;
							}
						}
					}
				}
			}
			if (highAttempt - currentCase < currentCase - lowAttempt) {
				System.out.println(highAttempt);
			} else {
				System.out.println(lowAttempt);
			}
		}
		input.close();
	}
}
