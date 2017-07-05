package Jason_test0705;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class test015 {

	public static void main(String[] args) {
		test015 t015 = new test015();
		try {
			t015.function0151();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void function0151() throws IOException{
		// 创建config.properties
		String confpath = "D:\\Jason_test\\config.properties";
		File file1;
		file1 = new File(confpath);
//		file1.createNewFile();
		
		FileInputStream fin = new FileInputStream(file1);
		Properties properties = new Properties();
		properties.load(fin);
		OutputStream fout = new FileOutputStream(file1);
		properties.clear();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:30003/xbrl_neeq?useUnicode=true&characterEncoding=UTF-8");
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "xbrlbf");
		properties.save(fout, "无则写入，有则修改");
		
		//获取properties的value值的集合并打印出来
//		Enumeration<Object> elements = properties.elements();
//		while (elements.hasMoreElements()) {
//			String o =  (String) elements.nextElement();
//			System.out.println(o);
//		}
		
	}
}
