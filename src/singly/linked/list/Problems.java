package singly.linked.list;

public class Problems {

    SinglyNode removeDuplicatesSorted(SinglyNode root) {
    	SinglyNode current = root;
    	while(current.next != null) {
		    if(current.next.data == current.data) {
		    	current.next = current.next.next;
		    }
		    else
		    	current = current.next;   	
    	}
    	return root;
    }
    
    SinglyNode swapkthnode(SinglyNode head, int num, int K) {
    	SinglyNode a = head, b = head;
    	int count = 1;
    	while(count < K-1) {
    		a = a.next.next;
    		count++;
    	}
    	count = 1;
    	while(count < num-K) {
    		b = b.next.next;
    		count++;
    	}
    	SinglyNode temp = a;
    	a = b;
    	b = temp;
    	return head;
    }

    static void addLists(SinglyNode first, SinglyNode second){
		SinglyNode prev = null;
		SinglyNode current = first;
		SinglyNode next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		if(current == null)
			first = prev;
		prev = null;
		current = second;
		next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		if(current == null)
			second = prev;
		
		SinglyNode head = new SinglyNode(0), temp = head;
		while(first != null || second != null) {
			if(temp == null)
				head.data = (first.data + second.data) % 10;
			else
				temp.next = new SinglyNode((first.data + second.data) % 10);
			first.next.data += (first.data + second.data) / 10;
			first = first.next;
			second = second.next;
			temp = temp.next;
		}
    }
    

    

}
