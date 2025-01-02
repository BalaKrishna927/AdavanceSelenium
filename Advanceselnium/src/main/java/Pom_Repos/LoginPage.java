package Pom_Repos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="user_name")
	
	private WebElement usertextfield;
	
@FindBy(name="user_password")
	
	private WebElement Passwordtextfield;


@FindBy(id="submitButton")

private WebElement Loginbutton;


public WebElement getUsertextfield() {
	return usertextfield;
}




public WebElement getPasswordtextfield() {
	return Passwordtextfield;
}




public WebElement getLoginbutton() {
	return Loginbutton;
}

public void logn(String USERNAME, String PASSWORD  ) {
	usertextfield.sendKeys(USERNAME);

	Passwordtextfield.sendKeys(PASSWORD);

	Loginbutton.click();	
}


}
