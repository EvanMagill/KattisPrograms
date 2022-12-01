import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PolishNotation {

	public static Set<String> OPERATORS = new HashSet<String>();

	public static String evaluator(String input) {
		Scanner tokenizer = new Scanner(input);
		String operation = tokenizer.next();
		if (!OPERATORS.contains(operation)) {
			tokenizer.close();
			return input;
		}
		int position = 2;
		int numOperators = 0;
		int numOperands = 0;
		while (numOperators != numOperands - 1 && tokenizer.hasNext()) {
			String curToken = tokenizer.next();
			if (OPERATORS.contains(curToken)) {
				numOperators++;
			} else {
				numOperands++;
			}
			position += curToken.length() + 1;
		}
		if (!tokenizer.hasNext()) {
			tokenizer.close();
			throw new IllegalStateException("AHHHHH");
		}
		tokenizer.close();
		String operand1 = evaluator(input.substring(2, position - 1));
		String operand2 = evaluator(input.substring(position));
		int operand1Value;
		int operand2Value;
		try {
			operand1Value = Integer.parseInt(operand1);
			operand2Value = Integer.parseInt(operand2);

			switch (operation) {
				case "+":
					return operand1Value + operand2Value + "";
				case "*":
					return operand1Value * operand2Value + "";
				case "-":
					return operand1Value - operand2Value + "";
				default:
					return "oh...";
			}
		} catch (Exception e) {
			return operation + " " + operand1 + " " + operand2;
		}
	}

	public static void main(String[] args) {
		OPERATORS.add("+");
		OPERATORS.add("*");
		OPERATORS.add("-");
		Scanner console = new Scanner(System.in);
		for (int i = 1; console.hasNext(); i++) {
			System.out.println("Case " + i + ": " + evaluator(console.nextLine()));
		}
		console.close();
	}

}
