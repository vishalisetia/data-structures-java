package singly.linked.list;

public class EmployeeNode {
	
	private Employee employee;
	private EmployeeNode next;	//link to next node
	
	EmployeeNode(Employee employee) {
		this.setEmployee(employee);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeNode getNext() {
		return next;
	}

	public void setNext(EmployeeNode next) {
		this.next = next;
	}
	
// Whenever we try to print the Object reference then internally toString() method is invoked. it is used to to get string representation of an object
	@Override
	public String toString() {
		return employee.toString();
	}
}