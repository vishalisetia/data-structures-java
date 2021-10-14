package functions;

public class SquareRoot {

//	find floor of square root of x
	
//	time = O(square root of x), use recursion
	int findSquareRoot(int x) {
		int i=1;
		int res = sq(i, x);
		return res;
	}
	int sq(int i, int x) {
		while(i <= x) {
			if((i*i) == x)
				return i;
			else if((i*i) < x)
				return sq(i+1, x);
			else
				return i-1;
		}
		return x;
	}
	
//	time = O(square root of x), use 2 pointer approach
	int findSquareRoot2(int x) {
		if(x==0 || x==1)
			return x;
		int low = 1, high = x, res = 0;
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(mid*mid == x)
				return mid;
			if(mid*mid < x) {
				low = mid+1;
				res = mid;
			}
			if(mid*mid > x)
				high = mid-1;
		}
		return res;
	}

}
