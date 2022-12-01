import java.util.Arrays;
import java.util.Scanner;

public class FairPlay {
	
	public static class Coworker implements Comparable<Coworker> {
		public int bSkill;
		public int pSkill;
		public static long bTotal = 0l;
		public static long pTotal = 0l;
		public static int numCoworkers = 0;
		public static int bTeamAverage = 0;
		public static int pTeamAverage = 0;
		
		public Coworker(int bSkill, int pSkill) {
			this.bSkill = bSkill;
			this.pSkill = pSkill;
			bTotal += bSkill;
			pTotal += pSkill;
			numCoworkers ++;
		}
		
		@Override
		public int compareTo(Coworker o) {
			int result = bSkill - o.bSkill;
			if(result == 0) {
				result = pSkill - o.pSkill;
			}
			return result;
		}
		
		public boolean compatible(Coworker o) {
			int neededB = bTeamAverage - bSkill;
			int neededP = pTeamAverage - pSkill;
			return neededB == o.bSkill && neededP == o.pSkill;
		}
		
		public static void setTeamAverages(Coworker min, Coworker max) {
			bTeamAverage = min.bSkill + max.bSkill;
			pTeamAverage = min.pSkill + max.pSkill;
		}
		
		@Override
		public String toString() {
			return "bSkill: " + bSkill + "\npSkill: " + pSkill;
		}
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int coworkers = input.nextInt();
		if(coworkers % 2 == 1) {
			input.close();
			System.out.println("impossible");
			return;
		}
		Coworker[] skill = new Coworker[coworkers];
		for(int i = 0; i < coworkers; i ++) {
			skill[i] = new Coworker(input.nextInt(), input.nextInt());
		}
		input.close();
		Arrays.sort(skill);
		Coworker.setTeamAverages(skill[0], skill[coworkers - 1]);
		for(int i = 0; i < coworkers/2; i ++) {
			if(!skill[i].compatible(skill[coworkers - i - 1])) {
				System.out.println("impossible");
				return;
			}
		}
		System.out.println("possible");
	}
}
