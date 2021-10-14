package string;

public class PatternSearching {
	
	// Given a pattern and a text, we need to print all occurrences of the pattern in the text
	
	// print only first occurence
	public static void pattern(String str, String pattern) {
		if(str.indexOf(pattern) >= 0)
			System.out.println(str.indexOf(pattern));
	}
	
	public static void pattern2(String str, String pattern) {
		for(int i=0; i<=str.length()-pattern.length(); i++) {
			int j;
			for(j=0; j<pattern.length(); j++) {
				if(str.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j == pattern.length()) {
				System.out.print(i + " ");
			}
		}
	}
	
	// Given a pattern with distinct characters and a text, we need to print all occurrences of the pattern in the text
	// theta(str.length)
	public static void pattern3(String str, String pattern) {
		for(int i=0; i<=str.length()-pattern.length(); ) {
			int j;
			for(j=0; j<pattern.length(); j++) {
				if(str.charAt(i+j) != pattern.charAt(j)) {
					break;
				}
			}
			if(j == pattern.length()) {
				System.out.print(i + " ");
			}
			if(j == 0) {
				i++;
			}
			else {
				i = i+j;
			}
		}
	}
  
    public static void main(String args[]) 
    {   String txt = "ABCABCD";String pat="ABC";
        pattern(txt,pat); System.out.println();
        pattern2(txt,pat);  System.out.println();
        pattern3(txt,pat);  System.out.println();
    } 
}
