package matrix;

public class Main {
	
	
	public static void main(String[] args) {
		
		Introduction in = new Introduction();
		Problems p = new Problems();
		int[][] arr = { {0, 0, 0}, 
				{0, 0, 1}};
		in.print(arr);
		System.out.println();
		p.booleanMatrix(2, 3, arr);
		
		
	}
}
