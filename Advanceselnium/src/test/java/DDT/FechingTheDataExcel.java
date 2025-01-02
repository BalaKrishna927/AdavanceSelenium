package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FechingTheDataExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\vijay\\OneDrive\\Desktop\\DataExcel.xlsx");
		
		Workbook book = WorkbookFactory.create(file);
		
       
		Sheet sheet = book.getSheet("Sheet1");
		
		Row row = sheet.getRow(2);
		
		Cell cell = row.getCell(1);
		
		String exceldata = cell.getStringCellValue();
		
		System.out.println(exceldata);
		
		
	}

}


