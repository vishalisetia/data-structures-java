package recursion;

public class without_static {
	
	void fun1() {
		System.out.println("fun1");
	}
	
	void fun2() {
		System.out.println("Before fun1");
		fun1();
		System.out.println("After fun1");
	}
	
	public static void main(String []args) {
		static_keyword s = new static_keyword();
		System.out.println("Before fun2");
		s.fun2();
		System.out.println("After fun2");
	}

}
