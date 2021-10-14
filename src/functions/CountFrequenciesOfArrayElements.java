package functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountFrequenciesOfArrayElements {

//	Count frequencies of array elements
	
	// Naive - O(n*n) time, O(1) aux space - run two loops. For every element, check if it has appeared before. If no, count another occurences of that element in rest of the array.
	void frequencies(int arr[], int n) {
		for(int i=0; i<n; i++) {
			boolean flag = false;
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					flag = true;
					break;
				}	
			}
			if(flag == false) {	
				int count = 1;
				for(int j=i+1; j<n; j++) {
					if(arr[i] == arr[j])
						count++;
				}
				System.out.println(arr[i] + " occurs " + count + " time.");
			}
		}
	}
	
//	O(n) time, O(n) aux space
    void frequencies2(int arr[], int n)	{
    	int temp[] = new int[n];
    	for(int i=0; i<n; i++)
    		temp[i] = arr[i];
    	for(int i=0; i<n; i++)
    		temp[i] -= 1;
    	for(int i=0; i<n; i++)
    		temp[temp[i]%n] += n;		// find why temp[temp[i]] += n; is not correct for i<n
    	for(int i=0; i<n; i++)
    		temp[i] /= n;
    	System.out.println(Arrays.toString(temp));
    }
	
//	O(n) time, O(n) aux space, use hashmap
	void frequencies3(int arr[], int n) {
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i=0; i<n; i++) {
			if(hm.get(arr[i]) == null)
				hm.put(arr[i], 1);
			else
				hm.put(arr[i], hm.get(arr[i]) + 1);
		}
		
		for(Map.Entry<Integer,Integer> i : hm.entrySet())
			System.out.println(i.getKey() + " occurs " + i.getValue() + " time.");
		
		// how to print elements in same order as they appear in input? - To print elements according to first occurrence, traverse array one more time print frequencies of elements and mark frequencies as -1 so that same element is not printed multiple times.  
		for(int i=0; i<n; i++) {
			if(hm.get(arr[i]) != -1) {
				System.out.println(arr[i] + " occurs " + hm.get(arr[i]) + " time.");
				hm.put(arr[i], -1);
			}
		}
	}

}
