public class DataType {

	public static void main(String[] args) {

		Object o = 1;
		System.out.println(o.getClass().getSimpleName());			//	find data type of object in java
		System.out.println(((Object)5.7F).getClass().getName());	//	find data type of a value in java

		String s = "" + 100;				//  converts int to string
		int i = Integer.parseInt("7");		//	convert a number represented as a string into an integer type

	    
	   
	}

}
