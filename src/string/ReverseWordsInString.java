package string;

// first reverse characters of every word then reverse whole string
public class ReverseWordsInString {
	
//	if we have only 2 words
	void name(String str) {
		System.out.print(str.substring(str.indexOf(" ")+1,str.length()));
		System.out.print(" ");
		System.out.print(str.substring(0,str.indexOf(" ")));
	}
	
	static void reverse(char s[], int low, int high) {
		while(low < high) {
			char t = s[low];
			s[low] = s[high];
			s[high] = t;
			low++;
			high--;
		}
	}
	
	static void reverseWords(String s) {
		char arr[] = s.toCharArray();
		int start=0;
		for(int end=0; end<arr.length; end++) {
			while(arr[end]==' ') {
				reverse(arr, start, end-1);
				start = end+1;
				end = end+1;
			}
		}
		reverse(arr, start, arr.length-1);	// reverse characters of last word
		reverse(arr, 0, arr.length-1);		// reverse whole array
		System.out.println(arr);
	}
	
	public static void main(String[] args) {
		//reverseWords("Hello My World");
		char a[] = {'a','b','c'};
		
	}

}
