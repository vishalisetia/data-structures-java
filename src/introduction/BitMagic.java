package introduction;

public class BitMagic {

	// check if k-th bit is set
	String kBit(int n, int k) {
		if ((n & (1 << (k-1))) != 0)
			return "Yes";
		else
			return "No";
	}
	String kBit2(int n, int k) {
		if (((n >> (k-1)) & 1) == 1)
			return "Yes";
		else
			return "No";
	}
	
	// count set bits in non -ve integer = theta(total bits in n)
	int countSet(int n) {
		int count = 0;
		if((n & 1) == 1)	// if((n%2) != 0)
			count++;
		n = n >> 1;			// n = n/2;
		return count;
	}
	
	// Brion Kerningam's algorithm = one by one turning off the last set bit = theta(set bit count)
	int countSet2(int n) {
		int count = 0;
		while(n > 0) {
			n = (n & (n-1)); // unset rightmost set bit
			count++;
		}
		return count;
	}
	
	// theta(set bit count)
	boolean isPow2(int n) {
		int count = 0;
		while(n > 0) {
			n = (n & (n-1));
			count++;
		}
		if (count==1)
			return true;
		return false;
	}
	
	// theta(1)
	boolean isPow22(int n) {
		if(n==0)
			return false;
		if(((n&(n-1))==0))
			return true;
		else
			return false;
	}
	
	// takes an array of integers and displays the number that has odd occurrences in the array.
	

}
