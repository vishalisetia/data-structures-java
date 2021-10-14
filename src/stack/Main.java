package stack;


public class Main {

	public static void main(String[] args) {

		Employee vishaliSetia = new Employee("Vishali","Setia",123);
		Employee ullasSetia = new Employee("Ullas","Setia",456);
		Employee ajayKhanna = new Employee("Ajay","Khanna",789);
		Employee anjuRani = new Employee("Anju","Rani",012);
		Employee leenaSadana = new Employee("Leena","Sadana",345);

//        ArrayStack arrayStack = new ArrayStack(10);
//        arrayStack.push(vishaliSetia);
//        arrayStack.push(ullasSetia);
//        arrayStack.push(ajayKhanna);
//        arrayStack.push(anjuRani);
//        arrayStack.printStack();
        
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(vishaliSetia);
        linkedStack.push(ullasSetia);
        linkedStack.push(ajayKhanna);
        linkedStack.push(anjuRani);
        linkedStack.printStack();
        System.out.println();
        System.out.println(linkedStack.pop());
        System.out.println();
        linkedStack.printStack();
	}
}
