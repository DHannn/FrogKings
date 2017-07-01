package Jason_test0629;
import java.util.Iterator;
import java.util.LinkedList;

public class test001 {
	public static void main(String[] args) {
		LinkedList<String> shenXiao = new LinkedList<String>();
		shenXiao.add("×Ó");	shenXiao.add("³ó");
	    shenXiao.add("Ã®");	shenXiao.add("³½");
	    shenXiao.add("ËÈ");shenXiao.add("Îç");
	    shenXiao.add("Î´");shenXiao.add("Éê");
	    shenXiao.add("ÓÏ");shenXiao.add("Ðç");
	    shenXiao.add("º¥"); 
	    shenXiao.add(2, "Òú");
		System.out.println(shenXiao);
		Iterator<String> it = shenXiao.iterator();
		for (Iterator iterator = shenXiao.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.print(string+" ");
		}
	}
}
