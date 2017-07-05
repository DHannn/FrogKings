package Jason_test0703;

import java.io.File;

public class test010 {

	public static void main(String[] args) {
		test010 t10 = new test010();
		t10.function010();
	}
	
	void function010(){
		String filename = "D:"+File.separator+"hello";
		File f =new File(filename);
		f.mkdir();
		
		String dirName = "D:"+File.separator;
		File f1 = new File(dirName);
		String[] str = f1.list();
		for (int i = 0; i < str.length; i++) {
			//下述打印验证File.seperator就是和"\"等价的，在URL中用作区分标识不同目录级别
			System.out.println("D:\\"+str[i]);
//			System.out.println("D:"+File.separator+str[i]);
//			System.out.println();
			
		}
	}
/**
 * 创建文件夹，打印指定目录层级的列表
 */
}


