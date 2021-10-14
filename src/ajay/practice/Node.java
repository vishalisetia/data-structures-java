package ajay.practice;

public class Node {
	
	private String string;
	private Node next;
	
	Node(String string) {
		this.setString(string);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return string.toString();
	}
}
