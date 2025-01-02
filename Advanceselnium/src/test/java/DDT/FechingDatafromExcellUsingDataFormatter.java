package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FechingDatafromExcellUsingDataFormatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
FileInputStream file = new FileInputStream("./src/test/resources/DataExcel.xlsx");
		
		Workbook book = WorkbookFactory.create(file);
		
       
		Sheet sheet = book.getSheet("Sheet2");
		 
		  Row row = sheet.getRow(0);
			
			Cell cell = row.getCell(0);
	        DataFormatter formatdata = new DataFormatter();
		
	      String excell = formatdata.formatCellValue(cell);
	      System.out.println(excell);
	}

}
