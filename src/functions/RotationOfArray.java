package functions;

import java.util.Arrays;

public class RotationOfArray {

//  time-compexity = theta(n), aux-space = theta(1)
	void leftRotateBy1(int[] arr, int size) {
		int temp = arr[0];	
		for(int i=1;i<size;i++)	
			arr[i-1] = arr[i];
		arr[size-1] = temp;
	}	
	
//  time-complexity = theta(nd), aux-space = theta(1)
	void leftRotateByD(int[] arr, int size,int d) {
		for(int i=0;i<d;i++)
			leftRotateBy1(arr, size);
	}
//	time-complexity = theta(n), aux-space = theta(d)
	static int[] leftRotateByD2(int[] arr, int size,int d) {
		int[] tempArray = new int[d];
		for(int i=0; i<d; i++)
			tempArray[i] = arr[i];
		for(int i=d; i<size; i++)
			arr[i-d] = arr[i];
		for(int i=0;i<d;i++)
			arr[i+size-d] = tempArray[i];
		return arr;
	}

//	time-complexity = theta(n), aux-space = theta(1)
	void leftRotateByD3(int[] arr, int size, int d) {
		reverse(arr,0,d-1);
		reverse(arr,d,size-1);
		reverse(arr,0,size-1);
	}
	void reverse(int[] arr, int low, int high) {
		while(low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}

//  given a sorted and rotated array of distinct elements {4, 5, 6, 7, 8, 9, 1, 2, 3}, find largest element (the element around which rotation happen).
//	if middle element is less than leftMost element, then it means that leftHalf is disturbed and largest lies in that, else largest lies in rightHalf.
	int findLargest(int[] arr, int low, int high) {
		if(low==high)
			return low;
		int mid = low + (high-low)/2;
		if (mid < high && arr[mid] > arr[mid + 1]) 
			return mid; 
		if (mid > low && arr[mid] < arr[mid - 1]) 
			return mid-1;
		
		if(arr[mid] < arr[low])
			return findLargest(arr, low, mid-1);
		return findLargest(arr, mid+1, high);
	}
	
	int findSmallest(int[] arr, int low, int high) {
		int res = findLargest(arr, low, high);
		if(res == arr.length-1)
			return 0;
		else
			return res + 1;
	}

//	given a sorted and rotated array of distinct elements, and an element x, find if x is present in the array or not.
//	first find largest element, if it is equal to last element, then array is not rotated and apply binarySearch to whole array, if x is the largest element then return largest only, if x is greater than or equal to first element then apply binarySearch to leftHalf else apply to rightHalf.
	int rotated (int[] arr, int n, int x) {
		int largest = findLargest(arr, 0, n-1);
		if (largest == n-1)
			return binarySearch (arr, 0, n-1, x);
		if (x == arr[largest]) 
			return largest; 
		if (x >= arr[0]) 
			return binarySearch (arr, 0, largest-1, x);
		return binarySearch (arr, largest+1, n-1, x);	
	}
	int binarySearch (int[] arr, int low, int high, int x) {
		if(low > high)
			return -1;
		int mid = low + (high-low)/2;
		if(x == arr[mid]) 
			return mid;
		if(x < arr[mid])
			return binarySearch (arr, low, mid-1, x);
		return binarySearch (arr, mid+1, high, x);
	}
	
	public static void main(String[] args) {
		int[] arr = {4,1,5,6,3,2};
		
		System.out.println(Arrays.toString(leftRotateByD2(arr, 6, 3)));
	}

}
