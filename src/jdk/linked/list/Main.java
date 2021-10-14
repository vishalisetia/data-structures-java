package jdk.linked.list;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Employee vishaliSetia = new Employee("Vishali","Setia",123);
		Employee ullasSetia = new Employee("Ullas","Setia",456);
		Employee ajayKhanna = new Employee("Ajay","Khanna",789);
		Employee anjuRani = new Employee("Anju","Rani",012);
		Employee leenaSadana = new Employee("Leena","Sadana",345);
		
		LinkedList<Employee> list = new LinkedList<>();
		list.addFirst(vishaliSetia);
		list.addLast(ullasSetia);
//		list.removeFirst();
//		list.removeLast();
		
		Iterator i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
//		for(Employee employee: list) {
//			System.out.println(employee);
//		}

	}

}
