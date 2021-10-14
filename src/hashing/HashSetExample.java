package hashing;

import java.util.HashSet;
import java.util.Iterator;

//	HashSet is used to store only keys while HashMap stores key-value pairs. it does not allow duplicate keys.
//	primitive data type is not allowed in HashSet, user defined data type should have function HashCode.
//	add, remove, contains - O(1) on average
//	size, isEmpty - O(1)
public class HashSetExample {
	
	public static void main(String[] args) {

		HashSet<String> h = new HashSet<String>();	
		// HashSet<String> h = new HashSet<String>(5);	// better to use, when we already know the initial capacity in advance
		
		h.add("hello");								
		h.add("world");
		h.add("of");
		h.add("java");
		
		System.out.println(h);						
		
        Iterator<String> i = h.iterator(); 			// Iterating over hash set items
        while (i.hasNext()) 
            System.out.print(i.next() + ", "); 
        System.out.println();
        
        for(String s : h)
        	System.out.print(s + ", ");
        System.out.println();
        
        
		System.out.println(h.remove("of"));
		System.out.println(h.remove("hey"));
        System.out.println(h.contains("world"));	
        System.out.println(h.size());
		System.out.println(h.isEmpty());
		h.clear();									
		
	}

}
