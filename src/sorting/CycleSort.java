package sorting;

public class CycleSort {

	int cycleSort(int arr[], int n) {
		int swapCount = 0;
		for(int cs = 0; cs < n-1; cs++) {	// cs is index of element from where cycle starts
			int item = arr[cs];
			int pos = cs;
			for(int i = cs+1; i<n; i++) {
				if(arr[i] < item) {
					pos++;
				}
			}
			int temp = item;		// swap item and arr[pos] 
			item = arr[pos];
			arr[pos] = temp;
			swapCount++;
 			
			while(pos != cs) {
				pos = cs;
				for(int i = cs+1; i<n; i++) {
					if(arr[i] < item)
						pos++;
				}
				temp = item;		// swap item and arr[pos] 
				item = arr[pos];
				arr[pos] = temp;
			}
		}
		return swapCount;
	}
	
//	write fxn when distinct elements are present
	
//	count min no. of swaps required

}
