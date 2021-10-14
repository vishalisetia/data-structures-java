package functions;

import java.util.HashSet;

public class SubArrayWithGivenSum {
	
//	find a sub-array which adds to a given number sum.

//	time = O(n*n), naive
	boolean subarraySum(int arr[], int n, int sum) {
		for(int i=0; i<n; i++) {
			int s = 0;
			for(int j=i; j<n; j++) {
				s += arr[j];
				if(s == sum) {
					System.out.print("from " + i + " index to " + j + " index");
	        		return true;
				}	
			}
		}
		return false;
	}
	
//	time = O(n), space = O(n), store cumulative sum (prefix sum) in a hashset
	boolean subarraySum2 (int arr[], int n, int sum) {
		HashSet<Integer> hs = new HashSet<Integer>();	// stores all the prefix sums, we can use array also but then searching will be costly operation
		int prefix_sum = 0;
		for(int i=0; i<n; i++) {
			prefix_sum += arr[i];
			if(prefix_sum == sum)
				return true;
			if(hs.contains(prefix_sum - sum))
				return true;			//  since the HashSet is backed by a HashMap, there are no methods to access its elements by index
			hs.add(prefix_sum);
		}
		return false;
	}
	
//	time = O(n), when arr of non-negative integers is given use two pointer approach
    boolean subarraySum3 (int arr[], int n, int sum) {
        int i=0, j=1, s = arr[i];
        while(j <= n && i <= n) {
        	if(s == sum) {
        		System.out.println("from " + i + " index to " + (j-1) + " index");
        		return true;
        	}	
        	if(j==n && i==n) {
        		return false;
        	}
        	else if(s < sum && j < n)
        		s = s + arr[j++];
        	else if(s > sum && i < n)
        		s = s - arr[i++];
        }
		return false; 
    }
    
    public static void main(String args[]) {
    	SubArrayWithGivenSum s = new SubArrayWithGivenSum();
    	int arr[] = {1,0,2,3,1};
    	System.out.println(s.subarraySum3(arr, 5, 6));
    	;
    }

}
