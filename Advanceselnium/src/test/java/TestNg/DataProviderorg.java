package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.Exell_Utility;
import Generic_utility.Java_utilty;

public class DataProviderorg {
	
	@Test(dataProvider = "getData")
	public void createOrganization(String name, String mailId) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		Java_utilty jau =  new Java_utilty();
		
	     int randoms = jau.getrandom();
		driver.findElement(By.name("accountname")).sendKeys(name+randoms);
		driver.findElement(By.name("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		
		 Exell_Utility elib = new Exell_Utility();
		Object[][] values = elib.readtheDataprovider("DataProvider");
		return values;
}
	}

