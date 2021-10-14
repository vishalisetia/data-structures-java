package queue;

public class ArrayQueue {
	
	private Employee[] queue;
	private int front=-1;
	private int back=-1;
	
	public ArrayQueue(int capacity) {
		queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {	// always add at the end of queue
		if(front == -1)
			front = 0;
		if(back==queue.length-1) {
			// need to resize the backing array
			Employee[] newArray = new Employee[2*queue.length];
			System.arraycopy(queue, 0, newArray, 0, queue.length);
			queue = newArray;
		}
		queue[++back] = employee;	
	}
//	public Employee remove() { // always remove first item of queue
//		if(back-front == 0) {
//			throw new NoSuchElementException();
//		Employee frontElement = queue[front];
//		queue[front++]=null;
//		return frontElement;
//	}
}
