package Jason_test0701;

import java.util.Map.Entry;
import java.util.*;

public class test005 {

	public static void main(String[] args) {
		test005 t05 = new test005();
		System.out.println("下面输出Hashmap:");
		t05.functio51();
		System.out.println("\r\r下面输出Hashmap的KEY:");
		t05.functio52();
		System.out.println("\r\r下面输出Hashmap的VALUE:");
		t05.functio53();
	}
	
	void functio51(){
		HashMap map = new HashMap<Integer, String>();
		map.put("1", "AAAA");
		map.put("2", "BBBB");
		map.put("3", "CCCC");
		
		Set<Entry<Integer, String>> set = map.entrySet();
		Iterator<Entry<Integer, String>> it = set.iterator();
		Entry<Integer, String> entry;
		while (it.hasNext()) {
			entry =  it.next();
			System.out.println("("+entry.getKey()+",  "+entry.getValue()+")");
		}
	}

	void functio52(){
		HashMap map = new HashMap<Integer, String>();
		map.put("1", "AAAA");
		map.put("2", "BBBB");
		map.put("3", "CCCC");
		
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			String o =  (String) it.next();
			System.out.println(Integer.parseInt(o));
		}
	}
	
	void functio53(){
		HashMap map = new HashMap<Integer, String>();
		map.put("1", "AAAA");
		map.put("2", "BBBB");
		map.put("3", "CCCC");
		
		Collection<String> col = map.values();
		Iterator<String> it = col.iterator();
		while (it.hasNext()) {
			String i =  it.next();
			System.out.println(i);
		}
	}
}
