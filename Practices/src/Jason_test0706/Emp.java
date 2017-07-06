package Jason_test0706;

public class Emp implements Comparable<Object>{
	int num;
	String name;
		
	Emp(int num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		Emp emp = (Emp) o;
		return num>emp.num ? 1:(num == emp.num ? 0 : -1);
	}

	@Override
	public String toString(){
		return num+": "+name;
	}
}
