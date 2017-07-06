package Jason_test0706;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;


public class test017 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("A", "明月出天山");
		map.put("B", "苍茫云海间");
		map.put("C", "长风几万里");
		map.put("D", "吹度玉门关");
		
		//Solution A: 使用较为普遍，一次使用,二次取值
		System.out.println();
		System.out.println("Solution A:");
		System.out.println("通过Map.keySet遍历key和value:");
		for (String key : map.keySet()) {
			System.out.println("key:"+key +" value:"+map.get(key));
		}
		
		//Solution B
		System.out.println();
		System.out.println("Solution B:");
		System.out.println("通过Map.entrySet使用迭代器iterator遍历key和value:");
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key:"+entry.getKey() +" value:"+entry.getValue());
		}
		
		//Solution C
		System.out.println();
		System.out.println("Solution C:");
		System.out.println("通过Map.entrySet遍历key和value");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
		}
		
		//Solution D
		System.out.println();
		System.out.println("Solution D:");
		System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
		for (String value :map.values()) {
			System.out.println("value = "+value);
		}
	}

}
