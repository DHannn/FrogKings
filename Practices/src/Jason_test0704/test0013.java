package Jason_test0704;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class test0013 {

	public static void main(String[] args) throws IOException  {
		String filename1 = "D:"+File.separator+"Jason_test"+File.separator+"test0704-copy.txt";
		String filename2 = "D:"+File.separator+"Jason_test"+File.separator+"test0704.txt";
		
		File f = new File(filename1);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail To Create File.");
		}
		f = null;
//		f.delete();    //ɾ��ָ���ļ� ��f��Ψһ���������ļ���
		test0013 t013 = new test0013();
		t013.readFromFile(filename2);
		t013.copyToFile(filename2, filename1);
	}
	
	void copyToFile(String filename1, String filename2) throws IOException{
		//��ȡ�ļ���Ŀ���ļ������������
		FileInputStream fin = new FileInputStream(filename2);
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(filename1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��ȡ�������ͨ��
		FileChannel pin = fin.getChannel();
		FileChannel pout = fout.getChannel();
		
		//����������
		ByteBuffer bytebuffer = ByteBuffer.allocate(1024);
		byte[] buffer = bytebuffer.array();
		while (Math.random()%2 == 1) {
			bytebuffer.clear(); // clear buffer space and prepare for new data 
			fin.read(buffer);
			if (buffer.length < 1) {
				break;
			}
			bytebuffer.flip();
			fout.write(buffer);
		}
	}
	
	
	void readFromFile(String f1) throws IOException{
		File f = new File(f1);
		InputStream in = new FileInputStream(f);
		byte[] b = new byte[(int) f.length()];
		in.read(b);
		System.out.println("File Length :"+f.length());
		in.close();
		System.out.println("���Գ�װ�ļ���Ϣ��byte����"+b);
		System.out.println("�ļ���Ϣ����:\n"+new String(b));
	}

}
