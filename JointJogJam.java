import java.util.Scanner;

public class JointJogJam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] kariStart = {input.nextInt(), input.nextInt()};
		int[] olaStart = {input.nextInt(), input.nextInt()};
		int[] kariEnd = {input.nextInt(), input.nextInt()};
		int[] olaEnd = {input.nextInt(), input.nextInt()};
		input.close();
		double tMin = 0.0;
		double tMax = 1.0;
		double detail = 0.1;
		double greatestDist = 0.0;
		double greatestT = 0.0;
		for(int i = 0; i < 6; i ++) {
			for(double t = tMin; t < tMax; t += detail) {
				double curDist = distanceAtT(kariStart, kariEnd, olaStart, olaEnd, t);
				if(curDist > greatestDist) {
					greatestDist = curDist;
					greatestT = t;
				}
			}
			tMin = Math.max(greatestT - detail, tMin);
			tMax = Math.min(greatestT + detail, tMax);
			detail = (tMax - tMin)/10.0;
		}
		System.out.println(greatestDist);
	}
	
	public static double distanceAtT(int[] kariStart, int[] kariEnd, int[] olaStart, int[] olaEnd, double t) {
		double[] kariPos = posAtT(kariStart, kariEnd, t);
		double[] olaPos = posAtT(olaStart, olaEnd, t);
		return distance(kariPos[0], kariPos[1], olaPos[0], olaPos[1]);
	}
	
	public static double[] posAtT(int[] startPoint, int[] endPoint, double t) {
		double x = startPoint[0] + t*(endPoint[0] - startPoint[0]);
		double y = startPoint[1] + t*(endPoint[1] - startPoint[1]);
		double[] result = {x, y};
		return result;
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
}
