package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Introduction {
	
	public static void main(String[] args) {
		
		int[] arr = {13, 7, 6, 45, 21, 9, 2, 100};
		System.out.println(Arrays.toString(arr));		// print arrray
		Arrays.sort(arr);					// sorts array in increasing order
		Arrays.sort(arr,1,4);					// sort array from 1st to 3rd index in increasing order
		Integer[] arr2 = {13, 7, 6, 45, 21, 9, 2, 100};
		Arrays.sort(arr2, Collections.reverseOrder());	// sorts array in descending order
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(10);
		arrList.add(5);
		arrList.add(20);
		arrList.add(7);
		System.out.println(arrList);	// print ArrayList
		Collections.sort(arrList);	// sorts ArrayList
		Collections.sort(arrList, Collections.reverseOrder());	// sorts ArrayList in reverse order
		
		ArrayList<Point> arrList2 = new ArrayList<Point>();
		arrList2.add(new Point(10,20));
		arrList2.add(new Point(3,12));
		arrList2.add(new Point(5,7));
		Collections.sort(arrList2, new PointSort());	// MySort should be a class which implements Comparator interface to compare Point class objects.
		for(int i=0; i<arrList2.size(); i++) {
			System.out.println("(" + arrList2.get(i).x + "," + arrList2.get(i).y + ")");
		}

	}

}
