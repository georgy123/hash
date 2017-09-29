package algorithms.test;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapTest {
   public static void main(String[] args) {
//	   String a ="abc";
//	   Object b = new String("abc");
//	   System.out.println(a.hashCode());
//	   System.out.println(b.hashCode());
//	   System.out.println(b.equals(a));
//	   System.out.println(a==b);
	   HashMap<String, Integer> map = new HashMap<String, Integer>();
	   map.put("语文", 1);
	   map.put("数学", 2);
	   map.put("英语", 3);
	   map.put("历史", 4);
	   map.put("政治", 5);
	   map.put("地理", 6);
	   map.put("生物", 7);
	   map.put("化学", 8);
//	   map.put("a", 9);
//	   map.put("b", 10);
//	   map.put("c", 11);
//	   map.put("d", 12);
//	   map.put("e", 13);
//	   map.put("f", 14);
//	   map.put("g", 15);
//	   map.put("h", 16);
//	   map.put("i", 17);
	   for(Entry<String, Integer> entry : map.entrySet()) {
	       System.out.println(entry.getKey() + ": " + entry.getValue());
	   }
}
}
