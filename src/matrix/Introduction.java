package matrix;

//	matrix means an array of arrays (or array of references of array objects) means every 2D array has 1D array objects as rows. 
//	we dont need to pass dimensions in java as arr.length represents no. of rows in arr and arr[i].length represents no. of values in that row ie., columns in that row of arr. 
public class Introduction {
	
//  passing 2D array as argument
//	print(new int[2][3]);
//  int[][] arr = { {1,2,3,4}, {5,6}, {7,8,9} };
//	i.print(arr);
	void print(int[][] arr) {
		for(int i=0; i<arr.length; i++) {	
			for(int j=0; j<arr[i].length; j++) {	
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
//  jagged array - 2D array where all the rows are of different sizes - jagged(new int[3][]);
	void jagged(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = new int[i+1];
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = i+1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
//	print matrix in snake pattern - theta(no. of rows * no. of columns)
//  first row should be printed from left to right, second row from right to left, and so on...
//	int[][] arr = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };
//	i.snake(arr);
	void snake(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			if(i%2 == 0) {
				for(int j=0; j<arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			else {
				for(int j=arr[i].length-1; j>=0; j--) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

//	transpose of a square matrix
//	1st row becomes 1st column, 2nd row becomes 2nd column and so on...
	void transpose(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				// swap a[i][j] and a[j][i]
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
	
//	rotate the matrix by 90 degree counter-clockwise
	
//	last column becomes 1st row, 2nd last column becomes 2nd row, so on...
	void rotate(int[][] arr) {
		
	    int[][] temp = {};
	    
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
	//			temp[i][j] = arr[j][arr.length-1-i];
				temp[arr.length-1-j][i] = arr[i][j];
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++)	{
				arr[i][j] = temp[i][j];
			}
		}
	}
	
//	1st row becomes 1st column in reverse direction, 2nd row becomes 2nd column in reverse direction and so on... so first transpose then swap 1st and last row, 2nd and 2nd last row, so on...
	void rotate2(int[][] arr) {
		
		transpose(arr);
		
		for(int i=0; i<arr.length/2; i++) {
			for(int j=0; j<arr.length; j++)	{
				// swap arr[i][j] and arr[arr.length-1-i][j]
				int temp = arr[i][j];
				arr[i][j] = arr[arr.length-1-i][j];
				arr[arr.length-1-i][j] = temp;
			}
		}
	}
	
//	boundary traversal problem - O(c+r+c+r) = O(c+r)
//	first row left to right, last column top to bottom, last row right to left and first column bottom to top
	void boundary(int[][] arr) {
		
		int topRow = 0, rightColumn = arr[0].length-1, bottomRow = arr.length-1, leftColumn = 0;
		
		for(int i=leftColumn; i<=rightColumn; i++) {	// print top row
			System.out.print(arr[topRow][i] + " ");
		} topRow++;
		for(int i=topRow; i<=bottomRow; i++) {	//	print right column
			System.out.print(arr[i][rightColumn] + " ");
		} rightColumn--;
		if(topRow <= bottomRow) {
			for(int i=rightColumn; i>=leftColumn; i--) {	// print bottom row
				System.out.print(arr[bottomRow][i] + " ");
			} bottomRow--;
		}
		if(leftColumn <= rightColumn) {
			for(int i=bottomRow; i>=topRow; i--) {	//	print left column
				System.out.print(arr[i][leftColumn] + " ");
			} leftColumn++;
		}
	}
	
	// just add while loop to boundary fxn
	// we are printing every cell of matrix exactly once, so time complexity = theta(r*c)
	void spiral(int[][] arr) {
		
		int topRow = 0, rightColumn = arr[0].length-1, bottomRow = arr.length-1, leftColumn = 0;

		while(topRow <= bottomRow && leftColumn <= rightColumn) {
			
			for(int i=leftColumn; i<=rightColumn; i++) {	// print top row
				System.out.print(arr[topRow][i] + " ");
			} topRow++;
			for(int i=topRow; i<=bottomRow; i++) {	//	print right column
				System.out.print(arr[i][rightColumn] + " ");
			} rightColumn--;
			if(topRow <= bottomRow) {
				for(int i=rightColumn; i>=leftColumn; i--) {	// print bottom row
					System.out.print(arr[bottomRow][i] + " ");
				} bottomRow--;
			}
			if(leftColumn <= rightColumn) {
				for(int i=bottomRow; i>=topRow; i--) {	//	print left column
					System.out.print(arr[i][leftColumn] + " ");
				} leftColumn++;
			}
		}
	}
	
//	search an element x in a row-wise and column-wise sorted matrix
//	begin from the top right corner, if x is same, print position and return. if x is smaller move left, if x is greater move down.
	void search(int[][] arr, int x) {
		int i = 0, j = arr[0].length-1;
		searchPart(arr, x, i, j);
	}
	
// O(r+c) --> linear
	void searchPart(int[][] arr, int x, int i, int j) {
		int firstElement = arr[0][0];
		int lastElement = arr[arr.length-1][arr[arr.length-1].length-1];
		if(i == arr.length || j == -1 || x < firstElement || x > lastElement) {
			System.out.println("Not found");
			return;
		}
		int temp = arr[i][j];
		if(x == temp)
			System.out.println("temp is at arr[" + i + "," + j + "] position");
		else if(x < temp)
			searchPart(arr, x, i, j-1);
		else
			searchPart(arr, x, i+1, j);
	}
	

}
