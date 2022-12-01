import java.util.Scanner;

public class SantaKlas {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int altitude = console.nextInt();
		int angle = console.nextInt();
		console.close();
		if (angle >= 0 && angle <= 180) {
			System.out.println("safe");
			return;
		}
		if (angle == 270) {
			System.out.println(altitude);
			return;
		} else if (angle > 270) {
			angle = 360 - angle;
		} else {
			angle = angle - 180;
		}
		double radians = angle * Math.PI / 180.0;
		double sine = Math.sin(radians);
		System.out.println((int) (altitude / sine));
	}
}
