package DDTs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataintoPropertifile {
	public static void main(String[] args) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Users\\vijay\\OneDrive\\Desktop\\Advance Selenium\\Propertiefile1.txt");
          
		Properties pro = new Properties();
		

		pro.setProperty("url", "https://www.saucedemo.com/v1/");
		pro.setProperty("username", "standard_user");
		pro.setProperty("password", "secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\vijay\\OneDrive\\Desktop\\Advance Selenium\\Propertiefile1.txt");
		
				pro.store(fos, "Data");
	}


}
