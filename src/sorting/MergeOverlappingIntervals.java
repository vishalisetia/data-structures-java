package sorting;
import java.util.Arrays;
import java.util.Comparator;
public class MergeOverlappingIntervals {
	
// given a set of intervals, merge overlapping intervals and prints the result, time = O(nlogn)
    public static void mergeIntervals(Interval arr[]) {
   		Arrays.sort(arr, new Comparator<Interval>() {	// sorting interval objects in ascending order of starting indexes of intervals
   			public int compare(Interval a, Interval b) {
   				return(a.start - b.start);
   			}
   		});
   		int res = 0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i].start >= arr[res].start && arr[i].start <= arr[res].end) {	// merge arr[res] and arr[i] intervals if they overlap
				arr[res].start = Math.min(arr[res].start, arr[i].start);
				arr[res].end = Math.max(arr[res].end, arr[i].end);
			}
			else {
				arr[++res] = arr[i];
			}
		}
		for(int i=0; i<=res; i++) {
			System.out.print("{" + arr[i].start + "," + arr[i].end + "}, ");
		}
    }
	
	public static void main(String[] args) {
        Interval arr[]=new Interval[5]; 
        arr[0] = new Interval(10,15); 
        arr[1] = new Interval(6,10); 
        arr[2] = new Interval(4,5); 
        arr[3] = new Interval(1,3);
        arr[4] = new Interval(2,4);
        mergeIntervals(arr);
	}
}
