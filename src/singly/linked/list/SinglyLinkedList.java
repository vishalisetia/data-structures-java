package singly.linked.list;

import java.util.ArrayList;

//	this class is for whole linkedList containing multiple nodes connected to each other, always first find the node just previous to it and then update its next pointer.
public class SinglyLinkedList {

	
public SinglyNode head;

	//	traverse the list using a temporary reference and print the element at each point.
	void printList(SinglyNode head) {
		SinglyNode current = head;
		while(current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}
	
	public boolean isEmpty(SinglyNode head) {
		return head == null;
	}
	
//  O(1)
	void insertFront(SinglyNode head, int data) {
		SinglyNode node  = new SinglyNode(data);	//creating a new node and inserting data into it
		if(head == null) {
			this.head = node; 
			return;
		}
		node.next = head;
		head = node;
	}
	
//  O(n) where n is the number of nodes in the Linked List
	public void insertEnd(SinglyNode head, int data) {
		SinglyNode node = new SinglyNode(data);
		if(head == null) {
			this.head = node; 
			return;
		}
		SinglyNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = node;
	}
	
//  Inserting a SinglyNode after given SinglyNode, time = O(1)
	public void insertAfter(SinglyNode prev_node, int new_data) {
		if(prev_node == null) {
			System.out.println("given previous node cannot be null");
			return;
		}
		SinglyNode new_node = new SinglyNode(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	
    SinglyNode insertNodeAtPosition(SinglyNode head, int data, int position) {
        SinglyNode node = new SinglyNode(data);
        if(position == 0) {
            node.next = head;
            head = node;
            return head;
        }
        SinglyNode cur = head;
        int pos = 0;
        while(cur.next != null) {
            if(pos == position - 1) {
                node.next = cur.next;
                cur.next = node;
                return head;
            }
            cur = cur.next;
            pos++;
        }
        return head;
    }
	
//	Deleting the first occurrence of a given Data Value
//	time = O(n)
	public void deleteNode(SinglyNode head, int data) {
		if(head.data == data) {
			head = head.next;
			return;
		}
		SinglyNode prev_node = head;
		while(prev_node.next != null && prev_node.next.data != data) {
			prev_node = prev_node.next;
		}
		if(prev_node.next != null) {
			SinglyNode delete_node = prev_node.next;
			prev_node.next = delete_node.next;
		}
	}
	
//	Deleting a node at a given position
//	time = O(n)
	void deleteAtPosition(SinglyNode head, int position) {
		if(position < 0) {
			return;
		}
		if(position == 0) {
			head = head.next;
			return;
		}
		SinglyNode prev_node = head;
		int prev_node_pos = 0;
		while(prev_node != null) {
			if(prev_node_pos == position-1) {
				SinglyNode del_node = prev_node.next;
				prev_node.next = del_node.next;
			}
			prev_node = prev_node.next;
			prev_node_pos++;
		}
	}
	
//  delete the given node in O(1) time if the head node is not given - copy next node data to given node and delete next node, this approach is not possible for last node to delete.
//	time = O(1)
	void deleteWithoutHead(SinglyNode prev) {
		if (prev.next == null)
			return;
		prev.data = prev.next.data;
		prev.next = prev.next.next;
	}

//	find middle node element, first traverse and find how many nodes are there in list, then traverse half of list and print middle element
//	time = O(2n)
	void printMiddle(SinglyNode head) {
		if(head == null)
			return;
		int count = 0;
		SinglyNode current;
		for(current = head; current != null; current = current.next) {
			count++;
		}
		current = head;
		for(int i=1; i<=count/2; i++) {
			current = current.next;
		}
		System.out.println(current.data);
	}
	
//	efficient - maintain 2 references slow and fast, slow moves one node at a time and fast moves 2 nodes at a time, when fast reaches null or fast next reaches null, slow will be at middle.
//	time = O(n)
	void printMiddle2(SinglyNode head) {
		if(head == null)
			return;
		SinglyNode slow = head;
		SinglyNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);
	}
	
	public int search(SinglyNode head, int data) {
		if(head == null)
			return 0;
		if(head.data == data)
			return 1;
		int position = 2;
		SinglyNode current = head;
		while(current.next != null && current.next.data != data) {
			current = current.next;
			position++;
		}
		if(current.next != null)
			return position++;
		return 0;
	}
	
//	find n-th node from end of the linked list - first find the length of linked list, then traverse linked list and find (length-n+1) node.
	void nEnd(SinglyNode head, int n) {
		int length = 0;
		SinglyNode current;
		for(current = head; current != null; current = current.next) {
			length++;
		}
		if(n > length)
			return;
		current = head;
		for(int i=1; i<length-n+1; i++) {
			current = current.next;
		}
		System.out.println(current.data);
	}
	
//	efficient - move 'first' pointer n positions ahead, start 'second' pointer from head, move both 'first' and 'second' at same speed, when first reaches null, second reaches the required node
	void nEnd2(SinglyNode head, int n) {
		SinglyNode first = head;
		for(int i=1; i<=n; i++) {
			first = first.next;
		}
		SinglyNode second = head;
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		if(first == null)
			System.out.println(second.data);
	}
	
//	print linkedlist in reverse order without actual modifying linkedlist
	void reverse(SinglyNode head) {
		if(head == null)
			return;
		reverse(head.next);
		System.out.print(head.data + " -> ");
	}
	
	
//	reverse the linked list - copy linked list elements to array list, then remove elements from array list in reverse direction and copy to linked list
//  time = theta(2n), space = theta(n)
	void reverse2(SinglyNode head) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(SinglyNode current = head; current != null; current = current.next) {
			arr.add(current.data);
		}
		for(SinglyNode current = head; current != null; current = current.next) {
			current.data = arr.remove(arr.size()-1);
		}
	}
	
//	efficient - reverse the links rather than data
//	time = theta(n), space = theta(1)
	void reverse3(SinglyNode head) {
		SinglyNode prev = null;
		SinglyNode current = head;
		SinglyNode next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		if(current == null)
			head = prev;
	}
	
//	make loop by connecting last node with given node
	boolean makeLoop(SinglyNode head, int data) {
		SinglyNode cur = head; SinglyNode link = head;
		while(cur != null && cur.data != data) {
			cur = cur.next;
		}
		if(cur != null && cur.data == data) {
			link = cur;
		}
		if(cur == null) {
			return false;
		}
		cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = link;
		return true;
	}
	
//  check whether a linked list contains any loop or not, time = O(n*n)
	boolean findLoop(SinglyNode head) {
		SinglyNode i = head.next;
		while(i != null) {
			SinglyNode j = head;
			while(i.data != j.data) {
				if(i.next.data == j.data)
					return true;
				j = j.next;
			}
			i = i.next;
		}
		return false;
	}
	
//	modify references in the linked list
	boolean findLoop3(SinglyNode head) {
    	SinglyNode current = head;
    	while(current != null) {
    		if(current.next == null) {
    			return true;
    		}
    		SinglyNode i = current;
    		current = current.next;
    		i.next = null;
    	}
    	return false;
    	
    }
	
//  segregate even and odd nodes of a linked list - find tail of linked list, then traverse linked list from head to tail, delete even elements from left and put at the end.
//	O(2n)
	void segregate(SinglyNode head) {
		
		// find tail
		SinglyNode current = head, tail = head;
		while(current.next != null) {
			current = current.next;
		}
		if(current.next == null)
			tail = current;
		
		// shift even nodes to right of tail
		SinglyNode left = head, right = tail;
		while(left != tail) { 
			if(left.next.data % 2 == 0) {
				right.next = new SinglyNode(left.next.data);
				right = right.next;
				if(left.next == tail) {
					left.next = left.next.next;
					return;
				}
				else
					left.next = left.next.next;
			}
			else
				left = left.next;
		}
	}
	
//	while traversing we keep connecting odd nodes together, whenever we see an odd node we insert it between the odd and odd.next 
	void segregate2(SinglyNode head) {
		SinglyNode current = head, odd = head;
		if(head.data % 2 != 0) {
			current = current.next;
		}
		while(current.next != null) {
			if(current.next.data % 2 != 0) {
				if(head.data % 2 == 0) {
					SinglyNode node = new SinglyNode(current.next.data);
					current.next = current.next.next;
					node.next = head;
					head = node;
					odd = head;
				}
				SinglyNode node = new SinglyNode(current.next.data);
				current.next = current.next.next;
				node.next = odd.next;
				odd.next = node;
				odd = odd.next;
			}
			else
				current = current.next;
		}
	}
	
//	pairwise swap nodes of a linked list
//	time = O(n), swap pair data, not efficient when we have large data in nodes
	void pairwise(SinglyNode head) {
		SinglyNode current = head;
		while(current != null && current.next != null) {
			
			// swap(current.data, current.next.data);
			int temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
			
			current = current.next.next;
		}
	}
	
//	time = O(n), efficient - swap references
	void pairwise2(SinglyNode head) {
		if(head == null || head.next == null)
			return;
		
		SinglyNode a = head, b = a.next, c = b.next;	// swap 1st and 2nd node
		a.next = c;
		b.next = a;
		head = b;
		
		a = head.next; 	// swap 3rd and 4th node...so on
        b = a.next;
        if(b == null)
        	return;
    	c = b.next;
    	if(c == null)
    		return;
		SinglyNode d = c.next;
		while(c != null) {
			a.next = c;
			c.next = b;
			b.next = d;
			if( a.next == null || b == null || c.next.next == null || d.next == null)
				return;
			a = a.next.next;
			b = b.next;
			c = c.next.next.next;
			d = d.next.next;
		}
	}
	
//	merge 2 sorted linked list into 1 sorted linked list where h1 and h2 are given heads of 1st and 2nd list respectively.
//	time = O(length of 1st linked list + length of 2nd linked list), not theta bcz if one list is empty we will simply return head of other list and time will be theta(1).
//	space = O(1) unlike when merging two arrays
	SinglyNode merge(SinglyNode h1, SinglyNode h2) {
		if(h1 == null)
			return h2;
		if(h2 == null)
			return h1;
		SinglyNode head = null, current = null;
		if(h1.data <= h2.data) {
			head = current = h1;
			h1 = h1.next;
		}
		else {
			head = current = h2;
			h2 = h2.next;
		}
		while(h1 != null && h2 != null) {
			if(h1.data <= h2.data) {
				current.next = h1;
				current = current.next;
				h1 = h1.next;
			}
			else {
				current.next = h2;
				current = current.next;
				h2 = h2.next;
			}
		}
		if (h1 == null)
			current.next = h2;
		if (h2 == null)
			current.next = h1;
		return head;
	}

    boolean isPalindrome(SinglyNode head)	{
    	SinglyNode current = head; int size = 0;
    	while(current != null) {
    		current = current.next;
    		size++;
    	}
    	current = head; int count = 0;
    	while(count <= size/2) {
    		
    	}
    	return false;
    }
	
}
