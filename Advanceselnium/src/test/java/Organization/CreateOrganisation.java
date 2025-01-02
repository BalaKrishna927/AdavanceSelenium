package Organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.Exell_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utilty;
import Generic_utility.WebDriver_Utility;
import Pom_Repos.CreateOrganizationPage;
import Pom_Repos.Homepage;
import Pom_Repos.LoginPage;
import Pom_Repos.OrganizationNavigationPage;
import Pom_Repos.ValidateOrganization;

public class CreateOrganisation {
	
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
		
		driver.get(URL);
		
		LoginPage login = new LoginPage(driver);
		login.logn(USERNAME, PASSWORD);

		Homepage home = new Homepage(driver);
         home.clickOrgLink();
         
       

OrganizationNavigationPage orgPlus = new OrganizationNavigationPage(driver);
         orgPlus.clickOrgnization();
         
		Java_utilty jlib =  new Java_utilty();
		int ranNum = jlib.getRandomNum();
		
		Exell_Utility elib = new   Exell_Utility(); 
		String OrgName = elib.getexell("Organization", 0, 0)+ranNum;
		System.out.println(OrgName);
		
		

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.enterMailId(OrgName);
		
		String phnNum = elib.readDataFromExcelUsingDataProvider("Organization", 1, 0);
		System.out.println(phnNum);
		orgPage.enterPhnNum(phnNum);
		
		String mailID = elib.readDataFromExcelUsingDataProvider("Organization", 2, 0);

		System.out.println(mailID);
		orgPage.enterMailId(mailID);
		
		 orgPage.enterOrgData(OrgName, phnNum, mailID);
			

         orgPage.clickSaveButton();

         
         ValidateOrganization validate = new ValidateOrganization(driver);
         validate.validateOrgName(driver, OrgName);

	home.logOutFromApp();

	}

}
