package Jason_test0706;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class test019_list {

	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		li.add("�ƺ�Զ�ϰ��Ƽ�");
		li.add("һƬ�³�����ɽ");
		li.add("Ǽ�Ѻ���Թ����");
		li.add("���粻�����Ź�");
		
		//list��ֱ�Ӵ�ӡ���Զ�����
		System.out.println(li+"\n");
		
		//������任Ϊ�����ӡ
		String[] strarray = new String[li.size()];
		li.toArray(strarray);
		for (String string : strarray) {
			System.out.println(string);
		}
		
		System.out.println();
		//ʹ�õ���������
		Iterator<String> it = li.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(string);
		}
	}

}
