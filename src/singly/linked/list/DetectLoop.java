package singly.linked.list;

public class DetectLoop {

	static VisitedNode head;
	
//	modify structure of linked list node
//	time = O(n)
	static boolean findLoop2() {
		VisitedNode current = head;
		while(current != null) {
			current.visited = true;
			if(current.next.visited == true) {
				return true;
			}
		}
		return false;
	}
	


}
