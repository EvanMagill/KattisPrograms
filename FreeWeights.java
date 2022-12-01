import java.util.Scanner;

public class FreeWeights {
	
	public static void main(String[] args) {
		int largestWeightToMove = 0;
		Scanner console = new Scanner(System.in);
		console.nextLine();
		for(int i = 0; i < 2; i ++) {
			Scanner reader = new Scanner(console.nextLine());
			int curLargeUnmatchedWeight = 0;
			int curLargeIntermediateWeight = 0;
			while(reader.hasNextInt()) {
				int curWeight = reader.nextInt();
				if(curWeight > largestWeightToMove) {
					if(curLargeUnmatchedWeight == 0) {
						curLargeUnmatchedWeight = curWeight;
						continue;
					}
					if(curWeight > curLargeUnmatchedWeight) {
						largestWeightToMove = curLargeUnmatchedWeight;
						curLargeUnmatchedWeight = curWeight;
						continue;
					}
					if(curWeight == curLargeUnmatchedWeight) {
						largestWeightToMove = Math.max(curLargeIntermediateWeight, largestWeightToMove);
						curLargeUnmatchedWeight = 0;
						curLargeIntermediateWeight = 0;
						continue;
					}
					if(curWeight > curLargeIntermediateWeight) {
						curLargeIntermediateWeight = curWeight;
					}
				}
			}
			reader.close();
			largestWeightToMove = Math.max(curLargeUnmatchedWeight, largestWeightToMove);
		}
		console.close();
		System.out.println(largestWeightToMove);
	}

}
