package recursion;

public class Tutorial2 {

	// 1. given a rope of length n, you need to find maximum no. of pieces you can make such that length of every piece is in set {a,b,c} for given three values a,b and c.
	static int maxCuts(int n, int a, int b,int c) {
		if(n == 0)		return 0;
		if(n < 0)		return -1;	// means not possible to cut
		int res =  Math.max( Math.max(maxCuts(n-a,a,b,c), maxCuts(n-b,a,b,c)), maxCuts(n-c,a,b,c) );
		if(res == -1)	return -1;
		return res+1;		
	}
	
	// 3. Tower Of Hanoi problem, towerOfHanoi(4,'A','B','C');
	static void towerOfHanoi(int n, char A, char B, char C) {	// from A to C using B
		if(n==1) {
			System.out.println("Move 1 from "+A+" to "+C);
			return;
		}
		towerOfHanoi(n-1,A,C,B);	// from A to B using C
		System.out.println("Move "+n+" from "+A+" to "+C);
		towerOfHanoi(n-1,B,A,C);	// from B to C using A
	}
	
	public static void main(String args) {
		towerOfHanoi(3,'A','B','C');
	}
	
}

