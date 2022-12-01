import java.util.Scanner;
import java.util.ArrayList;

public class TravelingMonk {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int ascentSegments = console.nextInt();
		int descentSegments = console.nextInt();
		int[][] ascent = new int[ascentSegments][2];
		int[][] descent = new int[descentSegments][2];
		int height = 0;
		ArrayList<Double> ascentRate = new ArrayList<Double>();
		ArrayList<Double> descentRate = new ArrayList<Double>();
		for(int i = 0; i < ascentSegments; i ++) {
			ascent[i][0] = console.nextInt();
			ascent[i][1] = console.nextInt();
			double rate = (double)ascent[i][0]/ascent[i][1];
			for(int j = 0; j < ascent[i][1]; j ++) {
				ascentRate.add(rate);
			}
		}
		for(int i = 0; i < descentSegments; i ++) {
			height += descent[i][0] = console.nextInt();
			descent[i][1] = console.nextInt();
			double rate = (double)descent[i][0]/descent[i][1];
			for(int j = 0; j < descent[i][1]; j ++) {
				descentRate.add(rate);
			}
		}
		double ascentHeight = 0;
		double descentHeight = height;
		int time = 0;
		for(; time < descentRate.size(); time ++) {
			ascentHeight += ascentRate.get(time);
			descentHeight -= descentRate.get(time);
			if(ascentHeight >= descentHeight) {
				break;
			}
		}
		double relevantAscentRate = ascentRate.get(time);
		double relevantAscentHeight = ascentHeight - relevantAscentRate;
		double relevantDescentRate = descentRate.get(time);
		double relevantDescentHeight = descentHeight + relevantDescentRate;
		double differenceOfSlope = relevantAscentRate + relevantDescentRate;//Descent's slope is given negated.
		double differenceOfHeight = relevantAscentHeight - relevantDescentHeight;
		double timeOffset = differenceOfHeight/differenceOfSlope;
		System.out.println(time - timeOffset);
	}
}
