package stack;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
	
	private LinkedList<Employee> stack;
	
	public LinkedStack() {
		stack = new LinkedList<Employee>();
	}
	
/* wrapping the linkedList in other class so that we can limit the methods of linkedList 
 * to behave like a stack
 */
	public void push(Employee employee) {
		stack.push(employee);
	}
	public Employee pop() {
		return stack.pop();
	}
	public Employee peek() {
		return stack.peek();
	}
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	public void printStack() {
		ListIterator<Employee> iterator = stack.listIterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+", ");
		}
	}
} 