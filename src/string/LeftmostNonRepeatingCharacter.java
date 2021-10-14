package string;

import java.util.Arrays;

public class LeftmostNonRepeatingCharacter {
	
	static int nonRep(String str) {
		for(int i=0; i<str.length(); i++) {
			boolean flag = false;
			for(int j=0; j<str.length(); j++) {
				if(i != j && str.charAt(i) == str.charAt(j)) {
					flag = true;
					break;
				}
			}
			if(flag == false) {
				return i;
			}
		}
		return -1;
	}

	static int nonRep2(String str) {
		int[] count = new int[256];
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)]++;
		}
		for(int i=0; i<str.length(); i++) {
			if(count[str.charAt(i)]==1)
				return i;
		}
		return -1; 
	}
	
	static int nonRep3(String str) {
		int[] fIndex = new int[256];
		int res = Integer.MAX_VALUE;
		Arrays.fill(fIndex, -1);
		for(int i=0; i<str.length(); i++) {
			if(fIndex[str.charAt(i)] == -1)
				fIndex[str.charAt(i)] = i;
			else
				fIndex[str.charAt(i)] = -2;
		}	
		for(int i=0; i<256; i++) {
			if(fIndex[i] != -1 && fIndex[i] != -2) {
				res = Math.min(res, fIndex[i]);
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	public static void main(String[] args) {
		System.out.println(nonRep("applea"));
		System.out.println(nonRep2("applea"));
		System.out.println(nonRep3("applea"));
	}
	
}
