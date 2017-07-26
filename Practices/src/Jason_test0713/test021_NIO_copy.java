package Jason_test0713;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class test021_NIO_copy {
	public static void main(String[] args) throws IOException {
		String inF = "D:\\Jason_test\\test0704.txt";
		String outF = "D:\\Jason_test\\test0704-copy.txt";
		
		//获取源文件和目标文件的输入输出流
		FileInputStream fin = new FileInputStream(inF);
		FileOutputStream fout = null;
		try{
			fout = new FileOutputStream(outF);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//获取输入输出通道
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();
		
		//创建缓冲区
		ByteBuffer bytebuffer = ByteBuffer.allocate(2048);
		
		while (true) {
			//清空缓冲区
			bytebuffer.clear();
			int r = fcin.read(bytebuffer);
			//read方法返回读取到的字节数，可能为零，若该通道以达到流的末尾，则返回-1
			if (r == -1) {
				break;
			}
			//flip()方法可以让缓冲区将新读入的数据写入另一个通道
			bytebuffer.flip();
			//从输出通道中将数据写入缓冲区
			fcout.write(bytebuffer);
		}
		System.out.println("end!");
	}
}
