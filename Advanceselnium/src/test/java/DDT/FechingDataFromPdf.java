package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FechingDataFromPdf {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 File file = new File("./src/test/resources/SQL_PPT.pdf");
		 
	PDDocument	doc = PDDocument.load(file);  
	
	 int pages = doc.getNumberOfPages();
	 
	// System.out.println(pages);
	 
	PDFTextStripper pdfdata = new PDFTextStripper();
	
//	String readdata = pdfdata.getText(doc);
	
	//System.out.println(readdata);
	
	//pdfdata.setStartPage(5);
	
	//String Singlepage = pdfdata.getText(doc);
	
//	System.out.println(Singlepage);
	
	pdfdata.setStartPage(5);
	pdfdata.setEndPage(5);
	String Singlepage = pdfdata.getText(doc);
	System.out.println(Singlepage);
	
	
	 
	 
	}

}
