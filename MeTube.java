import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Evan Magill
 * @date 2022-11-01
 */
public class MeTube {

	private static class Video {
		public int duration;
		public short categories;// each bit represents whether or not it is a member of that category.

		public Video(int duration, short categories) {
			this.duration = duration;
			this.categories = categories;
		}
	}

	public static void main(String[] args) {
		ArrayList<Video> videos = new ArrayList<Video>();
		Scanner input = new Scanner(System.in);
		int numVideos = input.nextInt();
		for(int i = 0; i < numVideos; i ++) {
			int duration = input.nextInt();
			String categories = input.next();
			short categoryRep = 0;
			for(int j = 0; j < categories.length(); j ++) {
				categoryRep |= 1 << (categories.charAt(j) - 'a');
			}
			System.out.println("duration: " + duration + "\ncategory representation: " + categoryRep);
			Video newVid = new Video(duration, categoryRep);
			videos.add(newVid);
		}
		input.close();
	}

}
