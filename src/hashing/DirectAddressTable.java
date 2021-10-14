package hashing;

public class DirectAddressTable {
	
//	we have 1000 keys with values from 1000 to 1999
	int start = 1000, end = 1999;
	int size = end - start + 1;
	int arr[] = new int[size];

//	time = O(1)
	void insert(int i) {
		arr[i - 1000] = 1;
	}
	
//	time = O(1)
	void delete(int i) {
		arr[i - 1000] = 0;
	}
	
//	time = O(1)
	int search(int i) {
		return arr[i - 1000];
	}

}
