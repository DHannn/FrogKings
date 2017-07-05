package Jason_test0703;

import java.io.File;
import java.io.IOException;

public class test011 extends test010{

	public static void main(String[] args) {
		test011 t11 = new test011();
		t11.function010();
		t11.function011();
	}
	
	void function011(){
		File f = new File("D:\\hello\\hello.docx");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not create the file.");
		}
		finally{
			f = null;
		}
	}
	
	/**
	 * 在指定路径下面新建文件（ File.createNewFile(). ）
	 */
}
