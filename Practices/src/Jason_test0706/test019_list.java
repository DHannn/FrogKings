package Jason_test0706;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class test019_list {

	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		li.add("黄河远上白云间");
		li.add("一片孤城万仞山");
		li.add("羌笛何须怨杨柳");
		li.add("春风不度玉门关");
		
		//list可直接打印，自动遍历
		System.out.println(li+"\n");
		
		//将链表变换为数组打印
		String[] strarray = new String[li.size()];
		li.toArray(strarray);
		for (String string : strarray) {
			System.out.println(string);
		}
		
		System.out.println();
		//使用迭代器遍历
		Iterator<String> it = li.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(string);
		}
	}

}
