package sorting;

import java.util.Arrays;

public class BubbleSort {
	
	static void bubbleRight(int[] arr, int n) {
		for (int lastUnsortedIndex = n-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for(int i=0;i<lastUnsortedIndex;i++) {
				if(arr[i]>arr[i+1]) {
					swap(arr,i,i+1);
				}
			}
		}
	}
	static void bubbleLeft(int arr[], int n) {
		for (int lastSortedIndex = 0; lastSortedIndex < n-1; lastSortedIndex++) {
			for(int i=n-1; i>lastSortedIndex;i--) {
				if(arr[i-1] > arr[i])
					swap(arr,i-1,i);
			}
		}
    }
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {-32,14,-1,75,23,2,5};
		bubbleLeft(arr,7);
		System.out.println(Arrays.toString(arr));
	}

}
