package functions;

public class SubArrayWithMaxSum {

//	O(n*n)
	int find (int[] arr, int n) {
		int res = arr[0];
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum = sum + arr[j];
				res = Math.max(sum, res);
			}
		}
		return res;
	}
	
	// O(n)
	int find2 (int[] arr, int n) {
		int res = arr[0];
		int maxEnding = arr[0];
		for(int i=1; i<n-1; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;
	}

}
