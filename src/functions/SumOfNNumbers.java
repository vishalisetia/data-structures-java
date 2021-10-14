package functions;

public class SumOfNNumbers {

	// given a number n, write a function to find sum of first n natural numbers
	
	// O(n), 1+2+3+4+5......n
	int sum(int n) {
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum = sum + i;
		}
		return sum;
	}
	// O(n*n), 1+(1+1)+(1+1+1)+....(1+1+1...n)
	int sum2(int n) {
		int sum = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<i;j++) {
				sum++;
			}
		}
		return sum;
	}
	
	// O(1)
	int sum3(int n) {
		return n*(n+1)/2;
	}

}
