package functions;

import java.util.HashSet;

public class CountDistinctElementsInArray {

//	count distinct elements in the array
	
	//	Naive - O(n*n) time, O(1) aux space - run two loops. For every element, check if it has appeared before. If no, increment count of distinct elements.
	int distinct(int arr[], int n) {
		int res = 1;
		for(int i=1; i<n; i++) {
			boolean check = false;
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					check = true;
					break;
				}
			}
			if(check == false)
				res++;
		}
		return res;
	}
	
	//	O(n) time and O(n) aux space - we create HashSet
	int distinct2(int arr[], int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<n; i++)
			hs.add(arr[i]);
		return hs.size();
	}
	
//	count distinct elements in union of 2 unsorted arrays
	
//	Naive - time = O((m+n)*(m+n)), aux space = O(m+n), copy all the elements of both the arrays into temp array and then count distinct elements in temp array.
	int union(int arr1[], int arr2[], int m, int n) {
		int temp[] = new int[m+n], count = 0;
		
		for(int i=0; i<m; i++)
			temp[i] = arr1[i];
		
		for(int i=0; i<n; i++)
			temp[m+i] = arr2[i];
		
		for(int i=0; i<m+n; i++) {
			boolean flag = true;
			for(int j=0; j<i; j++) {
				if (temp[i] == temp[j]) {
					flag = false;
					break;
				}
			}
			if(flag == true)
				count++;
		}
		return count;
	}
	
//  O(m+n) time, O(m+n) aux space
	int union2(int arr1[], int arr2[], int m, int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<m; i++)
			hs.add(arr1[i]);
		for(int i=0; i<n; i++)
			hs.add(arr2[i]);
		return hs.size();
	}
	
//	count distinct elements in intersection of 2 unsorted arrays
	
//	Naive, time = O(m*(m+n))
	int intersection(int arr1[], int arr2[], int m, int n) {
		int count = 0;
		for(int i=0; i<m; i++) {
			boolean flag = true;
			for(int j=0; j<i; j++) {
				if(arr1[i] == arr1[j]) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				for(int k=0; k<n; k++) {
					if(arr1[i] == arr2[k]) {
						count++;
						break;
					}
				}
			}
		}
		return count;
	}
	
//  O(m+n) time, O(m) aux space
	int intersection2(int arr1[], int arr2[], int m, int n) {
		int count = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<m; i++)
			hs.add(arr1[i]);
		for(int i=0; i<n; i++) {
			if(hs.contains(arr2[i]) == true) {
				count++;
				hs.remove(arr2[i]);
			}
		}
		return count;
	}

}
