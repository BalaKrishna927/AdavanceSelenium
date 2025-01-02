package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_utility.Exell_Utility;
import Generic_utility.File_Utility;
import Generic_utility.Java_utilty;
import Generic_utility.WebDriver_Utility;
import Pom_Repos.CreateProductPage;
import Pom_Repos.DeleteProductName;
import Pom_Repos.Homepage;
import Pom_Repos.LoginPage;
import Pom_Repos.ProductLookUp;
import Pom_Repos.ValidatePrdName;

public class CreateproductAndDeleteProduct {

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
		
		LoginPage login = new LoginPage(driver);
		login.logn(USERNAME, PASSWORD);

		Homepage home = new Homepage(driver);
		home.clickProductLink();
	    
	       ProductLookUp prd = new ProductLookUp(driver);
			prd.clickOnPlusSign();
 
		// To Avoid the Duplicates

		Java_utilty jlib =  new Java_utilty();
		int ranNum = jlib.getRandomNum();
		
		
		Exell_Utility elib = new   Exell_Utility(); 
		String prdName = elib.getexell("product", 0, 0)+ranNum;
		System.out.println(prdName);

		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(prdName);
		prdPage.clickSaveButton();
		

		 ValidatePrdName validate = new ValidatePrdName(driver);
			validate.validatePrd(driver, prdName);

		

			// Navigating to product table
			home.clickProductLink();

			DeleteProductName delete = new DeleteProductName(driver);
			delete.selectProdName(driver, prdName);
			delete.selectDeletButton();

			wlib.alertAccept(driver);

			delete.validatePrdDeleted(driver, prdName);

			home.logOutFromApp();

	}

}
