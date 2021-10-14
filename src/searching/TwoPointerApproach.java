package searching;

import java.util.Arrays;

// 2 pointer approach takes O(n) time
public class TwoPointerApproach {

// 1. given a unsorted array and a sum, find if there is a pair with given sum.

//  Time complexity = O(n)
	boolean pair2(int[] arr, int left, int right, int x) {
		while(left < right) {
			if(arr[left] + arr[right] == x)
				return true;
			else if(arr[left] + arr[right] > x)
				right--;
			else if(arr[left] + arr[right] < x)
				left++;
		}
		return false;
	}
	
	//	given a sorted array of n integers. find a pair 'a' and 'b' such that |a-b| = k , k being a positive integer.
	boolean pair3(int[] arr, int n, int x) {
		int left = 0, right = 0;
		while(left < right) {
			if(Math.abs(arr[left] - arr[right]) == x)
				return true;
			else if(Math.abs(arr[left] - arr[right]) > x)
				left++;
			else
				right++;
		}
		return false;
	}
	
// 3. given a unsorted array and a sum, find if there is a triplet with given sum.
	boolean triplet(int[] arr, int n, int x) {
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
				for(int k=j+1; k<n; k++) 
					if( (arr[i]+arr[j]+arr[k]) == x)
						return true;
		return false;
	}
	
//	4. given a sorted array and a sum, find if there is a triplet with given sum.
//  Time complexity = O(n2)
//	fix every element one by one, then apply two pointer approach to find the pair with x minus the fixed element in remaining array after the fixed element. for unsorted, first sort the array and then use 2 pointer approach. 
	boolean triplet2(int[] arr, int n, int x) {
		for(int i=0;i<n;i++)
			if( pair2(arr, i+1, n-1, x-arr[i]) )
				return true;
		return false;
	}
	
// 5. given a sorted array and a sum, count pairs with given sum.

// 6. count triplets with given sum

// 7. find if there is a triplet a,b,c such that a2 + b2 = c2
	

	
}