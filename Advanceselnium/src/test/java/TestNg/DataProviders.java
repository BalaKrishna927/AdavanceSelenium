package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	@Test(dataProvider = "getdata")
	public void booktickets(String src , String dests , int num) {
		
		System.out.println("Book tickets for   "+src+"to"+dests+" , "+num);
		
	}
	@DataProvider
	
	public Object[][] getdata()
	{
		Object[][] objct = new Object[3][3];
		
		objct[0][0]= "HYderabad";
		objct[0][1]= "Goa";
		objct[0][2]=3;
				
				
		objct[1][0]= "HYderabad";
		objct[1][1]= "Delhi";
		objct[1][2]=4;
		
		objct[2][0]= "HYderabad";
		objct[2][1]= "pune";
		objct[2][2]=5;
		return objct;
	
	}
}
