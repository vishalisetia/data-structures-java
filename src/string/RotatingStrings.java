package string;

public class RotatingStrings {
	
	// rotate the string str , count times
	
	public static String rotate(String s1, int count) {
		return s1.substring(count,s1.length())+s1.substring(0,count);
	}
	
	public static String rotate2(String str, int count) {
		String x = new String("");
		for(int i=count; i<str.length(); i++) {
			x = x+str.charAt(i);
		}
		for(int i=0; i<count; i++) {
			x = x + str.charAt(i);
		}
		return x;
	}
	
	// check if strings are rotations of each other
	// naive
	public static boolean isRotated(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		int count = 1;
		while(count <= str1.length()) {
			String x = new String("");
			for(int i=count; i<str1.length(); i++) {
				x = x+str1.charAt(i);
			}
			for(int i=0; i<count; i++) {
				x = x + str1.charAt(i);
			}
			if(x == str2)
				return true;
			else
				count++;
		}
		return false;
	}
	
	// if no. of rotation is given, e.g.; 2
    public static boolean isRotated2(String s1, String s2) {
        if(s1.length() == 1) {
        	if(s1.equals(s2)) 
        		return true;
        	else
        		return false;
        }
        return (s1.substring(2,s1.length())+s1.substring(0,2)).equals(s2) || (s1.substring(s1.length()-2,s1.length())+s1.substring(0,s1.length()-2)).equals(s2);
        
    }
	
	public static boolean isRotated3(String str1, String str2) {
		if(str1.length() != str2.length()) {	// for (abcdefabcdef,defab) like cases
			return false;
		}
		return (str1 + str1).indexOf(str2) >= 0;	// theta(n) auxiliary space to create temporary string
	}
	
	public static void main(String[] args) {
		System.out.println(rotate("amazon",2));
		//System.out.println(rotation2("abacb","acbab"));
		System.out.println(isRotated("amaon","onama"));
	}

}
