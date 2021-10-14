package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
	
//	merge 2 sorted arrays into 1 sorted array, 
//	time = theta(aSize + bSize) = theta(n), 
//	space = theta(n) to merge two sorted arrays and theta(1) to merge two sorted linkedLists.
	void merge2(int[] a, int[] b, int aSize, int bSize) {
		int temp[] = new int[aSize + bSize];
		int ai = 0, bi = 0, ti = 0;		// ai = aIndex, bi = bIndex, ti = tempIndex;
		while(ai < aSize && bi < bSize) {
			if(a[ai] <= b[bi])
				temp[ti++] = a[ai++];
			else
				temp[ti++] = b[bi++];
		}
		while(ai < aSize)
			temp[ti++] = a[ai++];
		while(bi < bSize)
			temp[ti++] = b[bi++];
		System.out.println(Arrays.toString(temp));
	}
	
//	Here we take a single array with three points namely, the lower, the middle and the highest point. The elements from the lower to the middle are sorted and the elements from the (middle+1) to the higher are sorted. The task is to merge these two sorted parts into one.
//	time = theta(aSize + bSize) = theta(n)
// 	aux space = theta(aSize + bSize) = theta(n)
	void merge(int[] arr, int low, int mid, int high) {
	    int aSize = (mid+1) - low; 							// Find sizes of two subarrays to be merged 
	    int bSize = (high+1) - (mid+1); 					
	    int a[] = new int [aSize]; 							// Create temp arrays a and b
	    int b[] = new int [bSize];
	    for (int aIndex=0; aIndex<aSize; aIndex++) 			// Copy data from arr to a and b = theta(aSize + bSize)
	        a[aIndex] = arr [low + aIndex]; 
	    for (int bIndex=0; bIndex<bSize; bIndex++) 
	        b[bIndex] = arr [mid+1 + bIndex];
	    int aIndex = 0, bIndex = 0, arrIndex = low;			// Merge the temp arrays = theta(aSize + bSize)
	    while (aIndex < aSize && bIndex < bSize) {			// traverse all elements of 2 sub arrays
	    	if(a[aIndex] <= b[bIndex])
	    		 arr[arrIndex++] = a[aIndex++];
	    	else
	    		arr[arrIndex++] = b[bIndex++];
	    }
	    while (aIndex < aSize)								// Copy remaining elements of a[] into arr[] if any
	        arr[arrIndex++] = a[aIndex++];
	    while (bIndex < bSize)								// Copy remaining elements of b[] into arr[] if any
	        arr[arrIndex++] = b[bIndex++];
	}
	
// 	theta(n log n)
	void mergeSort(int[] arr, int l, int h) {
		if(l < h) {
			int m = l + (h-l)/2;
			mergeSort(arr, l, m);	// splitting = theta(log n)
			mergeSort(arr, m+1, h);	// splitting = theta(log n)	
			merge(arr, l, m, h);	// merging = theta(n)
		}
	}
	
//	print the intersection elements of two sorted arrays in sorted order, time = O(aSize + bSize), aux space = O(1)
	ArrayList<Integer> intersection(int[] a, int[] b, int aSize, int bSize) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int aIndex = 0, bIndex = 0;
		while(aIndex < aSize && bIndex < bSize) {
			if(aIndex>0 && a[aIndex] == a[aIndex-1]) {
				aIndex++;
				continue;
			}
			if(a[aIndex] == b[bIndex]) {
				res.add(a[aIndex]);
				aIndex++;
				bIndex++;
			}
			else if(a[aIndex] < b[bIndex])
				aIndex++;
			else if(a[aIndex] > b[bIndex])
				bIndex++;
		}
		return res;
	}
	
//	print the union of two sorted arrays in sorted order, time = O(aSize + bSize), aux space = O(1)
	ArrayList<Integer> union(int[] a, int[] b, int aSize, int bSize) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int aIndex = 0, bIndex = 0;
		while(aIndex < aSize && bIndex < bSize) {
			if( (aIndex>0 && a[aIndex]==a[aIndex-1]) || (bIndex>0 && a[aIndex]==b[bIndex-1]) ) {
				aIndex++; continue;
			}
			if( (bIndex>0 && b[bIndex]==b[bIndex-1]) || (aIndex>0 && b[bIndex]==a[aIndex-1]) ) {
				bIndex++; continue;
			}
			if(a[aIndex] == b[bIndex] ) {
				res.add(a[aIndex++]);
				bIndex++;
			}
			else if(a[aIndex] < b[bIndex])
				res.add(a[aIndex++]);
			else if(a[aIndex] > b[bIndex])
				res.add(b[bIndex++]);
		}
		while(aIndex < aSize) {
			if(aIndex==0 || a[aIndex] != a[aIndex-1])
				res.add(a[aIndex]);
			aIndex++;
		}
		while(bIndex < bSize) {
			if(bIndex==0 || b[bIndex] != b[bIndex-1])
				res.add(b[bIndex]);
			bIndex++;
		}
		return res;
	}
	
//  Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
//	Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j. time = O(n*n)
//	time = O(n*n)
	int inversion(int[] arr, int n) {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i] > arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
//	time = O(n*logn), aux space = O(n)
	int inversion2(int[] arr, int low, int high) {
		int res = 0;
		if(low < high) {
			int mid = low + (high-low)/2;
			res += inversion2(arr, low, mid);
			res += inversion2(arr, mid+1, high);
			res += countAndMerge(arr, low, mid, high);
		}
		return res;
	}

	// theta(n+1)
	int countAndMerge(int[] arr, int low, int mid, int high) {
	    int aSize = (mid+1) - low; 						 
	    int bSize = (high+1) - (mid+1); 					
	    int a[] = new int [aSize]; 						
	    int b[] = new int [bSize];
	    for (int aIndex=0; aIndex<aSize; aIndex++) 		
	        a[aIndex] = arr [low + aIndex]; 
	    for (int bIndex=0; bIndex<bSize; bIndex++) 
	        b[bIndex] = arr [mid+1 + bIndex];
	    int aIndex = 0, bIndex = 0, arrIndex = low, res = 0;
	    while (aIndex < aSize && bIndex < bSize) {		
	    	if(a[aIndex] <= b[bIndex])
	    		 arr[arrIndex++] = a[aIndex++];
	    	else { 
	    		arr[arrIndex++] = b[bIndex++]; 
	    		res += aSize-aIndex;
	    	}
	    }
	    while (aIndex < aSize)							
	        arr[arrIndex++] = a[aIndex++];
	    while (bIndex < bSize)							
	        arr[arrIndex++] = b[bIndex++];
		return res;
	}
}
