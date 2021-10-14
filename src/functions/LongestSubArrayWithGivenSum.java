package functions;

import java.util.HashSet;

public class LongestSubArrayWithGivenSum {
	
//	find length of longest subarray with given sum

//	time = O(n*n)
	int subarraySum(int arr[], int n, int sum) {
		int res = 0;
		for(int i=0; i<n; i++) {
			int s = 0;
			for(int j=i; j<n; j++) {
				s += arr[j];
				if(s == sum)
					res = Math.max(res, j-i+1);
			}
		}
		return res;
	}

	boolean subarraySum2(int arr[], int n, int sum) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int prefix_sum = 0;
		for(int i=0; i<n; i++) {
			prefix_sum += arr[i];
			if(prefix_sum == sum)
				return true;
			if(hs.contains(prefix_sum - sum))
				return true;		
			hs.add(prefix_sum);
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	}

}
