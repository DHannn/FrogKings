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
		System.out.println("����test003��hashcode:"+new test003(123, "DSA").hashCode());
		System.out.println("����test003��equals�Լ�:"+new test003(123, "DSA").equals(new test003(123, "DSA")));
	}
}
