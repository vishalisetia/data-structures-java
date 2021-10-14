package stack;

public class ArrayStack {
	private Employee[] empArray;
	private int top = -1;
	
	public ArrayStack(int arraySize) {
		empArray = new Employee[arraySize];
	}
	public void push(Employee employee) {
		if(top==empArray.length-1) {
			// need to resize the backing array
			Employee[] newArray = new Employee[2*empArray.length];
			System.arraycopy(empArray, 0, newArray, 0, empArray.length);
			empArray = newArray;
		}
		empArray[++top] = employee;	
	}
	public void pop() {
		if(top==-1) {
			System.out.println("Your stack is empty so u can't pop element");
			return;
		}
		Employee topElement = empArray[top];
		empArray[top--]=null;
		System.out.println(topElement+" is popped from stack");
	}
	public void peek() {
		if(top==-1)
			System.out.println("Your stack is empty so there is no element on top");
		System.out.println("Top element of stack :- "+empArray[top]);
	}
	public void isEmpty() {
		if(top==-1)
			System.out.println("Stack is empty");
		else
			System.out.println("Stack is not empty");
	}
	public void size() {
		System.out.println("Size of the stack :- "+(top+1));
	}
	public void printStack() {
		if(top==-1) {
			System.out.println("Your stack is empty so u can't print stack");
			return;
		}
		System.out.println("Stack is :- ");
		for(int i=top;i>-1;i--)
			System.out.println(empArray[i]);
	}
}