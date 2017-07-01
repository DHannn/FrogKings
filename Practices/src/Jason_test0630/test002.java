package Jason_test0630;

import java.util.Set;
import java.util.TreeSet;


/**
 * 代码：自定义类做元素 必须实现Comparable，否则TreeSet无法add()
 * @author Jason Green
 *
 */
public class test002 implements Comparable<Object>{
	int num;
	String name;
		
	test002(int num, String name) {
		this.num = num;
		this.name = name;
	}


	@Override
	public int compareTo(Object o) {
		test002 t02 = (test002) o;
		return num > t02.num ? 1: (num == t02.num ? 0 : -1);
	}
	
	public String toString(){
		return num+":"+name;
	}
	
	public static void main(String[] args) {
		Set<test002> test02 = new TreeSet<test002>();
		test02.add(new test002(2,"Ahmad"));
		test02.add(new test002(3,"Bob"));
		test02.add(new test002(1,"Caroline"));
		test02.add(new test002(4,"Digens"));
		System.out.println(test02);
	}

	

}
