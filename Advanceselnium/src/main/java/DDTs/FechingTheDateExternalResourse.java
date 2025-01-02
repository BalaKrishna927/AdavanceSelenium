package DDTs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FechingTheDateExternalResourse {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
        
		
		FileInputStream file = new FileInputStream("C:\\Users\\vijay\\OneDrive\\Desktop\\Advance Selenium\\Propertiefile1.txt");
		
		Properties pro = new Properties();
		
		pro.load(file);
		

		String  URl = pro.getProperty("url");
		
		String  USERNAME = pro.getProperty("username");
		String  PASSWORD = pro.getProperty("password");
		
		driver.get(URl);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
	}

}
