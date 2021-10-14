package functions;

public class CountOfDigits {
	
// find no. of digits in a given number
	
//  iterative sol
	int find(int x) {
		int count = 0;
		while(x != 0) {
			x=x/10;
			count++;
		}
		return count;
	}
	
//  recursive sol
	int find2(int x) {
		if(x == 0)
			return 1;
		return 1 + find2(x/10);
	}
	
//  tail-recursive sol
	int find3(int x, int ans) {		// ans is 0 intially
		if(x == 0)
			return 1;
		return find3(x/10, ans+1);
	}
	
//  logarithmic sol - log10(x)+1 -> floor -> int, gives the no. of digits in x
	int find4(int x) {
		if(x == 0)
			return 1;
		return (int)Math.floor(Math.log10(x)+1);
	}

//	Digits In Factorial - Given an integer N. The task is to find the number of digits that appear in its factorial, where factorial is defined as, factorial(n) = 1*2*3*4……..*N and factorial(0) = 1.
//	no. of digits = (int) floor(log(n!)) + 1.
//	log(n!) = log(1*2*3....... * n) = log(1) + log(2) + ........ +log(n)
    public int digitsInFactorial(int N)  {
    	double sum = 0;
        for(int i=1; i<=N; i++)
        	sum = sum + Math.log10(i);
		return (int) Math.floor(sum + 1);
    }
    
	// find sum of digits in a number
	int sum(int n) {
		return sumTemp(n,0);
	}
	int sumTemp(int n,int total) {
		if (n==0)
			return total;
		return sumTemp((n/10),total+(n%10));
	}

}
