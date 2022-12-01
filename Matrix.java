import java.util.Scanner;

public class Matrix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int caseNum = 1;
		while (input.hasNextLine()) {
			System.out.println("Case " + caseNum + ":");
			int[][] currentCase = new int[2][2];
			String[] lines = {input.nextLine(),input.nextLine()};
			Scanner lineReader;
			for(int row = 0; row < 2; row ++) {
				lineReader = new Scanner(lines[row]);
				for(int col = 0; col < 2; col ++) {
					currentCase[row][col] = lineReader.nextInt();
				}
			}
			input.nextLine();
			int detA = currentCase[0][0] * currentCase[1][1] - currentCase[0][1] * currentCase[1][0];
			int recipDetA = 1/detA;
			System.out.print(recipDetA * currentCase[1][1] + " " + (recipDetA * -currentCase[0][1]) + "\n" + (recipDetA * -currentCase[1][0]) + " " + recipDetA * currentCase[0][0]);
			if(input.hasNextLine()) {
				System.out.println();
			}
			caseNum ++;
		}
		input.close();
	}
}