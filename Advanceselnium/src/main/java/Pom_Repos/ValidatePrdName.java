package Pom_Repos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidatePrdName {
	public ValidatePrdName(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validatePrd(WebDriver driver,String PrdName )
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}
	}


}
