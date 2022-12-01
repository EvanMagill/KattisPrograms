import java.util.Scanner;

public class Backslash {
	
	public static final String BACKSLASH = "\\";
	
	public static boolean isSpecial(char input) {
		int firstCompare = input - '!';
		int firstMax = '*' - '!';
		int secondCompare = input - '[';
		int secondMax = ']' - '[';
		return (firstCompare >= 0 && firstCompare <= firstMax) || (secondCompare >= 0 && secondCompare <= secondMax);
	}
	
	public static String slashes(int slashDepth) {
		int numSlashes = (1 << slashDepth) - 1;
		String result = "";
		for(int i = 0; i < numSlashes; i ++) {
			result += BACKSLASH;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while(console.hasNext()) {
			int interpretationLevel = console.nextInt();
			String neededSlashes = slashes(interpretationLevel);
			console.nextLine();
			String line = console.nextLine();
			String result = "";
			for(int i = 0; i < line.length(); i ++) {
				char curChar = line.charAt(i);
				if(isSpecial(curChar)) {
					result += neededSlashes;
				}
				result += curChar;
			}
			System.out.println(result);
		}
		console.close();
	}

}
