import java.util.Scanner;

public class FourThought {
	
	public static void main(String[] args) {
		String[] equations = new String[317];//-60 to 256
		char[] operators = {'+', '-', '*', '/'};
		for(int equationGen = 0; equationGen < 64; ++equationGen) {
			String curEquation = " 4 " + operators[equationGen/16] + " 4 " + operators[equationGen/4%4] + " 4 " + operators[equationGen%4] + " 4 ";
			int curEquationValue = 0;
			String[] subEquations = curEquation.split("[+-]");
			int[] subEquationValues = new int[subEquations.length];
			for(int equationSegment = 0; equationSegment < subEquations.length; ++equationSegment) {
				subEquationValues[equationSegment] = 4;
				for(int operatorIndex = 3; operatorIndex < subEquations[equationSegment].length(); operatorIndex += 4) {
					if(subEquations[equationSegment].charAt(operatorIndex) == '*') {
						subEquationValues[equationSegment] *= 4;
					}else {
						subEquationValues[equationSegment] /= 4;
					}
				}
			}
			int subEquationNumber = 0;
			curEquationValue += subEquationValues[0];
			for(int operatorIndex = 3; operatorIndex < curEquation.length(); operatorIndex += 4) {
				if(curEquation.charAt(operatorIndex) == '+') {
					curEquationValue += subEquationValues[++subEquationNumber];
				}else if(curEquation.charAt(operatorIndex) == '-') {
					curEquationValue -= subEquationValues[++subEquationNumber];
				}
			}
			curEquation = curEquation.substring(1) + "= " + curEquationValue;
			equations[curEquationValue + 60] = curEquation;
		}
		
		Scanner console = new Scanner(System.in);
		int cases = console.nextInt();
		for(int i = 0; i < cases; ++i) {
			int input = console.nextInt();
			if(input < -60 || input > 256) {
				System.out.println("no solution");
				continue;
			}
			String result = equations[input + 60];
			if(result == null) {
				result = "no solution";
			}
			System.out.println(result);
		}
		console.close();
	}

}
