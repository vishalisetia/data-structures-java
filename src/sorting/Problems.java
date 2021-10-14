package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problems {
	
    static int findNumberOfTriangles(int arr[], int n) {
    	Arrays.sort(arr);
    	int count = 0;
    	for(int i = n-1; i > 1; i--) {
	    	int left=0, right=i-1;
	    	while (left < right) {
	    		if(arr[left] + arr[right] > arr[i]) {
	    			count += right-left;
	    			right--;
	    		}
	    		else
	    			left++;
	    	}
    	}
    	return count;
    }
    
//	Given an array of integers. Check whether it contains a triplet that sums up to zero.
	public static boolean findTriplets(int arr[] , int n) {
		Arrays.sort(arr);
		for(int i=0; i<n-2; i++) {
			int left = i+1, right = n-1;
			while(left < right) {
				if(arr[left] + arr[right] == -arr[i]) {
					return true;
				}
				else if(arr[left] + arr[right] < -arr[i]) {
					left++;
				}
				else if(arr[left] + arr[right] > -arr[i]) {
					right--;
				}
			}
		}
		return false;
    }

//  Given an array and an integer. Find if there's a triplet in the array which sums up to the given integer. 
    public static int find3Numbers(int arr[], int N, int X) { 
    	Arrays.sort(arr);
    	for(int i=0; i<N; i++) {
    		int left = i+1, right = N-1;
        	while(left < right) {
        		if(arr[left] + arr[right] == X-arr[i]) {
        			return 1;
        		}
				else if(arr[left] + arr[right] < X-arr[i]) {
					left++;
				}
				else if(arr[left] + arr[right] > X-arr[i]) {
					right--;
				}
        	}
    	}
        return 0;
    }
    
    static long countPairs(int x[], int y[], int n, int m) {
        Arrays.sort(x);
        Arrays.sort(y);
        int a=0, b=0, count = 0;
        while(a<n && b<m)
        if (Math.pow(x[a], y[b]) > Math.pow(y[b], x[a])) {
        	count = count + n-a;
        	b++;
        }
        else if (Math.pow(x[a], y[b]) == Math.pow(y[b], x[a])) {
        	count = count + n-a-1;
        	b++;
        }
        else if (Math.pow(x[a], y[b]) < Math.pow(y[b], x[a])) 
        	a++;
        return count;
    }
    
//	merge 3 sorted arrays into 1 sorted array, 
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[]) {
    	ArrayList<Integer> temp = new ArrayList<Integer>(A.length + B.length + C.length);
    	int ai = 0, bi = 0, ci = 0;
    	while(ai < A.length && bi < B.length && ci < C.length) {
    		if(A[ai] <= B[bi] && A[ai] <= C[ci])
    			temp.add(A[ai++]);
    		else if(B[bi] <= A[ai] && B[bi] <= C[ci])
    			temp.add(B[bi++]);
    		else if(C[ci] <= A[ai] && C[ci] <= B[bi])
    			temp.add(C[ci++]);
    	}
		while(ai < A.length && bi < B.length && ci == C.length) {
			if(A[ai] <= B[bi])
				temp.add(A[ai++]);
			else
				temp.add(B[bi++]);
		}
		while(ai < A.length && ci < C.length && bi == B.length) {
			if(A[ai] <= C[ci])
				temp.add(A[ai++]);
			else
				temp.add(C[ci++]);
		}
		while(bi < B.length && ci < C.length && ai == A.length) {
			if(B[bi] <= C[ci])
				temp.add(B[bi++]);
			else
				temp.add(C[ci++]);
		}
		while(ai < A.length)
			temp.add(A[ai++]);
		while(bi < B.length)
			temp.add(B[bi++]);
		while(ci < C.length)
			temp.add(C[ci++]);
    	return temp;
    }
    
//	Closer to sort - Given an array arr[](0-based indexing) of N integers which is closer sorted (defined below) and an element x. The task is to find index of the element x if it is present. If not present, then print -1.
//  Closer Sorted: First array is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e, may be to the arr[i+1] or arr[i-1].
	long binarySearch (int[] arr, int low, int high, long x) {
		if(low > high)
			return -1;
		int mid = low + (high-low)/2;
		if(x == arr[mid]) 
			return mid;
		if(mid-1 >= low && x == arr[mid-1])
		    return mid-1;
		if(mid+1 <= high && x == arr[mid+1])
		    return mid+1;
		if(x < arr[mid])
			return binarySearch (arr, low, mid-1, x);
		return binarySearch (arr, mid+1, high, x);
	}
	
    static long inversionCount(long arr[], long N)
    {
    	return inversion2(arr, 0, N-1);
    }
	static long inversion2(long[] arr, long low, long high) {
		int res = 0;
		if(low < high) {
			long mid = low + (high-low)/2;
			res += inversion2(arr, low, mid);
			res += inversion2(arr, mid+1, high);
			res += countAndMerge(arr, low, mid, high);
		}
		return res;
	}
	static long countAndMerge(long[] arr, long low, long mid, long high) {
		long aSize = (mid+1) - low; 						 
		long bSize = (high+1) - (mid+1); 					
		long a[] = new long[(int) aSize]; 						
		long b[] = new long[(int) bSize];
	    for (long aIndex=0; aIndex<aSize; aIndex++) 		
	        a[(int) aIndex] = arr [(int) (low + aIndex)]; 
	    for (long bIndex=0; bIndex<bSize; bIndex++) 
	        b[(int) bIndex] = arr [(int) (mid+1 + bIndex)];
	    long aIndex = 0, bIndex = 0, arrIndex = low, res = 0;
	    while (aIndex < aSize && bIndex < bSize) {		
	    	if(a[(int) aIndex] <= b[(int) bIndex])
	    		 arr[(int) arrIndex++] = a[(int) aIndex++];
	    	else { 
	    		arr[(int) arrIndex++] = b[(int) bIndex++]; 
	    		res += aSize-aIndex;
	    	}
	    }
	    while (aIndex < aSize)							
	        arr[(int) arrIndex++] = a[(int) aIndex++];
	    while (bIndex < bSize)							
	        arr[(int) arrIndex++] = b[(int) bIndex++];
		return res;
	}
	
//	Sort by Absolute Difference - Given an array of N elements and a number K. The task is to arrange array elements according to the absolute difference with K, i.e., element having minimum difference comes first and so on. If two or more elements are at equal distance arrange them in same sequence as in the given array.
    static void sortABS(Integer arr[], int n, final int k) {
//        int diff[] = new int[n];
//        for(int i=0; i<n; i++) {
//        	diff[i] = Math.abs(arr[i] - k);
//        }
    	//for(i)
        Arrays.sort(arr, new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		//	if a- k < b - k then return 1 else return 0.
        		if(Math.abs(a-k) < Math.abs(b-k))
        			return 1;
        		else
        			return 0;
        	}
        });
    }
    
    public static void swap(int[] arr, int i, int j) {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }

}
