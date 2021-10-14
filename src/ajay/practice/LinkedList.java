package ajay.practice;

public class LinkedList {
	private Node head;
	private int size;

	public void addToFront(String string) {
		Node node = new Node(string);
		node.setNext(head);
		head=node;
		System.out.println(string+" is added to list at beginning");
		size++;
	}
	public void addAtPosition(int positionValue,String string) {
		Node node = new Node(string);
		Node current = head;
		int position=1;
		while(current.getNext()!=null && position < positionValue-1) {
			current = current.getNext();
			position++;
		}
		Node a = current.getNext();
		current.setNext(node);
		node.setNext(a);
		System.out.println("["+string+"] is added to list "+"at "+positionValue);
		size++;
	}
	public void addToEnd(String string) {
		Node node = new Node(string);
		Node current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(node);
		System.out.println(string+" is added to list at end");
		size++;
	}
	public void removeFromFront() {
		if(head==null)
			System.out.println("List is already Empty");
		else {Node current = head;
		head = head.getNext();
		System.out.println("["+current+"] is removed from beginning of the list");
		size--;}
	}
	public void printList() {
		Node current = head;
		System.out.print("Your list is :- {");
		while(current != null) {
			System.out.print(current);
			System.out.print(", ");
			current = current.getNext();
		}
		System.out.print("}");
	}
	public void reverseList() {
		Node prev = null;
		Node next = null;
		Node current = head;
		while(current!=null) {
			next=current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
		}
		head=prev;
	}
}
