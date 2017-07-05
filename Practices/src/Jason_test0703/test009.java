package Jason_test0703;

/*
 * a= abv
 * b= abv
 * c= abv
 * d= abv
 * e= abv
 */
public class test009 {

	public static void main(String[] args) {
		String a = "abv";
		String b = "abv";
		String c = "a";
		String d = c + "bv";
		String e = "a" + "bv";
		test009 t09 = new test009();
		t09.function0091(a, b, c, d, e);
		
	}

	 void function0091(String a, String b, String v, String d, String e){
		if (a == b ) {
			System.out.println("a == b");
			//a, b all point to "abv", share the same address.
		}else{
			System.out.println();
		}		
		
		if (a.equals(b) == true) {
			System.out.println("a equals b");
			// a, b owns the same value. 
		}else{
			System.out.println();
		}
		
		if (d == a ) {
			System.out.println("d == a");
			
		}else{
			System.out.println();
		}
		
		if (e == a ) {
			System.out.println("a == e");
			//
		}else{
			System.out.println();
		}
	}
}
