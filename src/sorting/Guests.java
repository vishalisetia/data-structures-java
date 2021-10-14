package sorting;

import java.util.Arrays;
import java.util.Comparator;

// you are given arrival and departure times of the guests, you need to find the time to go to the pary so that you can meet maximum people.
public class Guests {

//	time = O(n*n)
	public static int guests(int arr[], int dept[], int n) {
        int res=0;
        for(int i=0; i<n; i++) {
        	int current = 1;
        	for(int j=i+1; j<n; j++) {
        		if( (arr[i] > arr[j] && arr[i] < dept[j]) || (arr[j] > arr[i] && arr[j] < dept[i]) ) {
        			// if arr[i] lies between arr[j] and dept[j] or arr[j] lies between arr[i] and dept[i]
        			current++;
        		}
        	}
        	res = Math.max(res,current);
        }
		return res;
	}
	
//	time = O(n), this fxn works only when arrival array is sorted
    public static int guests2(int arr[], int dep[], int n) {
    	int res = 0, count = 1;
    	for(int i=1; i<n; i++) {
    		if(arr[i] >= arr[i-1] && arr[i] <= dep[i-1]) {
    			count++;
    		}
    		else {
    			res = Math.max(res, count);
    			count = 1;
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		// arrival[i] is key, departure[i] is its value
		int arrival[] = {500,600,700,800};
		int departure[] = {530,830,820,840};
		int n = 4;
        System.out.println(guests(arrival, departure, n));
	}
}
