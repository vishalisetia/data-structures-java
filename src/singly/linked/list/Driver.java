package singly.linked.list;

public class Driver {
	

	public static void main(String[] args) {
		
		SinglyLinkedList s = new SinglyLinkedList();
		s.insertEnd(s.head, 1);
		s.insertEnd(s.head, 2);
		s.insertEnd(s.head, 3);
		s.insertEnd(s.head, 4);
		s.printList(s.head);
		System.out.println();
		
	}
}