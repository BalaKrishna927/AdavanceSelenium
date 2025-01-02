package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		
		  Driver driverref = new Driver();
		  
		  DriverManager.registerDriver(driverref);
		  
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinform");
	
		 Statement statement = conn.createStatement();
		 
		 
		 String query = "select*from studentinform";
		ResultSet result = statement.executeQuery(query);
		
	
		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
			
		}
		 
	}

}
