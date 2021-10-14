package sorting;

import java.util.Comparator;

public class PointSort implements Comparator<Point> { 
		
	public int compare(Point a, Point b) {	// Compare method returns -1, 0 or 1 to say if first value is smaller, equal, or larger to the other respectively, larger value will go to the 2nd position.
		return(a.x - b.x);	// sort objects by increasing order of x
//		return(b.x - a.x);	// sort objects by decreasing order of x
//		return(a.y - b.y);	// sort objects by increasing order of y
//		return(b.y - a.y);	// sort objects by decreasing order of y
	}

}
