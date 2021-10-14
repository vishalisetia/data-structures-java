package functions;

import java.util.Arrays;
import java.util.HashSet;

public class PairWithGivenSum {
	
//  given a unsorted array and a sum, find if there is a pair with given sum.
	
//	time = O(n*n)
	boolean isPairNaive(int arr[], int n, int sum) {
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
				if(arr[i] + arr[j] == sum)
					return true;
		return false;
	}
	
//  time = O(nlogn), sort the array and use two pointer approach of binary search
	boolean isPair2(int[] arr, int left, int right, int x) {
		Arrays.sort(arr);
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
	
//	time = O(n), space = O(n) use hastSet 
	boolean isPair3(int arr[], int n, int sum) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			if(hs.contains(Math.abs(sum-arr[i])))
				return true;
			hs.add(arr[i]);
		}
		return false;
	}
	
	public static void main(String args[]) {
		PairWithGivenSum p = new PairWithGivenSum();
		int arr[] = {11,5,5};
		System.out.println(p.isPair3(arr,3,11));
	}

}
