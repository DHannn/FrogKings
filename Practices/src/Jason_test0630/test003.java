package Jason_test0630;


public class test003 extends test002{
	int num;
	String name;
	test003(int num, String name) {
		super(num, name);
		this.num = num;
		this.name = name;
	}
	
	public static void main(String[] args) {
		System.out.println("对象test003的hashcode:"+new test003(123, "DSA").hashCode());
		System.out.println("对象test003的equals自己:"+new test003(123, "DSA").equals(new test003(123, "DSA")));
	}
}
