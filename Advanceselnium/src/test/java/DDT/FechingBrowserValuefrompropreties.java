package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FechingBrowserValuefrompropreties {
public static void main(String[] args) throws IOException {
	FileInputStream file = new FileInputStream("./src/test/resources/Propertiefile1.txt");
	
	Properties  pro = new Properties();
	
	pro.load(file);
	
	String BROWSER = pro.getProperty("browser");
	
	WebDriver driver;
	
	if (BROWSER.equalsIgnoreCase("chrome")) {
		
		driver = new ChromeDriver();
		
		
	}
	else if (BROWSER.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
		
	}else if (BROWSER.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
		
	}else {
		driver = new ChromeDriver();
		
	}
	
	driver.manage().window().maximize();
	
	String URL = pro.getProperty("url");
	
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	
	driver.get(URL);
	
	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	driver.findElement(By.id("login-button")).click();
	
	System.out.println(URL);
	System.out.println(USERNAME);

	System.out.println(PASSWORD);

	
	
}
}
