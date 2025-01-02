package Pom_Repos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindBysAndFindAll {

	public FindBysAndFindAll(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({@FindBy(xpath = "//input[@type='text']"),@FindBy(name = "user_name")})
	private WebElement userName;
	
	@FindAll({@FindBy(xpath = "//input[@type='password']"),@FindBy(name="user_password")})
	private WebElement passWordName;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public void enterName(String name,String passWord)
	{
		userName.sendKeys(name);
		passWordName.sendKeys(passWord);
		loginButton.click();
	}
}
