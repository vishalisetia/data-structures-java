package sorting;

import java.util.ArrayList;

public class Segregation {
	
//  segregate 0's and 1's in binary array or sort binary array	
    void segregateNaive(int arr[], int n) {
		int[] temp = new int[n];
		int tempIndex = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == 0) {
				temp[tempIndex++] = arr[i];
			}
		}
		for(int i=0; i<n; i++) {
			if(arr[i] == 1) {
				temp[tempIndex++] = arr[i];
			}
		}
		for(int i=0; i<n; i++) {
			arr[i] = temp[i];
		}
    }
   
//	sort an array of 0's and 1's
    void segragate01(int arr[], int n) {
		int left = 0, right = n-1;	// left is the next of ending index of 0 elements, right is the previous of endng index of 1 elements
		while(left <= right) {
			switch(arr[left]) {
				case 0:
					left++; break;
				case 1:
					swap(arr, left, right);
					right--; break;
			}
		}
    }
//	Sort an array of 0s, 1s, 2s.
    void segragate012(int arr[], int n) {
    	int left = 0, mid = 0, right = n-1;	// left is the next of ending index of 0 elements, mid is the starting index of 1 elements, right is the previous of endng index of 2 elements
    	while(mid <= right) {
    		switch(arr[mid]) {
				case 0 :
					swap(arr, left, mid);
					left++; mid++; break;
				case 1:
					mid++; break;
				case 2:
					swap(arr, mid, right);
					right--; break;
    		}	
    	}
    }
//  segregate -ve, 0, +ve array elements
	void segNegZeroPos(int[] arr, int n) {
		int left = 0, mid = 0, right = n-1;
		while(mid <= right) {
			if(arr[mid] == 0) {
				mid++;
			}
			else if(arr[mid] < 0) {
				swap(arr, left, mid);
				left++; mid++;
			}
			else if(arr[mid] > 0) {
				swap(arr, mid, right);
				right--;
			}
		}
	}

//	Partitioning around a range.
	void range(int[] arr, int n, int rangeStart, int rangeEnd) {
		int left = 0, mid = 0, right = n-1;
		while(mid <= right) {
			if(arr[mid] < rangeStart) {
				swap(arr, left, mid);
				left++; mid++;
			}
			else if(arr[mid] >= rangeStart && arr[mid] <= rangeEnd) {
				mid++;
			}
			else if(arr[mid] > rangeEnd) {
				swap(arr, mid, right);
				right--;
			}
		}
	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
