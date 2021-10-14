package sorting;

public class CountingSort {

//	cannot be used as a general purpose algorithm for sorting objects with multiple fields, like sorting an array of students by marks.
//  bcz we are putting indexes in the array, and indexes are always integers, so we cant use this algo. for other data types like marks.
//	theta(n+k), k should be small
	void countingSort(int arr[], int n, int k) {
		int count[] = new int[k];
		for(int i=0; i<n; i++) {
			count[arr[i]]++;
		}
		int arrIndex = 0;
		for(int i=0; i<k; i++) {
			for(int j=0; j<count[i]; j++) {
				arr[arrIndex++] = i;
			}
		}
	}
	
//	time = theta(n + k), where k is the range of elements and it should be small
//	space = theta(n + k)
	void countingSort2(int arr[], int n) {
		
		int min = arr[0], max = arr[0];
		for(int i=0; i<n; i++)		{ min = Math.min(min, arr[i]); }
		for(int i=0; i<n; i++)		{ max = Math.max(max, arr[i]); }
		int k = max - min + 1;
		
        int count[] = new int[k]; 									// Create a count array to store count of inidividual elements
        for (int i=0; i<k; i++)		{ count[i] = 0; }				// initialize count array as 0 
		for(int i=0; i<n; i++)		{ count[arr[i]-min]++; }		// store count of inidividual elements in count array
		for(int i=1; i<k; i++)		{ count[i] += count[i-1]; }		// cumulative sum of count array to get the last position where this particular element of above loop should be put	
		
		int temp[] = new int[n];
		for(int i=n-1; i>=0; i--) {									// shift arr elements to temp array based on count array
			temp[count[arr[i]-min]-1] = arr[i];
			count[arr[i]-min]--;
		}
		
		for(int i=0; i<n; i++)		{ arr[i] = temp[i]; }
	}

}
