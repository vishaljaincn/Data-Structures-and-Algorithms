package treemap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Treemapdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedMap<Integer, String> map=new TreeMap<>();
		map.put(3, "a");
		map.put(1, "b");
		map.put(2, "c");
		Map<String,Integer > map2=new TreeMap<>();
		map2.put("bold",20);
		map2.put("cigar",30);
		map2.put("ajay",10);
		System.out.println(map);
		System.out.println(map2);
		map.remove(1);
		System.out.println(map);
		map.remove(2, "c");
		System.out.println(map);
	}

}
