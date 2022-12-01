import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Zyxab {
	
	public static boolean isValid(String word) {
		if(word.length() >= 5) {
			Set<Character> letters = new HashSet<Character>();
			for(int j = 0; j < word.length(); j ++) {
				letters.add(word.charAt(j));
			}
			if(letters.size() == word.length()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String bestWord = "";
		boolean validWordFound = false;
		Scanner console = new Scanner(System.in);
		int cases = console.nextInt();
		for(int i = 0; i < cases; i ++) {
			String curWord = console.next();
			if(!validWordFound) {
				if(isValid(curWord)) {
					bestWord = curWord;
					validWordFound = true;
				}
			}else {
				if(curWord.length() < bestWord.length()) {
					if(isValid(curWord)) {
						bestWord = curWord;
					}
				}else if(curWord.length() == bestWord.length()) {
					if(isValid(curWord) && bestWord.compareTo(curWord) < 0) {
						bestWord = curWord;
					}
				}
			}
		}
		console.close();
		if(!validWordFound) {
			System.out.println("neibb!");
		}else {
			System.out.println(bestWord);
		}
	}

}
