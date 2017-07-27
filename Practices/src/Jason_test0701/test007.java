package Jason_test0701;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class test007{
	public static void main(String[] args) {
		File newFile = new File("D:\\test027\\config.properties");
		if(!newFile.exists()){
			newFile.mkdirs();   //�½��ļ���
		}
		if(newFile.exists()){
			newFile.delete();
		}
		
	}
	
	void function07() throws Exception{
		String confPath="d:\\test027\\config.properties";
		 InputStream fin=new FileInputStream(confPath);		 
		 Properties props = new Properties();		 
        props.load(fin); //��load�ϵ�key-value  
		 OutputStream fos = new FileOutputStream(confPath); 
        props.setProperty("username", "��������");
        //username=\u4E0A\u5929\u63FD\u6708 
        props.setProperty("password", "6666");//password=6666
        props.store(fos, "����д�롢�������޸�");

	}

}
