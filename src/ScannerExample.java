import java.util.Scanner;

public class ScannerExample { 
	    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(scan);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = scan.nextInt();
		
		

		scan.next(); // returns the next token of input
		scan.hasNext(); // returns true if there is another token of input (false otherwise)
		scan.nextLine(); // reads from the end of the last token until the beginning of the next line
		scan.hasNextLine(); // returns true if there is another line of input

	}
 
}  