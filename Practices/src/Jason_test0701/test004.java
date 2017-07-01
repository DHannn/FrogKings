package Jason_test0701;

import java.util.Scanner;

public class test004 {

	public static void main(int argv, String args){
		test004 t04 = new test004();
		t04.function1();
		int[] array = {1,2,3,4,5,6,7,8,9};
		t04.function2(array);
	}
	
	void function1(){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String c = a + b;
		System.out.println(c);
	}
	
	int function2(int[] a){
		int sum = 0;
		for (int i = 0; i <= a.length+1; i++) {
			int j = a[i];
			sum += j;
		}
		return sum;
	}
}

