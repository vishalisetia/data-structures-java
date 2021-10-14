package sorting;

import java.util.Arrays;

public class PointMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Point arr[] = {new Point(10,20), new Point(3,12), new Point(5,7)};	// array of Points
		Arrays.sort(arr, new PointSort());	// sorting arr according to PointSort object
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("(" + arr[i].x + "," + arr[i].y + "), ");
		}

	}

}
