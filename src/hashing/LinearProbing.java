package hashing;

import java.util.Arrays;

public class LinearProbing {
	Integer arr[];	// don't use primitive data type in hashing
	int capacity;
	int size;
	Integer deleted = new Integer(-1);
	
	LinearProbing(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		arr = new Integer [capacity];
		for(int i=0; i<capacity; i++)
			arr[i] = null;
	}
	
	void print() {
		System.out.println(Arrays.toString(arr));
	}
	
	int hash(int key) {
		return key % capacity;
	}
	
	int size() {
		return size;
	}
	
//	linear probing insert :- compute hash fxn to find index, then go to that index and compare, if index slot is null then insert there and return index, else linearly search circularly for next empty slot when there is a collision.
	boolean insert(int key) {
		int i = hash(Math.abs(key));
		int j = i;
		do {
			if(arr[j] == null || arr[j] == deleted) {
				arr[j] = new Integer(key);
				size++;
				return true;
			}
			j++;					// in linear probing primary clusters will form and in quadratic probing, j = j*j;, secondary clusters will form
		} while(j%capacity != i);	// circular array traversal
		return false;
	}
	
//	linear probing search :- compute hash fxn to find index, then go to that index and compare, if we find we return index, else we linearly search. we stop searching when :-
//	1.	we find an empty slot,
//	2.	we either find the key,
//	3.	we have traversed through the whole array circularly and reached index again.
	boolean  search(int key) {
		int i = hash(Math.abs(key));
		int j = i;
		do {
			if(arr[j] == null)
				return false;
			else if(arr[j].equals(key))
				return true;
			j++;
		} while(j % capacity != i);
		return false;
	}

//	linear probing deletion :- If we simply delete a key, then search may fail, so we search and then delete element by not marking the slot empty (-1), but marking it as deleted (-1).
	boolean delete(int key) {
		int i = hash(key);
		int j = i;
		do {
			if(arr[j] == null)
				return false;
			else if(arr[j].equals(key)) {
				arr[j] = deleted;
				size--;
				return true;
			}
			j++;
		} while(j % capacity != i);		
		return false;
	}

}
