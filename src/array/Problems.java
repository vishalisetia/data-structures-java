package array;


public class Problems {
	
    public static void convertToWave(int arr[], int n){
    	if(n%2 == 0)
            for(int i=0; i<=n-1; i=i+2) {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
            	
    	else
            for(int i=0; i<=n-2; i=i+2) {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
    }
    
    // rearrange the array with, arr[i] = arr[arr[i]]
    static void arrange(int arr[], int n)	{
       for(int i=0;i<n;i++)   {
            arr[i] += ( arr[arr[i]] % n ) * n;
       }
       for(int i=0; i<n; i++) {
       	arr[i] /= n;
       }
    }
    
    public static void rearrange(int arr[], int n){
        
        // Your code here
        for(int i=0;i<n/2;i++)   {
            arr[i] += ( arr[arr[n-1-i]] % n ) * n;
       }
       for(int i=0; i<n; i++) {
       	arr[i] /= n;
       }
        
    }
    
//	{1,5,3,1,2,8,7}
	void stockBuySell(int price[], int n) {

			int i=0;
			int[] temp = new int[n];
			int j = 0;
			temp[j++] = price[0];
			while (price[i+1] > price[i]) {
				i++;
			}
			temp[j++] = price[i];
	}
	

    


}
