package sorting;

public class SelectionSort {

	public static void selectionSort(int[] intArray) {
		for(int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex>0; lastUnsortedIndex--)  {
				int largest = 0;
				for (int i=1; i<= lastUnsortedIndex; i++) {
					if(intArray[i]>intArray[largest]) {
						largest=i;
					}
				}
				swap(intArray,largest,lastUnsortedIndex);
			}
		}
		public static void swap(int[] array, int i, int j) {
			if(i==j) {
				return;
			}
			else {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	
}
