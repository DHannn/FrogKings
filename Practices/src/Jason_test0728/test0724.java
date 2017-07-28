package Jason_test0728;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import javafx.concurrent.WorkerStateEvent;
public class test0724 {

	static private long offset_length = 300;   //每个线程处理的数据块长度
	
	public static void main(String[] args) throws Exception {
		
		//取得文件的长度
		String filepath1 = "test.dat";
//		String filepath2 = "hello.txt";
		String keyword = "hello.txt";
		
		//取得文件的长度
		RandomAccessFile raf = new RandomAccessFile(filepath1, "r");
		long len = raf.length();
		raf.close();
		System.out.println("--------------------------The file length = "+ len);
		
		//计算需要启动的线程数目
		int num = (int) (len/offset_length +1);
		//启动线程
		Thread[] T = new Thread[num];
		for (int i = 0; i < num; i++) {
			String taskname = "task_" + i;
		}
	}	
}
