package Campaign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.BaseClass;
import Generic_utility.Exell_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utilty;
import Generic_utility.WebDriver_Utility;

public class CreateCampainWithProductTest extends BaseClass  {

	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.maximizingWindow1(driver);
//		wlib.waitForElementsToLoad(driver);
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();

 
		// To Avoid the Duplicates

		Java_utilty jlib =  new Java_utilty();
		int ranNum = jlib.getRandomNum();
		
		
		Exell_Utility elib = new   Exell_Utility(); 
		String prdName = elib.getexell("product", 0, 0)+ranNum;
    
	driver.findElement(By.name("productname")).sendKeys(prdName);
	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	
	driver.findElement(By.linkText("More")).click();
	driver.findElement(By.linkText("Campaigns")).click();

	driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
	String camName = elib.getexell("campaign", 0, 0)+ranNum;

	driver.findElement(By.name("campaignname")).sendKeys(camName);
	
	driver.findElement(By.cssSelector("[title='Select']")).click();

	wlib.swithToWindow(driver, "Products&action");

	driver.findElement(By.name("search_text")).sendKeys(prdName);
	driver.findElement(By.name("search")).click();

//driver.findElement(By.xpath("//a[text()='BlueTooth524']")).click();

	driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();

	wlib.swithToWindow(driver, "Campaigns&action");

	driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	if (actData.contains(camName)) {
		System.out.println("campaign name is created");
	} else {
		System.out.println("campaign name is not created");
	}

	String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();

	if (actData1.contains(prdName)) {
		System.out.println("product name is created");
	} else {
		System.out.println("Product name is not created");
	}

	driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
	driver.findElement(By.linkText("Sign Out")).click();


	}

}
