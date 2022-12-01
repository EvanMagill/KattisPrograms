import java.util.Scanner;

public class Aa {

	public static int findFail(String currentCase, String previousCase) {
		int endOfShorterString = Math.min(currentCase.length(), previousCase.length());
		for (int i = 0; i < endOfShorterString; i++) {
			int charComparison = currentCase.charAt(i) - previousCase.charAt(i);
			if (charComparison > 0) {
				return -1;
			} else if (charComparison < 0) {
				return i;
			}
		}
		if (previousCase.length() > currentCase.length()) {
			return currentCase.length() - 1;
		}
		return -1;
	}
	
	public static String fixString(String currentCase, String previousCase) {
		int correctionPoint = findFail(currentCase, previousCase);
		if (correctionPoint == -1) {
			return currentCase;
		}
		if (correctionPoint < currentCase.length() - 1 && currentCase.charAt(correctionPoint) == 'a' && currentCase.charAt(correctionPoint + 1) == 'a') {
			String fixedRemainder = fixString(currentCase.substring(correctionPoint + 2), previousCase.substring(Math.min(previousCase.length(),correctionPoint + 2)));
			if(fixedRemainder != null) {
				return currentCase.substring(0, correctionPoint) + "{}" + fixedRemainder;
			}
		}else {
			correctionPoint = Math.min(correctionPoint, currentCase.length() - 2);
		}
		while(correctionPoint >= 0) {
			if (currentCase.charAt(correctionPoint) == 'a' && currentCase.charAt(correctionPoint + 1) == 'a') {
				String test = currentCase.substring(0, correctionPoint) + "{}" + currentCase.substring(correctionPoint + 2);
				if(findFail(test, previousCase) == -1) {
					return test;
				}
			}
			--correctionPoint;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		String previousCase = input.next();
		for (int i = 0; i < cases - 1; i++) {
			String currentCase = input.next();
			String fixedCase = fixString(currentCase, previousCase);
			if (fixedCase == null) {
				System.out.println("no");
				return;
			}
			previousCase = fixedCase;
		}
		System.out.println("yes");
		input.close();
	}
}
