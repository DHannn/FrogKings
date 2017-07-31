package Jason_test0728;
import java.io.RandomAccessFile;
public class test0724 {

	static private long offset_length = 300;   //每个线程处理的数据块长度
	
	
	public static void main(String[] args) throws Exception {
		
		
		//取得文件的长度
		String filepath1 = "D:\\Jason_test\\test.dat";
//		String filepath2 = "hello.txt";
		String keyword = "hello.txt";
		
		//取得文件的长度
		RandomAccessFile raf = new RandomAccessFile(filepath1, "r");
		long len = raf.length();
		raf.close();
		System.out.println("--------------------------\nThe file length = "+ len);
		
		//计算需要启动的线程数目
		int num = (int) (len/offset_length +1);
		//启动线程
		Thread[] T = new Thread[num];
		for (int i = 0; i < num; i++) {
			String taskname = "task_" + i;
			T[i] = new Thread(new WorkerThread(taskname, offset_length * i, offset_length, keyword, filepath1));
			T[i].start();
		}
		
		for (int i = 0; i < num; i++) {
			try{
				T[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--------------------------------------");
		System.out.println("Task started, main ends." + WorkerThread.counter);
	}	
}
