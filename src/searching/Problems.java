package searching;

import java.util.Arrays;

public class Problems {
	
    public int right (int[] arr, int low, int high) {
    	if(low > high) {
    		return -1;
    	}
    	int mid = low + (high-low)/2;
    	if(1 == arr[mid] && (mid==arr.length-1 || 0==arr[mid+1]) ) 
    		return mid;
    	else if (1 == arr[mid] && (mid==arr.length-1 || 1==arr[mid+1]) ) 
    	    return right(arr, mid+1, high);
    	else //if(0 == arr[mid])
    		return right (arr, low, mid-1);
	}
    
    static long findSmallest(int arr[], long low, long high)
    {
		int res = findLargest(arr, low, high);
		if(res == arr.length-1)
			return arr[0];
		else
			return arr[res+1];
        
    }
	static int findLargest(int[] arr, long low, long high) {
		// base cases
		if(low==high)
			return (int) low;
		long mid = low + (high-low)/2;
		if (mid < high && arr[(int) mid] > arr[(int) (mid + 1)]) 
			return (int) mid; 
		if (mid > low && arr[(int) mid] < arr[(int) (mid - 1)]) 
			return (int) (mid-1);
		
		if(arr[(int) mid] < arr[(int) low])
			return findLargest(arr, low, mid-1);
		return findLargest(arr, mid+1, high);
	}
    
//	You are given an array of N+2 integer elements. All elements of the array are in range 1 to N. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.
	//{4, 6, 2, 5, 2, 4, 3, 7, 1}
	void twoRepeated(int arr[], int N){
        for(int i=0; i<N+2; i++) {
        	if(arr[Math.abs(arr[i])] < 0)
        		System.out.println(Math.abs(arr[i]));
        	else
        		arr[Math.abs(arr[i])] = -1 * arr[Math.abs(arr[i])];
        }
    }
    
//	Maximum Water Between Two Buildings - Given an integer array representing the heights of N buildings, the task is to delete N-2 buildings such that the water that can be trapped between the remaining two building is maximum. Note: The total water trapped between two buildings is gap between them (number of buildings removed) multiplied by height of the smaller building.
	int maxWater(int height[], int n) {
	    int l = 0, r = n-1, res = 0;
	    while (l < r) {
	        int total = Math.min(height[l], height[r]) * (r-l-1);
	        res = Math.max(res, total);
	        if (height[l] <= height[r]) 
	            l++;
	        else 
	            r--;
	    }
	    return res;
	} 
	
//	i dont know why this method is wrong
//  int[] arr = {16, 11, 16, 62,  2, 97, 61,  1, 66, 32, 
//	 			 58, 48, 17,  5, 93,  3, 83, 91, 84, 14, 
//	 			  5, 52, 58, 26, 37, 36, 81, 55, 55, 40, 
//				 65, 24, 97, 98, 75, 88, 97, 29, 45, 36, 
//				 77, 40,  2, 06, 13, 84, 90, 89, 91, 43, 
//				 41, 51, 66, 86, 63, 96, 92,  8 ,60, 77, 
//				 99, 60, 90, 59, 48, 30, 49};
	int maxWater2(int height[], int n)  {	
        int res = 0, lastIndex = n-1;
        for(int i=0; i<=n-1; i++) {
            int leftDistance = Math.min(height[0] , height[i]) * (i-0-1);
            int rightDistance = Math.min(height[i] , height[n-1]) * (lastIndex-i-1);
        	int distance = Math.max(leftDistance, rightDistance);	// check whether i is far from 1st building or last building
        	res = Math.max(res, distance);
        }
        return res;
    } 
    
    static int maxStep(int A[], int N){
    	int res = 0;
    	int count = 0;
    	for(int i=0; i<N-1; i++) {
    		if(A[i+1] > A[i]) {
    			count++;
    			res = Math.max(res, count);
    		}
    		else {
    			count=0;
    		}
    	}
    	return res;
    }
    
    static int missingNumber(int arr[], int size) {
       // seggregate +ve and -ve numbers
       int i=0, j=size-1;
       while(i < j) {
    	   if(arr[i] <= 0) {
    		   swap(arr, i, j);
    		   j--;
    	   }
    	   else
    		   i++;
       }
       if(arr[i] < 0)
    	   i = i-1;
       
       // index referencing in postive numbered array
       int sizePositive = i+1;
       for(int k=0; k<=i; k++) {
    	   if(arr[k] <= sizePositive && Math.abs(arr[k])-1 >= 0) {
    		   arr[Math.abs(arr[k])-1] = -1 * arr[Math.abs(arr[k])-1];
    	   }
       }
       
       int k = 0;
       while(k < size && arr[k] < 0) {
    	   k++;
       }
       return k+1;
    }
    
    static void swap(int[] arr, int i, int j) {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    
//	Count More than n/k Occurences - Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.
//	Time = O(N), Space = O(N)
    public int countOccurence(int[] arr, int n, int k) {
    	int max = arr[0], min = arr[0], cLength = 0;
        for(int i=0; i<n; i++) {
        	max = Math.max(max, arr[i]);
        }
        for(int i=0; i<n; i++) {
        	min = Math.min(min, arr[i]);
        }
        if(min < 0)
        	cLength = max - min + 1;
        else
        	cLength = max + 1;
        int count[] = new int[cLength], res = 0;
        for(int i=0; i<cLength; i++) {
        	count[i] = 0;
        }
        for(int i=0; i<n; i++) {
        	count[arr[i]-1]++;
        }
        for(int i=0; i<cLength; i++) {
        	if(count[i] > n/k)
        		res++;
        }
        return res;
    }
	
//	Count only Repeated - Given an array arr[] of N positive integers, where elements are consecutive (sorted). Also, there is a single element which is repeating X (any variable) number of times. Now, the task is to find the element which is repeated and number of times it is repeated.
//	Integer arr[] = {1, 2, 2, 2, 2, 3, 4};
//	time = O(logn), space = O(1)
    public static void findRepeating(Integer arr[], int n) {	
        if (n == 0) 
            System.out.println("No repeating element");
       
        int low = 0, high = n-1; 
        while (low < high) { 
            int mid = low + (high-low) / 2;
            if (arr[mid] >= mid + arr[0]) 	// if a[mid] = mid + a[0], there is no repeating character in [s..m] 
                low = mid + 1;
            else							// if a[mid] < mid + a[0], there is a repeating character in [s..m] 
                high = mid; 
        } 
        int count =  n - (arr[n-1] - arr[0]);
        System.out.println(arr[low] + " is repeating " + count + " times");
    }
    
}
