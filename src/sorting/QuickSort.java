package sorting;

import java.util.Arrays;

//	partition an array around a pivot such that all smaller elements gets placed at left side of pivot and larger element gets placed at right side of pivot element.
public class QuickSort {
	
//	copy smaller element to temp array, then copy equal elements to temp array, then copy greater element to temp array, then copy temp array elements to arr.
//	stable, not in-place, time = O(n), space = O(n)
	int partitionNaive(int[] arr, int low, int high, int pivotIndex) {
		int tempSize = high-low+1;
		int[] temp = new int[tempSize];
		int tempIndex = 0;
		for(int i=low; i<=high; i++) {
			if(arr[i] < arr[pivotIndex])
				temp[tempIndex++] = arr[i];
		}
		int res = tempIndex + low;
		for(int i=low; i<=high; i++) {
			if(arr[i] == arr[pivotIndex])
				temp[tempIndex++] = arr[pivotIndex];
		}
		for(int i=low; i<=high; i++) {
			if(arr[i] > arr[pivotIndex])
				temp[tempIndex++] = arr[i];
		}
		for(int i=0; i<tempSize; i++) {
			arr[i+low] = temp[i];
		}
		return res;
	}
	
//	2-way partitioning, when we have all distinct elements, when we do not have multiple occurences of pivot means all elements are distinct in the array
//	unstable, in-place, time = O(n), space = O(1)
	int partitionLomuto(int[] arr, int low, int high, int pivotIndex) {
		swap(arr, high, pivotIndex);			// swap to place pivot element at last
		int left = low, right = high-1;
		while(left <= right) {
			if(arr[left] < arr[high]) {
				left++;
			}
			else if(arr[left] > arr[high]) {
				swap(arr, left, right);
				right--;
			}
		}
		if(arr[left] > arr[high])
			swap(arr, left, high);
		return left;
	}
	
//	3-way partitioning, when we dont have all distinct elements, when we have may have multiple occurences of pivot means all elements are not distinct in the array
//	unstable, in-place, time = O(n), space = O(1)
	int partitionLomuto2(int[] arr, int low, int high, int pivotIndex) {
		swap(arr, high, pivotIndex);		
		int left = low, mid = low, right = high-1;	// left is the last index of smaller elements partition, mid is the last index of equal elements partition, right is the first index of larger elements partition
		while(left <= right) {
			if(arr[mid] < arr[high]) {
				swap(arr, left, mid);
				left++; mid++;
			}
			else if(arr[mid] == arr[high]) {
				mid++;
			}
			else if(arr[mid] > arr[high]) {
				swap(arr, mid, right);
				right--;
			}
		}
		if(arr[left] > arr[high])
			swap(arr, left, high);
		return left;
	}
	
//	time = O(n), space = O(1)
	int partitionHoare(int[] arr, int low, int high, int pivotIndex) {
		swap(arr, low, pivotIndex);		
		int i = low+1, j = high, pivot = arr[low];
		while(true) {
			while(arr[i] < pivot && i < high) 
				i++;
			while(arr[j] > pivot) 
				j--;
			if(i >= j) {
				if(arr[j] < arr[low])
					swap(arr, low, j);
				return j;
			}
			swap(arr, i, j);
		}
	}


//	nlogn
//	space complexity of Quick Sort is O(log(n)), this is because after partitioning, the partition with the fewest element is (recursively)sorted first, requiring at most O(log(n)) space. And the other partition is sorted using tail-recursion, which doesn't add to the call stack.This keeps the stack depth bounded by O(log(n)).
	void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pivotIndex = low + ((int)Math.random() * high);		// finds the random number between low and high
			int p = partitionHoare(arr, low, high, pivotIndex);		// we can use any partition method above
			quickSort(arr, low, p-1);
			quickSort(arr, p+1, high);
		}
	}
	
//	Kth smallest element - Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
//	time = O(n logn)
	int small(int[] arr, int n, int k) {
		Arrays.sort(arr);
		return arr[k-1];
	}
	
//	Quick select algo 
//	worst case = O(n*n)
	int small2(int[] arr, int n, int k) {
		int left = 0, right = n-1;
		while(left <= right) {
			int pivotIndex = left + ((int)Math.random() * right);
			int p = partitionLomuto(arr, left, right, pivotIndex);
			if(p == k-1)
				return arr[p];
			else if(p < k-1)	// we are recurring only one part either left or right after partitioning
				left = p+1;
			else if(p > k-1)
				right = p-1;
		}
		return -1;	// when k is > n
	}
	
//	chocolate distribution problem - given an array of packets which contains no. of chocolates equal to its value and m children, now distribute these packets to k children
//	time = O(nlogn)
	int choco(int[] arr, int n, int m) {
		if(m > n) 
			return -1;
		Arrays.sort(arr);
		int res = arr[0+m-1] - arr[0];	// for i=0
		for(int i=1; (i+m-1)<n; i++) {
			res = Math.min(res, arr[i+m-1]-arr[i]);
		}
		return res;
	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
