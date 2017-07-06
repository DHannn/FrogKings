package Jason_test0706;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;


public class test017 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("A", "���³���ɽ");
		map.put("B", "��ã�ƺ���");
		map.put("C", "���缸����");
		map.put("D", "�������Ź�");
		
		//Solution A: ʹ�ý�Ϊ�ձ飬һ��ʹ��,����ȡֵ
		System.out.println();
		System.out.println("Solution A:");
		System.out.println("ͨ��Map.keySet����key��value:");
		for (String key : map.keySet()) {
			System.out.println("key:"+key +" value:"+map.get(key));
		}
		
		//Solution B
		System.out.println();
		System.out.println("Solution B:");
		System.out.println("ͨ��Map.entrySetʹ�õ�����iterator����key��value:");
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key:"+entry.getKey() +" value:"+entry.getValue());
		}
		
		//Solution C
		System.out.println();
		System.out.println("Solution C:");
		System.out.println("ͨ��Map.entrySet����key��value");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
		}
		
		//Solution D
		System.out.println();
		System.out.println("Solution D:");
		System.out.println("ͨ��Map.values()�������е�value�������ܱ���key");
		for (String value :map.values()) {
			System.out.println("value = "+value);
		}
	}

}
