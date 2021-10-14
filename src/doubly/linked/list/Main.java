package doubly.linked.list;

public class Main {

	public static void main(String[] args) {
		
		DoublyLinkedList dl = new DoublyLinkedList();
		DoublyNode head = null;
		head = new DoublyNode(1);
		dl.insertEnd(head, 2);
		dl.insertEnd(head, 3);
		dl.insertEnd(head, 4);
		dl.printList(head);
		
	}
}