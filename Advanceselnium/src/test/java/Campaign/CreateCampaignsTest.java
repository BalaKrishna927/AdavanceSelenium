package Campaign;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.BaseClass;
import Generic_utility.Exell_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utilty;
import Generic_utility.WebDriver_Utility;
import Pom_Repos.CampaignCreateNavigationPage;
import Pom_Repos.CreateCampaignPage;
import Pom_Repos.Homepage;
import Pom_Repos.LoginPage;
import Pom_Repos.ValidateCampaigns;

public class CreateCampaignsTest extends BaseClass {


	public static void main(String[] args) throws Throwable {
    	File_Utility flib = new File_Utility();
    	
    	WebDriver_Utility wlib = new WebDriver_Utility();
		  Java_utilty jlib = new Java_utilty();
		  Exell_Utility elib = new Exell_Utility();
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
		
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.logn(USERNAME, PASSWORD);


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Homepage home = new Homepage(driver);
		home.clickMoreLink();
		home.clickCampLink();
		
		CampaignCreateNavigationPage camp = new CampaignCreateNavigationPage(driver);
		camp.clickCampPlus();

		int ranNum = jlib.getRandomNum();  

		String CampName = elib.getexell("campaign", 0, 0) + ranNum;
		System.out.println(CampName);

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CampName);
		campPage.clickSaveButton();

		ValidateCampaigns valid = new ValidateCampaigns(driver);
		valid.validateCampName(driver, CampName);
		

	}

}
