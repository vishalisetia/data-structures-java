package hashing;

class SinglyNode {
	int data;
	SinglyNode next;
	SinglyNode(int data) {
		this.data = data;
		this.next = null;
	}
}

// Chaining implementation using singly linked list for set implementation
public class Chaining {

	int arrSize;
	SinglyNode arr[];	// Hashtable - array of Singly Nodes
	
	Chaining(int arrSize) {
		this.arrSize = arrSize;
		arr = new SinglyNode[arrSize];
	}
	
	int hashFunction(int key) {
		return key % arrSize;
	}
	
//	time = O(l) where l is length of arr[i] linked list
	void insert(int key) {
		int i = hashFunction(key);
		SinglyNode node = new SinglyNode(key);
		if(arr[i] == null) {
			arr[i] = node; 
			return;
		}
		SinglyNode current = arr[i];
		while(current.next != null) {
			current = current.next;
		}
		current.next = node;
	}
	
//	time = O(l)
	void delete(int key) {
		int i = hashFunction(key);
		if(arr[i] == null)
			return;
		if(arr[i].data == key) {
			arr[i] = arr[i].next;
			return;
		}
		SinglyNode prev_node = arr[i];
		while(prev_node.next != null && prev_node.next.data != key) {
			prev_node = prev_node.next;
		}
		if(prev_node.next != null) {
			SinglyNode delete_node = prev_node.next;
			prev_node.next = delete_node.next;
		}
	}

//	time = O(l)
	boolean search(int key) {
		int i = hashFunction(key);
		if(arr[i] == null)
			return false;
		if(arr[i].data == key)
			return true;
		SinglyNode current = arr[i];
		while(current != null && current.data != key)
			current = current.next;
		if(current != null)
			return true;
		return false;
	}
	
	void print() {
		for(int i=0; i<arr.length; i++) {
			System.out.print ("Bucket " + i + ":  "); 
			SinglyNode current = arr[i];
			while(current != null) {
				System.out.print(current.data + ", ");
				current = current.next;
			}
			System.out.println();
		}
	}

}
