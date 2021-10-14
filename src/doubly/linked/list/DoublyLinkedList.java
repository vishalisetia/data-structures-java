package doubly.linked.list;

public class DoublyLinkedList {
    
	public void insertFront(DoublyNode head, int data) {
		DoublyNode new_node = new DoublyNode(data);
		if(head == null) {
			head = new_node;
			head.prev = null;
			head.next = null;
			return;
		}
		head.prev = new_node;
		new_node.next = head;
		new_node.prev = null;
		head = new_node;
	}
	
//	add fxn in jdk linkedList class
	public DoublyNode insertEnd(DoublyNode head, int data) {
		DoublyNode new_node = new DoublyNode(data);
		if(head == null) {
			head = new_node;
			head.prev = null;
			head.next = null;
			return head;
		}
		new_node.next = null;
		DoublyNode prev_node = head;			// traverse find previous node of the node which is to delete
		while(prev_node.next != null) {
			prev_node = prev_node.next;
		}
		prev_node.next = new_node;
		new_node.prev = prev_node;
		return head;
	}
	
	void insertAfterPosition(DoublyNode head, int pos, int data) {
		
		DoublyNode node = new DoublyNode(data);
		int index = 0;
		DoublyNode current = head;
		while(current != null && index < pos) {
		    index++;
		    current = current.next;
		}
		if(index == pos) {
	        node.next = current.next;
	        current.next = node;
	        node.prev = current;
	        if(node.next != null)
	            node.next.prev = node;
	    }
	}

//	remove fxn in jdk linkedList class
	public void removeFirst(DoublyNode head) {
		if(head == null)
			return;
		if(head.next == null) {
			head = null;
			return;
		}
		head = head.next;
		head.prev = null;
	}
	
	public void removeLast(DoublyNode head) {
		if(head == null)
			return;
		if(head.next == null) {
			head = null;
			return;
		}
		DoublyNode del_node = head;
		while(del_node.next != null) {
			del_node = del_node.next;
		}
		DoublyNode prev_node = del_node.prev;
		prev_node.next = null;
	}
	
	public void printList(DoublyNode head) {
		DoublyNode current = head;
		while(current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
	}
	
	public void reverseList(DoublyNode head) {
		DoublyNode prev = null;
		DoublyNode next = null;
		DoublyNode current = head;
		while(current!=null) {
			next=current.next;
			current.next = prev;
			prev=current;
			current=next;
		}
		head=prev;
	}
	

}
