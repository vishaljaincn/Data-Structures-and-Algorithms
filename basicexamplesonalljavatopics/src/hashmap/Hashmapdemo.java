package hashmap;

import java.util.HashMap;
import java.util.Map;

public class Hashmapdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<>();
		map.put("a", 10);
		map.put("b", 20);
		map.put("c", 30);
		map.put("ajay", 10);
		map.put("bold", 20);
		map.put("cigar", 30);
		System.out.println(map.get("ajay"));
		System.out.println(map.size());
		System.out.println(map);
		
		if(map.containsKey("a"))
		{
			int a=map.get("a");
			System.out.println("the value of key a is "+ a);
		}
		//if u have access only to the keys
		for(String key:map.keySet())
		{
			System.out.println("key is " + key +" , value is "+map.get(key));
		}
		//if u have access to both keys and values
		for(java.util.Map.Entry<String, Integer> entry:map.entrySet())
		{
			System.out.println("key is "+entry.getKey()+" , value is "+entry.getValue());
		}

	}

}
