package singly.linked.list;

public class EmployeeSinglyLinkedList {

	private EmployeeNode head;
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);		
		if(head != null)
			node.setNext(head);
		head = node;
	}
	
	public static void main(String[] args) {
		Employee vishaliSetia = new Employee("Vishali","Setia",123);
		EmployeeSinglyLinkedList sl = new EmployeeSinglyLinkedList();
		sl.addToFront(vishaliSetia);
	}
	
}
