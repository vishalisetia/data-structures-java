package string;

import java.util.Arrays;

// 2 strings are called anagram of each other if one string is permutation of other string.
public class anagram {

//	check whether 2 given strings are anagram or not
	static boolean anagram1(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		char[] a1 = s1.toCharArray();
		Arrays.sort(a1);
		s1 = new String(a1);
		
		char[] a2 = s2.toCharArray();
		Arrays.sort(a2);
		s2 = new String(a2);
		
		return s1.equals(s2);
	}
	
//  O(n)
	static boolean anagram2(String s1, String s2) {
		if(s1.length() != s2.length()) 
			return false;
		int count[] = new int[256];
		for(int i=0; i<s1.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		for(int i=0; i<256; i++)
			if(count[i] != 0)
				return false;
		return true;
	}
	
//	Given a text and a pattern, the task is to find if there is anagram of pattern present in text or not.
	static boolean anagramSearch(String txt, String pat) {
		for(int i=0; i<=txt.length()-pat.length(); i++) {
			String s1 = "";
			for(int j=i; j<i+4; j++) {
				s1 += txt.charAt(j);
			}
			if(anagram2(s1,pat))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(anagram1("abcc","cbca"));
		System.out.println(anagram2("abcc","cbca"));
		System.out.println(anagramSearch("geeksforgeeks","esgk"));
	}

}
