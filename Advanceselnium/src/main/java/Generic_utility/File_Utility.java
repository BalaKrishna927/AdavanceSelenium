package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	public String getKeyAndValuePair(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Propertiefile1.txt");
		Properties pro = new Properties();
		pro.load(fis);
		
   String value =	pro.getProperty(Key);
    return value;
		
	}

}
