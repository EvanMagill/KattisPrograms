import java.util.Scanner;

public class WordsForNumbers {
	
	public static final String[] tens = {null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	public static final String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	public static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	
	public static String numToString(int num) {
		if(num >= 20) {
			int tensPlace = num/10;
			String result = tens[tensPlace];
			int onesPlace = num - 10*tensPlace;
			if(onesPlace > 0) {
				result += "-" + ones[onesPlace];
			}
			return result;
		}else if(num >= 10) {
			return teens[num - 10]; 
		}else {
			return ones[num];
		}
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while(console.hasNextLine()) {
			Scanner lineReader = new Scanner(console.nextLine());
			String firstToken = lineReader.next();
			try {
				int firstNum = Integer.parseInt(firstToken);
				String wordNum = numToString(firstNum);
				char firstChar = (char)(wordNum.charAt(0) - 32);
				String capitalWordNum = firstChar + wordNum.substring(1);
				System.out.print(capitalWordNum);
			}
			catch(Exception e) {
				System.out.print(firstToken);
			}
			while(lineReader.hasNext()) {
				String curToken = lineReader.next();
				try {
					int num = Integer.parseInt(curToken);
					String wordNum = numToString(num);
					System.out.print(" " + wordNum);
				}
				catch(Exception e) {
					System.out.print(" " + curToken);
				}
			}
			lineReader.close();
			System.out.println();
		}
		console.close();
	}

}
