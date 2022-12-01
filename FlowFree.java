import java.util.Arrays;
import java.util.Scanner;

public class FlowFree {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean yellowPresent = false;
		char[][] map = new char[6][6];// null border to avoid out of bounds.
		int[][] redConnections = new int[4][4];
		short allR = 0;
		int[][] greenConnections = new int[4][4];
		short allG = 0;
		int[][] blueConnections = new int[4][4];
		short allB = 0;
		int[][] yellowConnections = new int[4][4];
		short allY = 0;
		short mandatory;
		for (var i = 0; i < 4; i++) {
			String thisLine = input.nextLine();
			for (var j = 0; j < 4; j++) {
				map[i + 1][j + 1] = thisLine.charAt(j);
				if (map[i + 1][j + 1] == 'Y') {
					yellowPresent = true;
				}
			}
		}
		input.close();

		populateConnections(map, redConnections, 'R');
		populateConnections(map, greenConnections, 'G');
		populateConnections(map, blueConnections, 'B');
		printMatrix(redConnections);
		printMatrix(greenConnections);
		printMatrix(blueConnections);
		if (yellowPresent) {
			populateConnections(map, yellowConnections, 'Y');
			printMatrix(yellowConnections);
		}
		
		for(int r = 0; r < 4; r ++) {
			for(int c = 0; c < 4; c ++) {
				int power = 4*r + c;
				int currentValue = (1 << power);
				boolean red = redConnections[r][c] != 0;
				boolean green = greenConnections[r][c] != 0;
				boolean blue = blueConnections[r][c] != 0;
				boolean yellow = yellowConnections[r][c] != 0;
				if(!red && !green && !blue && !yellow) {
					System.out.println();
					System.out.print("not solvable");
					return;
				}
				if(red) {
					allR += currentValue;
				}
				if(green) {
					allG += currentValue;
				}
				if(blue) {
					allB += currentValue;
				}
				if(yellow) {
					allY += currentValue;
				}
			}
		}
		mandatory = (short)(allR ^ allG ^ allB ^ allY);
		
		
		System.out.println(allR);
		for(int i = 1; i < 65535; i++) {
			if((i | allR) == allR) {
				System.out.println(i);
			}
		}
		
		System.out.println("solvable");
	}

	public static void populateConnections(char[][] map, int[][] connections, char color) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				connections[i][j] = calcConnectionNum(map, color, i, j);
				if (map[i + 1][j + 1] == color) {
					connections[i][j]++;// Start and end points are not dead ends... kinda.
				}
			}
		}

		pruneDeadEnds(connections);
	}

	public static void pruneDeadEnds(int[][] connections) {
		boolean recursionNeeded = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (connections[i][j] == 1) {
					connections[i][j] = 0;
					if (i > 0 && connections[i - 1][j] != 0) {
						connections[i - 1][j]--;
					}
					if (j > 0 && connections[i][j - 1] != 0) {
						connections[i][j - 1]--;
					}
					if (i < 3 && connections[i + 1][j] != 0) {
						connections[i + 1][j]--;
					}
					if (j < 3 && connections[i][j + 1] != 0) {
						connections[i][j + 1]--;
					}
					recursionNeeded = true;
				}
			}
		}
		if (recursionNeeded) {
			pruneDeadEnds(connections);
		}
	}

	public static int calcConnectionNum(char[][] map, char color, int row, int col) {
		int connectionNum = 0;
		if (traversable(map, color, row, col)) {
			int[][] offset = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
			for (int i = 0; i < 4; i++) {
				if (traversable(map, color, row + offset[i][0], col + offset[i][1])) {
					connectionNum++;
				}
			}
		}
		return connectionNum;
	}

	public static boolean traversable(char[][] map, char color, int row, int col) {
		return (map[row + 1][col + 1] == 'W' || map[row + 1][col + 1] == color);
	}

	public static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
