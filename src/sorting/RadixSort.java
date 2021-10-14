package sorting;

// works better than counting sort if ur range,k is bigger than linear
public class RadixSort {

//  time = theta(d * (n + k)), where d is the no. of digits in maximum element in the array, k and d are inversely proportional to eah other, so either compromise with time or with space, as d is for time (dn) and k is for space (dk)
//  space = theta(n + k)
	void radixSort(int arr[], int n) {
		int maxElement = arr[0];
		for(int i=0; i<n; i++)	{maxElement = Math.max(maxElement, arr[i]);}
		for(int exp = 1; maxElement/exp > 0; exp = exp*10)	{
			countingSort(arr, n, exp);
		}
	}

//  theta(n + k), k should be > 10
	void countingSort(int[] arr, int n, int exp) {
		
		int k = 10;		// k will always be 10 bcz we can have digits from 0 to 9 only on a place like 1's place, 10's place etc.
		int count[] = new int[k];
		for(int i=0; i<k; i++)		{ count[i] = 0; }
		for(int i=0; i<n; i++)		{ count[(arr[i]/exp)%k]++; }
		for(int i=1; i<k; i++)		{ count[i] += count[i-1]; }
		
		int temp[] = new int[n];
		for(int i=n-1; i>=0; i--) {
			temp[count[(arr[i]/exp)%k]-1] = arr[i];
			count[(arr[i]/exp)%k]--;
		}
		
		for(int i=0; i<n; i++) 		{ arr[i] = temp[i]; }
	}

}
