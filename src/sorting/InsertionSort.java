package sorting;

import java.util.Arrays;

public class InsertionSort {
	
//	time = O(n*n)
//	space complexity of Insertion Sort is O(1) because it uses few temporary variables during swapping.
	public static void insertionSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {						// in unsorted part, traverse from left to right by i
			int x = arr[i];									// x is just a hold to arr[i]
			int j;
			for (j = i-1; j >= 0 && arr[j] > x; j--) {		// in sorted part, traverse from right to left by j
				arr[j+1] = arr[j];
			}
			arr[j+1] = x;
		}
	}
	
	public static void shellSort(int[] arr, int n) {
		for(int gap = n-1 / 2; gap>0; gap /= 2) {
			for(int i = gap; i < n; i++) {
				int newElement = arr[i];
				int j;
				for(j=i; j>=gap && arr[j-gap] > newElement; j -= gap ) {
					arr[j] = arr[j-gap];
				}
				arr[j] = newElement;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {3,5,2,7,8,6,1,4};
		System.out.println(Arrays.toString(arr));
		insertionSort(arr, 8);
		System.out.println(Arrays.toString(arr));
	}
	
}
