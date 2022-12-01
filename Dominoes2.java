import java.util.ArrayList;
import java.util.Scanner;

public class Dominoes2 {
	private int n;
	private int m;
	private int l;
	private int numFallen;
	private boolean[] fallen;
	private ArrayList<Integer>[] chains;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int c = 0; c < cases; c ++) {
			int n = input.nextInt();
			int m = input.nextInt();
			int l = input.nextInt();
			Dominoes2 currentCase = new Dominoes2(n, m, input);
			for(int i = 0; i < l; i ++) {
				currentCase.propagate(input.nextInt());
			}
			System.out.println(currentCase.getNumFallen());
		}
	}
	
	public Dominoes2(int n, int m, Scanner input) {
		this.n = n;
		this.m = m;
		numFallen = 0;
		fallen = new boolean[n + 1];
		chains = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i ++) {
			chains[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i ++) {
			chains[input.nextInt()].add(input.nextInt());
		}
	}
	
	public void propagate(int trigger) {
		if(fallen[trigger]) {
			return;
		}
		fallen[trigger] = true;
		numFallen ++;
		for(int i = 0; i < chains[trigger].size(); i ++) {
			propagate(chains[trigger].get(i));
		}
	}
	
	public int getNumFallen() {
		return numFallen;
	}
}
