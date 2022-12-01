import java.util.Scanner;

public class RedundantBinaryNotation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long N = input.nextLong();
		long t = input.nextLong();
		input.close();
		long adjustedT = t;
		if(t > N) {
			adjustedT = N;
		}
		String binaryRep = Long.toBinaryString(N);
		long numReps = 0;
		
		if(t >= 1) {
			numReps ++;
			if(t >= N) {
				long exponent = N/2;
				numReps = 1 << exponent;
			}else if(t >= 2) {
				int toBeAdded = 1;
				int toBeMultiplied = 1;
				char currentDigit = '0';
				boolean first1Found = false;
				int currentSum = 0;
				for(int i = 0; i < binaryRep.length(); i ++) {
					if(!first1Found) {
						if(binaryRep.charAt(i) == '1') {
							first1Found = true;
							currentSum = 1;
							currentDigit = '1';
						}
					}else {
						if(currentDigit == binaryRep.charAt(i)) {
							currentSum ++;
						}else {
							if(currentDigit == '1' && binaryRep.charAt(i) == '0') {
								toBeMultiplied *= currentSum;
								currentSum = 0;
								currentDigit = '0';
							}else if(currentDigit == '0' && binaryRep.charAt(i) == '1') {
								toBeMultiplied *= currentSum;
								currentSum = 0;
								currentDigit = '1';
								toBeAdded *= toBeMultiplied;
								toBeMultiplied = 1;
							}else {
								System.out.println("idk wut happen");
							}
						}
					}
				}
				if(!first1Found) {
					toBeAdded = 0;
				}
				numReps += toBeAdded;
			}
		}
		System.out.println(numReps);
	}
	
	public long calcPossibleRepresentations() {
		return 2;
	}
}
