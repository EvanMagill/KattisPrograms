import java.util.ArrayList;
import java.util.Scanner;

public class TenKindsOfPeople {

	public static int[][] daMap;

	public static int[] up(int r, int c) {
		if (r > 0) {
			return new int[] {r - 1, c};
		}
		return null;
	}

	public static int[] down(int r, int c) {
		if (r + 1 < daMap.length) {
			return new int[] {r + 1, c};
		}
		return null;
	}

	public static int[] left(int r, int c) {
		if (c > 0) {
			return new int[] {r, c - 1};
		}
		return null;
	}

	public static int[] right(int r, int c) {
		if (c + 1 < daMap[r].length) {
			return new int[] {r, c + 1};
		}
		return null;
	}

	public static void expand(int newValue, ArrayList<int[]> expansion) {
		int replacedValue = 0;
		if (newValue > 0) {
			replacedValue = 1;
		}
		if(replacedValue == newValue) {
			System.out.println("BAD");
			return;
		}
		while (expansion.size() != 0) {
			ArrayList<int[]> nextExpansion = new ArrayList<int[]>();
			for (int[] coord : expansion) {
				if (daMap[coord[0]][coord[1]] == replacedValue) {
					daMap[coord[0]][coord[1]] = newValue;
					int[] up = up(coord[0], coord[1]);
					int[] down = down(coord[0], coord[1]);
					int[] left = left(coord[0], coord[1]);
					int[] right = right(coord[0], coord[1]);
					if (up != null) {
						nextExpansion.add(up);
					}
					if (down != null) {
						nextExpansion.add(down);
					}
					if (left != null) {
						nextExpansion.add(left);
					}
					if (right != null) {
						nextExpansion.add(right);
					}
				}
			}
			expansion = nextExpansion;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		daMap = new int[input.nextInt()][input.nextInt()];
		for (int r = 0; r < daMap.length; r++) {
			String nextLine = input.next();
			for (int c = 0; c < daMap[r].length; c++) {
				daMap[r][c] = (int) (nextLine.charAt(c) - '0');
			}
		}
		int id = 2;
		for (int r = 0; r < daMap.length; r++) {
			for (int c = 0; c < daMap[r].length; c++) {
				if (daMap[r][c] == 0 || daMap[r][c] == 1) {
					int[] startingPoint = { r, c };
					ArrayList<int[]> startingRegion = new ArrayList<int[]>();
					startingRegion.add(startingPoint);
					int sign = daMap[r][c] * 2 - 1;//0 becomes -1, 1 remains 1.
					int weirdId = sign*id;
					expand(weirdId, startingRegion);
					id ++;
				}
			}
		}
		int testCases = input.nextInt();
		for (int i = 0; i < testCases; i++) {
			int firstNum = daMap[input.nextInt() - 1][input.nextInt() - 1];
			if (firstNum == daMap[input.nextInt() - 1][input.nextInt() - 1]) {
				if (firstNum > 0) {
					System.out.println("decimal");
				} else {
					System.out.println("binary");
				}
			} else {
				System.out.println("neither");
			}
		}
		input.close();
	}

}
