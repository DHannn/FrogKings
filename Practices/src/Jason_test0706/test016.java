package Jason_test0706;

public class test016 implements Cloneable{
	String TeamName;
	int stuNum;
	String[] stuName;
	@Override
	protected Object clone() throws CloneNotSupportedException{
		test016 t016 =(test016) super.clone();
		return t016;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		test016 t001 = new test016();
		t001.TeamName = "FrogNo1";
		t001.stuNum = 3;
		t001.stuName = new String[]{"Adam","Bob","Clair"};
		
		test016 t002 = (test016)t001.clone();
		
		System.out.println(t001.hashCode());
		System.out.println(t002.hashCode());
		
		t001.TeamName = "Jason Green";
		t001.stuNum = 1;
		t001.stuName = new String[]{"Emeryd"};
		System.out.println("T001->TeamName£º"+t001.TeamName);
		System.out.println("T001->stuNum£º"+t001.stuNum);
		System.out.println("T001->stuName:"+t001.stuName[0]+" "+t001.stuName);
		
		System.out.println("T002->TeamName£º"+t002.TeamName);
		System.out.println("T002->stuNum£º"+t002.stuNum);
		System.out.println("T002->stuName:"+t002.stuName[0]);
		
	}

}
