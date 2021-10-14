package functions;

import java.util.Arrays;

public class MajorityElement {

//	9. given an array and size n, find majority element in the array, Majority element is an element that appears more than n/2 times in the array.

//	naive, traverse all the elements of array one by one, for every element count how many times this element appears in the array and if count is > n/2, then simply return that element.
//	time = O(n*n)
	int majority (int[] arr, int n) {
		for(int i=0; i<n; i++) {
			int count = 1;
			for(int j=i+1; j<n; j++) {
				if(arr[i]==arr[j])
					count++;
			}
			if(count > n/2)
				return arr[i];
		}
		return -1;
	}
	
//	first sort the array, then find how many times middle element occurs in the array by traversing left and right from middle
//	time = O(nlogn) + O(n)
	int majority2 (int[] arr, int n) {
		Arrays.sort(arr);
		int x = arr[n/2], i = n/2, j = n/2+1, count = 0;
		while(arr[i]==x && i>=0) {
			count++;
			i--;
		}
		while(arr[j]==x && j<n) {
			count++;
			j++;
		}
		if(count > n/2)
			return x;
		return -1;
	}
	
//	Moore's voting algorithm - jede arr[major] da count 0 aauga oh element kade v majority nhi ho skda, je kise arr[major] da count 0 nhi aaya, ho skde oh majority hove, je oh v na hoya taan koi v majority nhi houga
//	time = O(n)
	int majority3 (int[] arr, int n) {
		int major = 0, count = 1;
		for(int i=0; i<n; i++) {
			if(arr[major] == arr[i])
				count++;
			else
				count--;
			if(count==0) {
				major = i; 
				count = 1;
			}
		}
		count = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == arr[major])
				count++;
		}
		if(count > n/2) 
		    return arr[major];
		else
			return -1;
	}

}
