package string;

import java.util.Arrays;

public class LeftmostRepeatingCharacter {
	
//	Given a string, the task is to find the index of first occurence of character that repeats.
//	O(n*n) time, naive
	static int leftRepeat(String str) {
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<str.length(); j++) {
				if(str.charAt(i) == str.charAt(j))
					return i;
			}
		}
		return -1;
	}
	
//	O(2n) time
	static int leftRepeat2(String str) {
		int count[] = new int[256];
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)]++;
		}
		for(int i=0; i<str.length(); i++) {
			if(count[str.charAt(i)] > 1)
				return i;
		}
		return -1;
	}
	
//  O(1n) time, traverse the string from left to right and keep track of index of first occurence of every character.
	static int leftRepeat3(String str) {
		int fIndex[] = new int[256];
		int res = Integer.MAX_VALUE;
		Arrays.fill(fIndex, -1);
		for(int i=0; i<str.length(); i++) {
			if(fIndex[str.charAt(i)] == -1)
				fIndex[str.charAt(i)] = i;
			else
				res = Math.min(res, fIndex[str.charAt(i)]);			
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	static int leftRepeat4(String str) {
		int res = -1;
		boolean[] visited = new boolean[256];
		for(int i=str.length()-1; i>=0; i--) {
			if (visited[str.charAt(i)])
				res = i;
			else
				visited[str.charAt(i)] = true;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(leftRepeat("cabbd"));
		System.out.println(leftRepeat2("dacb"));
		System.out.println(leftRepeat4("daab"));
	}
	
}
