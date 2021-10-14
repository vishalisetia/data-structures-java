package singly.linked.list;

// advantage of circular linked list is insertion at front or end is same and takes O(1) time
public class CircularLinkedList {

	private SinglyNode tail;
	
	void printList() {
		SinglyNode current = tail.next;
		do {
			System.out.print(current.data + ", ");
			current = current.next;
		}
		while(current != tail.next);
	}
	
//  time = O(1)
	void insertEnd(int data) {			
		SinglyNode node = new SinglyNode(data);
		if(tail == null) {
			tail = node;
			tail.next = tail;
			return;
		}
		SinglyNode head = tail.next;
		node.next = head;
		tail.next = node;
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.insertEnd(5);
		cll.insertEnd(4);
		cll.insertEnd(3);
		cll.insertEnd(2);
		cll.insertEnd(1);
		cll.printList();
	}
	
}
