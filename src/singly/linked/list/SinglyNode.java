package singly.linked.list;

// classes which have same type of instance variable, are called self-referential structures
class SinglyNode {

	int data;
	SinglyNode next;
	
	SinglyNode(int data) {
		this.data = data;
		this.next = null;
	}
	// if next is null, node.setnext(null) and node.getNext() is wrong, null pointer exception

}
