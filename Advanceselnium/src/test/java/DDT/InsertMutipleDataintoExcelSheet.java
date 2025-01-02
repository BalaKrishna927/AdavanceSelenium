package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMutipleDataintoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
FileInputStream file = new FileInputStream("C:\\Users\\vijay\\OneDrive\\Desktop\\DataExcel.xlsx");
		
		Workbook book = WorkbookFactory.create(file);
		
		Sheet sheet = book.getSheet("Sheet1");
		
	List<WebElement> alllinks =	driver.findElements(By.xpath("//a"));

	for (int i = 0; i < alllinks.size(); i++) {
		
        Row row = sheet.createRow(i);
		
		Cell cell = row.createCell(0);
		 cell.setCellValue(alllinks.get(i).getAttribute("href"));
		
	
	}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/DataExcel.xlsx");
		
		book.write(fos);
		
		book.close();
	}
}

	
	


