package functions;

import java.math.BigInteger;

public class Power {

// 	find value of x raised to power p
    static int power(int x,int p) {
        int a = x;
        return powerTemp(x, a, p);
    }
    static int powerTemp(int n, int a, int p) {
    	if(p == 0)
            return 1;
        if(p == 1)
            return n;
        return powerTemp(n*a, a,  p-1);
    }
    
// 	power of numbers - Given a number N, let the reverse of the number be R. The task is to print the output of the Expression power(N,R). As answers can be very large, print the result modulo 10(power 9) + 7.
// 	System.out.println(power(new BigInteger("12"),21));
	static BigInteger power(BigInteger a,int b) {
    	BigInteger X = a;
    	BigInteger ans = powerTemp(a, X, b);
    	return ans.mod(new BigInteger("1000000007"));
    }
    static BigInteger powerTemp(BigInteger a, BigInteger X, int b) {
        if(b == 1)
            return a;
        return powerTemp(a.multiply(X), X,  b-1);
    }

}
