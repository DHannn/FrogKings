package Jason_test0704;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class test013 {

	public static void main(String[] args) throws IOException  {
		String filename1 = "D:"+File.separator+"Jason_test"+File.separator+"test0704.docx";
		String filename2 = "D:"+File.separator+"Jason_test"+File.separator+"test0704.txt";
		
//		File f = new File(filename1);
//		try {
//			f.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Fail To Create File.");
//		}
//		f = null;
//		f.delete();    //删除指定文件 “f可唯一锁定操作文件”
		test013 t013 = new test013();
		t013.readFromFile(filename2);
		t013.copyToFile(filename2, filename1);
	}
	
	void copyToFile(String filename1, String filename2) throws IOException{
		//获取文件和目标文件的输入输出流
		FileInputStream fin = new FileInputStream(filename1);  //inputStream是写入流，是数据接收端
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(filename2);  //outStream是输出流，是数据输送端
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//获取输入输出通道
		FileChannel pin = fin.getChannel();
		FileChannel pout = fout.getChannel();
		
		//创建缓存区并预分配缓存区空间
		ByteBuffer bytebuffer = ByteBuffer.allocate(1024);  
		byte[] buffer = bytebuffer.array();
		while (true) {
			bytebuffer.clear(); // 清除缓存区数据，
			int r = fin.read(buffer);
			if (r == -1) {
				break;
			}
			bytebuffer.flip();
			fout.write(buffer);  //将byte[]数组buffer的数据通过FileOutStream.write(byte[])方法写到outStream中的指定文件中去
		}
	}
	
	
	void readFromFile(String f1) throws IOException{
		File f = new File(f1);
		InputStream in = new FileInputStream(f);
		byte[] b = new byte[(int) f.length()];
		in.read(b);
		System.out.println("File Length :"+f.length());
		in.close();
		System.out.println("用以承装文件信息的byte对象："+b);
		System.out.println("文件信息内容:\n"+new String(b));
	}

}
