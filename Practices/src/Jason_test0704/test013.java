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
//		f.delete();    //ɾ��ָ���ļ� ��f��Ψһ���������ļ���
		test013 t013 = new test013();
		t013.readFromFile(filename2);
		t013.copyToFile(filename2, filename1);
	}
	
	void copyToFile(String filename1, String filename2) throws IOException{
		//��ȡ�ļ���Ŀ���ļ������������
		FileInputStream fin = new FileInputStream(filename1);  //inputStream��д�����������ݽ��ն�
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(filename2);  //outStream������������������Ͷ�
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//��ȡ�������ͨ��
		FileChannel pin = fin.getChannel();
		FileChannel pout = fout.getChannel();
		
		//������������Ԥ���仺�����ռ�
		ByteBuffer bytebuffer = ByteBuffer.allocate(1024);  
		byte[] buffer = bytebuffer.array();
		while (true) {
			bytebuffer.clear(); // ������������ݣ�
			int r = fin.read(buffer);
			if (r == -1) {
				break;
			}
			bytebuffer.flip();
			fout.write(buffer);  //��byte[]����buffer������ͨ��FileOutStream.write(byte[])����д��outStream�е�ָ���ļ���ȥ
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
