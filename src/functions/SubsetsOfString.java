package functions;

public class SubsetsOfString {

//  Given a String, print all subsets of it (in any order)
	void subsets(String str) {
		subsetsTemp("ABC", " ", 0);
	}
	void subsetsTemp(String str, String current, int index) {
		if(index == str.length()) {
			System.out.print("'" + current + "' ");
			return;
		}
		subsetsTemp(str, current, index+1);
		subsetsTemp(str, current + str.charAt(index), index+1);
	}

}
