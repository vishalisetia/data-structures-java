package jdk.linked.list;

public class Employee {
	private String firstName;
	private String lastName;
	private int id;
	
	public Employee(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public String toString() {
		return "Employee{"+"firstName="+firstName+
		",lastName="+lastName+
		",id="+id+"}";
	}
}
