package Jason_test0705;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class test014 {

	public static void main(String[] args) throws IOException {
		PipedOutputStream pout = new PipedOutputStream();
		PipedInputStream pin = new PipedInputStream(pout); 
		
		for (int i = 0; i < 100; i++) {
			pout.write(i);
		}
		pout.close();
		int j;
		while ((j = pin.read()) != -1) {
			System.out.println(j);
		}
		pin.close();
	}
}

/**
 * practice:��ϰʹ��PipedInputStream��PipedOutStream, ���ǳɶԳ��֣�Ӧ���ڶ��߳��е��߳�ͨ��
 * 
 */
