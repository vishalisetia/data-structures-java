package string;

public class Intro {

	public static void main(String[] args) {
		
//		System.out.println("a" + 0); //converts integer into string
//		System.out.println('a' + 0); //converts char into integer
//		System.out.println((int)'a'); //converts char into integer
//		char x = 'a';
//		if(x == 97)
//			System.out.println("true");
//		else
//			System.out.println("false");
//		System.out.println('a' + "" + 0);
		
//		String str = "231";
//		System.out.println(Integer.parseInt(str)+5); // converts string to int
//		
//       String s2="00000678";
//       s2 = String.format("%08d", Integer.parseInt(s2) + 102);	// "%08d" means 8 digits
//       System.out.println("Output String: " + s2);
		
//		String s1 = "geeks";	//s1 points to "geeks" object
//		String s2 = s1;			//s2 also starts pointing to same "geeks" object
//		String s3 = "geeks";	//s3 also starts pointing to same "geeks" object
//		String s4 = new String("geeks");	//s4 points to new "geeks" object
//		s1 = s1 + "forgeeks";	// or s1.concat("forgeeks");  // s1 now starts pointing to new object "geeksforgeeks"
//		System.out.println(s1 == s2);	//compares whether 2 references refer to the same object or not
//		System.out.println(s1.equals(s3));	//compares whether 2 strings have same content or not

//		String str = "geeksforgeeks";
//		System.out.println(str.length());
//		System.out.println(str.charAt(0));
//		System.out.println(str.substring(5));
//		System.out.println(str.substring(5, 8)); //[5,8)	
//		System.out.println(str.contains("geeks"));
		
//		// pattern matching
//		System.out.println(str.indexOf("geeks")); //returns index of first occurence of "geeks" in s1, if not present returns -ve value
//		System.out.println(str.lastIndexOf("geeks"));
//		System.out.println(str.indexOf("geeks",1)); 	//skips the first character 'g'
//		int res = "geeksforgeeks".compareTo("abc");	
//		System.out.print(res);
//		if(res < 0)
//			System.out.println(" s1 lexographically smaller");
//		else if(res == 0)	
//			System.out.println(" lexographically same");
//		else if(res > 0)
//			System.out.println(" s1 lexographically greater");
		
	}
	
//	given a string of lower case alphabets, print frequencies of character (in sorted order)
	void frequency(String str) {
		int count[] = new int[26];	
		for(int i=0; i<str.length(); i++) {	
			count[str.charAt(i)-97]++;
		}
		for(int i=0; i<26; i++) {	// O(1)
			if(count[i] > 0)
				System.out.println((char)(i + 97) + " " + count[i]);
		}
	}
	
 //	given a string of lower case alphabets, sort the characters in string
//  Counting Sort
	static String sort(String str) {
		int count[] = new int[26];
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)-97]++;
		}
		str = "";
		for(int i=0; i<26; i++) {
			for(int j=0; j<count[i]; j++) {
				str += (char) (i+97);
			}
		}
		return str;
	}
	
	void reverse(String str) {
		char arr[] = str.toCharArray();
		for(int i = 0, j = str.length()-1; i < j; i++, j--) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]);
	}

}
