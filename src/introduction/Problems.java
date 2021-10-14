package introduction;

public class Problems {

//  n-1 elements are given randomly in an array having values from 1 to n-1. find element which is not in the array.
//	int arr[] = {3,9,4,6,10,5,2,7,1}; System.out.println(skip(arr, 10));
	int skip(int arr[], int n) {
		int sum = 0;			// sum of n-1 elements
		int total = n*(n+1)/2;	// sum of n elements
		for(int i=0; i<n-1; i++)
			sum += arr[i];
		return total-sum;
		
	}
	
    public void quadraticRoots(int a,int b,int c)
    {
        //Your code here
        int d = b*b - 4*a*c;
        double x = (-b+Math.sqrt(d))/(2.0*a);
        double y = (-b-Math.sqrt(d))/(2.0*a);
        if (d<0)
            System.out.print("Imaginary");
        else {
            if(x>=y)
                System.out.print((int)Math.floor(x)+" "+(int)Math.floor(y));
            else
                System.out.print((int)Math.floor(y)+" "+(int)Math.floor(x));
        }
    }
    


	public double termOfGP(int A,int B,int N)  {
        double r = (double)B / A;			// 2 ints returns an int. In order to use the double version, which returns a double, at least one of the ints must be explicitly casted to a double.
    	return  Math.floor(A * Math.pow(r,N-1));
    }
	
    public boolean isPrime(int N)  {
      if(N%2==0) 
    	  return false;
      else {
        for(int i=3; i <= Math.sqrt(N); i = i+2)
          if(N % i == 0) 
        	  return false;
      }
      return true;
    }
    
//  Exactly 3 Divisors - Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.
//	time = O(n*n)
    public int exactly3Divisors(int N)
    {
    	int res = 0;
    	for(int i=3; i<N; i++) {
    		int count = 2;
    		for(int j=2; j<i; j++) {
    			if(i % j == 0)
    				count++;
    		}
    		if(count == 3)
    			res++;
    	}
    	return res;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
