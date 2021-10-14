package matrix;

public class Problems {
	
    void multiplyMatrix(int n1, int m1, int n2, int m2, int arr1[][], int arr2[][]) {
    	if(m1 != n2) {
    		System.out.print("-1");
    		return;
    	}
    	
    	int c[][]=new int[n1][m2];
    	for(int i=0;i<n1;i++) {    
    		for(int j=0;j<m2;j++) {    
    			c[i][j]=0;      
    			for(int k=0;k<m1;k++) {      
    				c[i][j] += arr1[i][k] * arr2[k][j];      
    			} 
    			System.out.print(c[i][j]+" ");
    		}
    		System.out.println();  
    	}    
    }
    
    void reverseCol(int n1, int m1, int arr1[][])
    {
       //Your code here
    	for(int i=0; i<n1/2; i++) {
    		for(int j=0; j<m1; j++) {
	    		int temp = arr1[i][j];
	    		arr1[i][j] = arr1[n1-1-i][j];
	    		arr1[n1-1-i][j] = temp;
    		}
    	}
    }
    
    static void booleanMatrix(int r, int c, int mat[][])
    {
        //Your code here
        int[] row = new int[r];
        int[] column = new int[c];
        
        for(int i=0; i<r; i++) {
        	for(int j=0; j<c; j++) {
        		if (mat[i][j] == 1) {
        			row[i] = 1;
        			column[j] = 1;
        		}
        	}
        }
        for(int i=0; i<r; i++) {
        	for(int j=0; j<c; j++) {
        		if(row[i]==1 || column[j]==1) {
        			mat[i][j] = 1;
        		}
        	}
        }
		for(int i=0; i<r; i++) {	
			for(int j=0; j<c; j++) {	
				System.out.print(mat[i][j] + " ");
			}System.out.println();
		}
        
    }

}
