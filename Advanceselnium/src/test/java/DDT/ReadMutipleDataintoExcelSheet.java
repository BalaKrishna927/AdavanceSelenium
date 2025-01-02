package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMutipleDataintoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
FileInputStream file = new FileInputStream("./src/test/resources/DataExcel.xlsx");
		
		Workbook book = WorkbookFactory.create(file);
		
       
		Sheet sheet = book.getSheet("Sheet1");
		
		
		
		int rownum = sheet.getLastRowNum();
		 
		 for (int i = 0; i < rownum; i++) {
			 
			  Row row = sheet.getRow(i);
				
				Cell cell = row.getCell(0);
				
		String links = cell.getStringCellValue();
		
		 System.out.println(links);
			
		}
		 
		
	}

}
