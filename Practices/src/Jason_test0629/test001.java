package Jason_test0629;
import java.util.Iterator;
import java.util.LinkedList;

public class test001 {
	public static void main(String[] args) {
		LinkedList<String> shenXiao = new LinkedList<String>();
		shenXiao.add("��");	shenXiao.add("��");
	    shenXiao.add("î");	shenXiao.add("��");
	    shenXiao.add("��");shenXiao.add("��");
	    shenXiao.add("δ");shenXiao.add("��");
	    shenXiao.add("��");shenXiao.add("��");
	    shenXiao.add("��"); 
	    shenXiao.add(2, "��");
		System.out.println(shenXiao);
		Iterator<String> it = shenXiao.iterator();
		for (Iterator iterator = shenXiao.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.print(string+" ");
		}
	}
}
