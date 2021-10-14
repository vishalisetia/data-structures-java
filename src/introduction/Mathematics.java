package introduction;

public class Mathematics {
	
	// print numbers from n to 1
	static void printNto1(int n) {
		if(n < 1)
			return;
		System.out.print(n + ", ");
		printNto1(n-1);
	}
	
	// print numbers from 1 to n
	void print1toN(int n) {
		if(n < 1)
			return;
		print1toN(n-1);
		System.out.print(n + ", ");
		
	}
	
	void print1toN2(int n, int x) {	//	x = 1 initially
		if(n < 1)
			return;
		System.out.print(x + ", ");
		print1toN2(n-1, x+1);
	}
	
	// non tail recursive function
	static int factorial(int n) {
		if(n == 0)
			return 1;
		return n * factorial(n-1);
	}
	
	// tail recursive function, pass 1 to x
	static int factorial2(int n, int x) {
		if(n == 0)
			return x;
		return factorial2(n-1, n*x);
	}
	
	// find whether string str is palindrome or not. s is starting index and e is ending index of str
	static boolean isPal(String str, int s, int e) {
		if(s >= e)
			return true;
		if(str.charAt(s) != str.charAt(e))
			return false;
		return isPal(str, s+1, e-1);
	}
	
	static int fib(int n) {
		if(n == 0 || n == 1)
			return n;
		return fib(n-1) + fib(n-2);
	}
	


}
