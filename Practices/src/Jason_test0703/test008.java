package Jason_test0703;

public class test008 {
/*
 *比较SrtingBuilder和StringBuffer在做字符串连接的时候对内存的使用情况
 * 
 */
	public static void main(String[] args) {
		String s1 = "";
		String s2 = new String("string");
		StringBuilder stringbuilder = new StringBuilder(1000);
		
		System.out.println("[StringBuilder] Before ruinning the free memory:"+Runtime.getRuntime().freeMemory());
		for (int i = 0; i < 1000; i++) {
			s1 += s2;
//			stringbuilder.append(s2);
			if (i % 100 == 0) {
				System.out.println("When running the free memory id "+Runtime.getRuntime().freeMemory());
			}
		}
		System.out.println("\n\n");
		System.out.println("[StringBuffer] Before ruinning the free memory:"+Runtime.getRuntime().freeMemory());

		for (int i = 0; i < 1000; i++) {
			
			StringBuffer sbuffer = new StringBuffer();
			sbuffer.append(s2);
			while (i%100 == 0) {
				System.out.println("When running the free memory id "+Runtime.getRuntime().freeMemory());
				i++;
			}
		}
	}

}
