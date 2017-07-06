package Jason_test0706;

import java.util.Set;
import java.util.TreeSet;

public class test018_treeSet {

	public static void main(String[] args) {
		Set<Emp> emp = new TreeSet<Emp>();
		emp.add(new Emp(2, "Bob"));
		emp.add(new Emp(1, "Adam"));
		emp.add(new Emp(3, "Clair"));
		
		System.out.println(emp);
	}

}
