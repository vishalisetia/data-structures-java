package ajay.practice;
import java.util.Scanner;
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int repeat=0;
		do {
		System.out.println("Enter 1 for insertion\nEnter 2 for deletion\nEnter 3 for iteration\nEnter 4 to reverse linked list");
		Scanner input = new Scanner(System.in);
		int optionValue = input.nextInt();
		switch(optionValue) {
		case 1:
			System.out.println("Enter string to insert :- ");
			String stringValue = input.next();
			System.out.println("Enter 1 to insert at begining\nEnter 2 to insert at particular node\nEnter 3 to insert at end");
			int option2Value = input.nextInt();
			switch(option2Value) {
			case 1: 
				list.addToFront(stringValue);
				break;
			case 2:
				System.out.println("Enter position at which you want to insert node");
				int positionValue = input.nextInt();
				list.addAtPosition(positionValue,stringValue);
				break;
			case 3:
				list.addToEnd(stringValue);
				break;
			}
			break;
		case 2:
			list.removeFromFront();
			break;
		case 3:
			list.printList();
			break;
		case 4:
			list.reverseList();
			list.printList();
			break;
		default :
			System.out.println("Please enter valid input");
			break;
		}
		System.out.println("\nEnter 1 if you want to operate again\nor\nEnter 2 if u want to stop");
		repeat = input.nextInt();
		}
		while(repeat==1);
	}
}