package searching;

public class BinarySearch {
	
//  for unsorted array, linear search, O(n)
//	average case occurs, when the item to be searched is in some where middle of the Array.
//	best case occurs, when the item to be searched is in starting of the Array.
//	worst case occurs,when the item to be searched is in end of the Array.
	int linearSearch(int[] arr, int n, int x) {
		for(int i=0; i<n; i++)
			if(arr[i] == x)
				return i;
		return -1;
	}
	
//  for sorted array, binary search, O(log n)
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
	
//	given a sorted array with repititions, find left most index of an element.
	int left (int[] arr, int low, int high, int x) {
		if(low > high) {
			return -1;
		}
		int mid = low + (high-low)/2;
		if(x == arr[mid] && (mid==0 || x!=arr[mid-1]) ) 
			return mid;
		else if(x <= arr[mid])
			return left (arr, low, mid-1, x);
		else // if(x > arr[mid])
			return left (arr, mid+1, high, x);
	}
	
//	given a sorted array with repititions, find right most index of an element.
	int right (int[] arr, int low, int high, int x) {
		if(low > high)
			return -1;
		int mid = low + (high-low)/2;
		if(x == arr[mid] && (mid==arr.length-1 || x!=arr[mid+1]) ) 
			return mid;
		else if(x < arr[mid])
			return right (arr, low, mid-1, x);
		else // if(x >= arr[mid])
			return right (arr, mid+1, high, x);
	}
	

	
//	given a sorted array with repititions, count occurences of an element.
	int count (int[] arr, int low, int high, int x) {
		return ( right(arr,low,high,x) - left(arr,low,high,x) + 1  );
	}
	
    public int right (int[] arr, int low, int high) {
    	if(low > high)
    		return -1;
    	int mid = low + (high-low)/2;
    	if(1 == arr[mid] && (mid==arr.length-1 || 0==arr[mid+1]) ) 
    		return mid;
    	else if (1 == arr[mid] && (mid==arr.length-1 || 1==arr[mid+1]) ) 
    	    return right(arr, mid+1, high);
    	else //if(0 == arr[mid])
    		return right (arr, low, mid-1);
	}
	
//	count 1's in a sorted binary array
//	{0,0,0,0,0,1,1,1}
	int binary (int[] arr, int n) {
		int low = 0;
		int high = n-1;
		int x = left(arr,low,high,1);
		return n-x;
	}
	
//	given an infinite sized sorted array and an element x, find if x is present in the array or not.
//	we need to find the range in which x will present and then apply binary search on that range.
	int infinite (int[] arr, int x) {
		if(arr[0] == x)
			return 0;
		int i=1;
		while(i>0) {
			if(x == arr[i])
				return i;
			else if(x > arr[i])
				i = i*2;	// for (log n) time complexity use i=i*2 or i=i/2
			else if(x < arr[i]) 
				return binarySearch(arr, i/2, i, x);
		}
		return -1;
	}
	

	
//	given an unsorted array, find any one peak element in the array (peak element is not smaller than its neighbours)
//  if both neighbours are smaller than or equal to mid, then mid is peak.
//	if left neighbour is greater than or equal to mid, then a peak lies in leftHalf. 
//	if right neighbour is greater than or equal to mid, then peak lies in rightHalf. 
//	if both neighbours are greater, then peak lies in both halves.	
	int peak(int[] arr, int low, int high, int n) {
		if(low == high)
			return high;
		if(low > high)
			return -1;
		int mid = low + (high-low)/2;
		if( (mid==0 || arr[mid-1] <= arr[mid]) && (mid==n-1 || arr[mid+1] <= arr[mid]) )
			return mid;
		else if( mid > 0 && arr[mid-1] > arr[mid] )
			return peak(arr, low, mid-1, n);
		else
			return peak(arr, mid+1, high, n);
	}
}
