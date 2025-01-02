package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class Exell_Utility {
	
	private static final String IPathConstant = null;

	public String getexell(String sheetname , int rownum , int cellnum) throws Throwable {
		FileInputStream fis1 = new FileInputStream(Paths.Ecxelpath);

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);
		
	  Sheet sheet = book.getSheet(sheetname);
	  	  Row row = sheet.getRow(rownum);
		
	     org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);
	   
   String data = cell.getStringCellValue() ;
	System.out.println(data);
	return data ;
	
	/*public Object[][] readtheDataprovider(String sheetname) throws EncryptedDocumentException, IOException{
		FileInputStream fis2 = new FileInputStream(Paths.Ecxelpath);

		// step2:- keep the File in read mode
		 Workbook book1 = WorkbookFactory.create(fis2);
		
	  Sheet sheet1 = book1.getSheet(sheetname);
	  
	  int lastrow = sheet1.getLastRowNum()+1;
	  
 	 int lastcell = sheet1.getRow(0).getLastCellNum();
 	 
 	 Object[][] objtr = new Object[lastrow][lastcell];
 	 for (int i = 0; i < lastrow; i++) {
 		for (int j = 0; j < lastcell; j++) {
 		objtr[i][j]=sheet1.getRow(i).getCell(j).toString();
	}
 	 }
 	 
 	 //return objtr;*/
	  
		
	}

	public String readDataFromExcelUsingDataProvider(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/DataExcel.xlsx");

		// step2:- keep workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigates into particular sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- Navigates into particular Row
		Row row = sheet.getRow(rowNum);

		// step5:-Navigates into particular cell

	       org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		System.out.println(data);
		return data;
		
	}
	}


