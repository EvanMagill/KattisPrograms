import java.util.ArrayList;
import java.util.Scanner;

public class CutInLine {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfNames = input.nextInt();
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i < numberOfNames; i ++) {
			names.add(input.next());
		}
		int numberOfChanges = input.nextInt();
		for(int i = 0; i < numberOfChanges; i ++) {
			String action = input.next();
			if(action.equals("cut")) {
				String cutter = input.next();
				String cutted = input.next();//great name, right?
				names.add(names.indexOf(cutted), cutter);
			}else {
				names.remove(input.next());
			}
		}
		for(int i = 0; i < names.size(); i ++) {
			System.out.println(names.get(i));
		}
	}

}
