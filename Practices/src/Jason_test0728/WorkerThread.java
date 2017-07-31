package Jason_test0728;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkerThread extends Thread {

	private String taskName;
	private long  start;
	private long length;
	private  String keyword;
	private String filepath;
	
	int MAX_BUFFFER_LENGTH = 1024*1; //线程每次能够处理的最大数据长度
	
	public static long counter = 0;
	
	// 同步方法，用于累加个线程的统计数据（因为使用的是静态变量，所以相当于访问共享资源，需要加锁）
	synchronized public static void addCounter(long num){ 
		counter = counter + num;
	}
	
	// 构造函数
	public WorkerThread(String name, long start, long length, String keyword, String filepath){
		this.taskName = name;
		this.start = start;
		this.length = length;
		this.keyword = keyword;
		this.filepath = filepath;
	}

	// 线程体
	public void run(){ 
		System.out.println(taskName + " is running. " + start + "--" + (start + length) );
		try{
			// 处理指定区域内的数据
			findWordsInBuffer(start, length);
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(taskName + " is running. " + start + "--" + (start + length) );
	}
	
	// 根据开始位置和数据长度，处理指定区域内的数据
	void findWordsInBuffer(long Start, long length) throws IOException{
		// 首先，打开随机读取文件
		RandomAccessFile raf = new RandomAccessFile(filepath, "r");
		raf.seek(start);
		System.out.println("Initial position: " + raf.getFilePointer());
		
		int buf_len = MAX_BUFFFER_LENGTH;
		byte[] b = new byte[buf_len];
		int hasRead = 0;
		int count = 0;
		long num = 0;
		 int max_break_word_len = keyword.length() - 1;  // 用于解决关键字跨行或者跨线程数据块的问题
		 while (count < length) {
			int left_len = (int) (length - count);
			if (left_len > buf_len) {
				hasRead = raf.read(b, 0, buf_len);
			} else {
				hasRead = raf.read(b, 0, left_len + max_break_word_len);
			}
			count += hasRead;
			count -= max_break_word_len;
			
			if (hasRead < 0) {
				break;
			}
			
			String data = new String(b, 0, hasRead);
			data = data.replace("\r\n", "");
			
			num += matchNum(data, keyword);
			System.out.println("num = " + num);
		}
		addCounter(num);
	}
	
	// 使用正则表达式统计单次缓冲区中的关键字个数（当然也可以用字符串直接查找子串的函数）
	int matchNum(String src, String target){
		String pattern = "(" + target + "){1}";
		Pattern p = Pattern.compile(pattern);
		Matcher m =p.matcher(src);
		int i =0;
		while (m.find()) {
			i++;
		}
		return i;
	}
}
