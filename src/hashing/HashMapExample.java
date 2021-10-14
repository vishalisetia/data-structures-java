package hashing;

import java.util.HashMap;
import java.util.Map;

//	HashMap uses Hashing and implements the map interface means <key,value> pairs
//	fxns like put, remove, get, containsKey, containsValue = O(1) on average
//	fxns like size, isEmpty = O(1) in worst case

public class HashMapExample {

	public static void main(String[] args) {

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Hello", 5);
		hm.put("World", 0);
		hm.put("of", 19);
		hm.put("java", 6);
		
		System.out.println(hm);
		
		hm.put("java", 8);	// again put on present key will update the value.
		
		for(Map.Entry<String, Integer> i : hm.entrySet())
			System.out.print(i.getKey() + ": " + i.getValue() + ", ");
		System.out.println();
		
//		System.out.println(hm.size());				
//		System.out.println(hm.containsKey("World"));
//		System.out.println(hm.containsValue(6));
//		System.out.println(hm.get("Hello"));		// returns coresponding value, if key is not present then return null
//		System.out.println(hm.remove("of"));		// remove <key,value> pair and returns coresponding value
		
	}

}
