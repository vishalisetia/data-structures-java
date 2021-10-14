package functions;

public class CeilAndFloorInSortedArray {
	
//  find ceil of a number x in sorted array

	int ceil(int[] arr, int low, int high, int x) {
		if(x > arr[high])
			return -1;
		if(x <= arr[low])
			return arr[low];
		if(low == high-1 && x == arr[low])
			return arr[low];
		if(low == high-1 && x != arr[low])
			return arr[high];
		int mid = low + (high-low)/2;
		if(x == arr[mid]) 
			return arr[mid];
		if(x < arr[mid] && x >= arr[low])
			return ceil (arr, low, mid, x);
		return ceil (arr, mid, high, x);
	}
	
	int floor (int[] arr, int low, int high, int x) {
        if(x < arr[low])
            return -1;
        if(x > arr[high]) 
            return high;
    	if(low == high-1 && x == arr[high])
			return high;
		if(low == high-1 && x != arr[high])
			return low;
		
		int mid = low + (high-low)/2;
		if(x == arr[mid]) 
			return mid;
		if(x < arr[mid] && x >= arr[low])
			return floor (arr, low, mid, x);
		return floor (arr, mid, high, x);
	}

}
