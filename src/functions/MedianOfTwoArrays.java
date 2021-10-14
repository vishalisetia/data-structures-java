package functions;

import java.util.Arrays;

public class MedianOfTwoArrays {

//	find median of two sorted arrays having size n1 and n2 each
	
//	time = O((n1+n2)*log(n1+n2))
	float median(int arr1[], int n1, int arr2[], int n2) {
		int n = n1 + n2;
		int[] temp = new int[n];
		for(int i=0; i<n1; i++) {
			temp[i] = arr1[i];
		}
		for(int i=0; i<n2; i++) {
			temp[i+n1] = arr2[i];
		}
		Arrays.sort(temp);
		float median = 0;
		if(temp.length % 2 == 0)
			median = (float) (temp[temp.length/2-1] + temp[temp.length/2]) / 2;
		else
			median = temp[temp.length/2];
		return median;
	}
	
//	time = O(n1+n2), merge sort technique
    float median2(int arr[], int n, int brr[], int m){
		int temp[] = new int[n + m];
		int ai = 0, bi = 0, ti = 0;		// ai = aIndex, bi = bIndex, ti = tempIndex;
		while(ai < n && bi < m) {
			if(arr[ai] <= brr[bi])
				temp[ti++] = arr[ai++];
			else
				temp[ti++] = brr[bi++];
		}
		while(ai < n)
			temp[ti++] = arr[ai++];
		while(bi < m)
			temp[ti++] = brr[bi++];
		if(temp.length % 2 == 0)
			return (float) (temp[temp.length/2-1] + temp[temp.length/2]) / 2;
		else
			return temp[temp.length/2];
    }

}
