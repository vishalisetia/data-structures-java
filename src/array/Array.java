package array;

import java.util.ArrayList;
import java.util.Collections;

class Array {
	
	void print(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+", ");
	}
	
//	getting element = O(1)
	int get(int[] arr, int index) {
		return arr[index];
	}
	
//	updating ith element = O(1)
	void update(int[] arr, int index, int x) {
		arr[index] = x;
	}
	
//  find whether x is present in the array or not, return index of x's first occurence in array.
//  (for unsorted, use linear search) – O(n) worst case when element is present at last
//	(for sorted, use binary search) – O(logn) worst case
	int search(int[] arr, int size, int x) {
		for(int i=0; i<size; i++)
			if(arr[i] == x) 
				return i;
		return -1;
	}

//  find minimum value in the array 
	int minValue(int[] arr, int size) {
		int min = arr[0];	// always initialise with first result, dont give random values like 0
		for(int i=1; i<size; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;	
	}
	
//	time = O(n), best case at end = O(1), worst case at beginning = theta(n)
	int insert(int[] arr, int size, int position, int x) {
		if(size == arr.length)
			return size;
		int index = position-1;
		for(int i=size-1; i>=index; i--) 	// shifting starts from back
			arr[i+1] = arr[i];
		arr[index] = x;
		return (size+1);
	}
	
//  delete first occurence of x, theta(n)
	int delete(int[] arr, int size, int x) {
		if(size==0)
			return size;
		int i;
		for(i=0; i<size; i++)
			if(arr[i] == x)
				break;
		if(i == size)
			return size;
		for(int j=i; j<size-1; j++)
			arr[j]=arr[j+1];
		return size-1;
	}
	

	
// reverse array by doing swap first and last value, second and second last value, and so on ...
// time complexity = theta(n/2), aux space = theta(1)
	void reverse(int[] arr, int low, int high) {
		while(low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}

//  Remove duplicates from sorted array, time complexity = O(n), aux-space = O(1)
	int duplicate (int[] arr, int size) {
		int res = 0;
		for (int i=1; i<size; i++) {
			if(arr[i] != arr[res])
				arr[++res] = arr[i];
		}
		for(int i=res+1; i<size; i++) {
			arr[i] = 0;
		}
		return res+1;
	}
	


//	Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader. 
//	time-complexity = theta(n)
	ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
     	int currentLeader = arr[n-1];
     	aList.add(currentLeader);
		for(int i=n-2;i>=0;i--) {
			if (arr[i]>=currentLeader) {
				currentLeader = arr[i];
			    aList.add(currentLeader);
			}
		}
		Collections.reverse(aList);
		return(aList);
	}
//	ArrayList<Integer> x = a.leaders(arr, 5);
//	System.out.println(x);

//	time-complexity = theta(n square)
	int maxDiff(int[] arr,int size) {
		int res = arr[1]-arr[0];
		for(int i=0;i<size-2;i++)
			for(int j=1;j<size-1;j++)
				res = Math.max(res,arr[j]-arr[i]);
		return res;
	}
	
//	time-complexity = theta(n), aux-space = theta(1)
	int maxDiff2(int[] arr,int size) {
		int dif = arr[1]-arr[0];
		int min = arr[0];
		for(int i=1; i<size; i++) {
			dif = Math.max(dif, arr[i]-min);
			min = Math.min(min, arr[i]);
		}
		return dif;
	}

// 	9. stock buy and sell problem
	int maxProfit(int[] arr, int size, int i, int profit) {
		if(i==size)
			return profit;
		int firstElement = arr[i];
		while(i<size) {
			if(arr[i+1] < arr[i]) {
				profit += arr[i]-firstElement;
				break;
			}i++;
		}
		return maxProfit(arr,size,i+1,profit);
	}

// 	9. stock buy and sell problem
	int maxProfit2(int[] arr, int size) {
		int profit=0;
		for(int i=1;i<size;i++)
			if(arr[i] > arr[i-1])
				profit += (arr[i]-arr[i-1]);
		return profit;
	}

//	theta (n*n)
	int water(int[] arr, int size) {
		int res = 0;
		for(int i=1; i<=size-2; i++) {
			
			int lMax = arr[i];
			for(int j=0;j<=i-1;j++)
				lMax = Math.max(lMax, arr[j]);
			
			int rMax = arr[i];
			for(int j=i+1; j<=size-1; j++)
				rMax = Math.max(rMax, arr[j]);
			
			res = res + (Math.min(lMax, rMax) - arr[i]);
		}
		return res;
	}
	
//	time complexity = theta(n+n+n) = theta(n), aux-space = theta(n+n) = theta(n)
	int water2(int[] arr, int size) {
		int res = 0;
		
		int[] lMax = new int[size];
		lMax[0] = arr[0];
		for(int i=1; i<=size-1; i++)
			lMax[i] = Math.max(arr[i], lMax[i-1]);
		
		int[] rMax = new int[size];
		rMax[size-1] = arr[size-1];
		for(int i=size-2; i>=0; i--)
			rMax[i] = Math.max(arr[i], rMax[i+1]);
		
		for(int i=1; i<=size-2; i++)
			res = res + (Math.min(lMax[i],rMax[i])-arr[i]);
		return res;
	}
	
//	Finding maximum consecutive 1's in a binary array
//	time-complexity = theta(n), aux-space = O(1)	 
	int max1(int[] arr, int n) {
		int max = 0, current = 0;
		for(int i=0; i<n; i++)
			if(arr[i] == 1)
				current++;
			else {
				max = Math.max(max,current);
				current = 0;
			 }
		return Math.max(max, current);		
	}


	
//  O (n*n)
	int findMaxCircularSubArray (int[] arr, int n) {
		int res = arr[0];
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum = sum + arr[j];
				res = Math.max(sum, res);
			}
			for(int k=0; k<i; k++) {
				sum = sum + arr[k];
				res = Math.max(sum, res);
			}
		}
		return res;
	}
	
	// O(n)
	int alternate(int[] arr, int n) {
		int max = 1, count = 1;
		for(int i=0; i<=n-2; i++) {
			if( ( arr[i]%2==0 && arr[i+1]%2!=0 ) || ( arr[i]%2!=0 && arr[i+1]%2==0 ) )
				count++; 
			else {
				max = Math.max(max, count);
				count = 1;
			}	
		}
		return Math.max(max, count);
	}
	
	// -10,1,5,-3,20 pos=1	neg=3
	void segregate(int[] arr, int n) {
		int i = 0, j = n-1;
		while(i < j) {
			while(arr[i] < 0)
				i++;
			while(arr[j] >= 0)
				j--;
			swap(arr, j, i);
			i++; 
			j--;
			System.out.println(i + " " + j);
		}
		for(int k=0; k<n; i++) {
			if(j < n) {
				arr[i]=arr[j++];
			}
		}
		if(j == n) {
			
		}
	}
	// 0 -10 1 3 -20
	void positive(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			if(arr[i] > 0 && arr[arr[i]] >= 0 && arr[arr[i]] < n ) {
				arr[arr[i]] = -1 * arr[i];
			}
		}
	}
		
	void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
