public class Driver {
	
	static int sum(int n) {
		int res = 0;
		for(int i=0; i<=n; i++) {
			res+=i;
		}
		return n*(n+1)/2;
	}

	public static void main(String[] args) {
		System.out.println(sum(5));

	}

}
