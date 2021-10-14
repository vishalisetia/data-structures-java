package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		MergeSort m = new MergeSort();
		QuickSort q = new QuickSort();
		CountingSort c = new CountingSort();
		RadixSort r = new RadixSort();
		Problems p = new Problems();
		Integer[] arr = {10, 5, 3, 9, 2};
		p.sortABS(arr, 5, 7);
		
		System.out.println(Arrays.toString(arr));
		
	}

	

}
