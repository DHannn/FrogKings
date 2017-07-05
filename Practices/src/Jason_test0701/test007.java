package Jason_test0701;

import java.io.File;
import java.io.FileInputStream;
<<<<<<< HEAD
import java.io.FileOutputStream;
=======
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
>>>>>>> branch 'master' of https://github.com/DHannn/FrogKings.git
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class test007{
	public static void main(String[] args) {
		File newFile = new File("D:\\test\\config.properties");
		if(!newFile.exists()){
			newFile.mkdirs();   //新建文件夹
		}
		if(newFile.exists()){
			newFile.delete();
		}
		
	}
	
	void function07() throws Exception{
		String confPath="d:\\test\\config.properties";
		 InputStream fin=new FileInputStream(confPath);		 
		 Properties props = new Properties();		 
        props.load(fin); //先load老的key-value  
		 OutputStream fos = new FileOutputStream(confPath); 
        props.setProperty("username", "上天揽月");
        //username=\u4E0A\u5929\u63FD\u6708 
        props.setProperty("password", "6666");//password=6666
        props.store(fos, "无则写入、存在则修改");

	}

}
