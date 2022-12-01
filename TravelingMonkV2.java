import java.util.Scanner;

public class TravelingMonkV2 {
	public static double valueAtTime(int[] scent, int time) {//generic, neither ascent nor descent.
		int fullValue = scent[0];
		double gradient = (double)scent[0]/scent[1];
		int extra = scent[2] - time;
		return fullValue - gradient * extra;
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int ascentSegments = console.nextInt();
		int descentSegments = console.nextInt();
		int[][] ascent = new int[ascentSegments][3];//0: height traversed, 1: time taken, 2: time finished
		int[][] descent = new int[descentSegments][3];
		int height = 0;
		int time = 0;
		for(int i = 0; i < ascentSegments; i ++) {
			ascent[i][0] = console.nextInt();
			time += ascent[i][1] = console.nextInt();
			ascent[i][2] = time;
		}
		time = 0;//reset to be able to calculate time finished for descents.
		for(int i = 0; i < descentSegments; i ++) {
			height += descent[i][0] = console.nextInt();//I suspect descent has fewer segments so it is marginally faster to add up here.
			time += descent[i][1] = console.nextInt();
			descent[i][2] = time;
		}
		console.close();
		//Stage 1, advance as far as entire segments can be taken. (Once stopped, at least one of the segments is a crossover segment)
		int ascentIndex = 0;
		int descentIndex = 0;
		int difference = height;
		int curAscent = ascent[ascentIndex][0];//[0][0], but showing intention.
		int curDescent = descent[descentIndex][0];
		while(curAscent + curDescent < difference) {
			if(ascentIndex == ascent.length - 1 || descentIndex == descent.length - 1) {
				break;
			}
			if(ascent[ascentIndex][2] <= descent[descentIndex][2]) {//Which current segment finishes first?
				ascentIndex ++;
				difference -= curAscent;
				curAscent = ascent[ascentIndex][0];
			}else {
				descentIndex ++;
				difference -= curDescent;
				curDescent = descent[descentIndex][0];
			}
		}
		//Stage 2, Take small segments until relevant segment pair is found. (Once stopped, both segments are crossover segments)
		if(ascent[ascentIndex][2] > descent[descentIndex][2]) {//Is ascent the bigger chunk?
			while(descent[descentIndex][0] + valueAtTime(ascent[ascentIndex], descent[descentIndex][2]) < difference) {
				difference -= descent[descentIndex][0];
				descentIndex ++;
			}
		}else {
			while(ascent[ascentIndex][0] + valueAtTime(descent[descentIndex], ascent[ascentIndex][2]) < difference) {
				difference -= ascent[ascentIndex][0];
				ascentIndex ++;
			}
		}
		//Stage 3, Determine difference at current point. ("current" being whichever is most advanced).
		int curTime = Math.max(ascent[ascentIndex][2], descent[descentIndex][2]);
		double curDifference = difference - valueAtTime(descent[descentIndex], curTime) - valueAtTime(ascent[ascentIndex], curTime);
		//Stage 4, find intersection.
		double overallGradient = (double)ascent[ascentIndex][0]/ascent[ascentIndex][1] + (double)descent[descentIndex][0]/descent[descentIndex][1];
		double additionalTime = curDifference/overallGradient;
		double crossOverTime = curTime + additionalTime;
		System.out.println(crossOverTime);
	}

}
