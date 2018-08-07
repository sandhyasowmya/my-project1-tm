package Test_cases;

	
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



import java.sql.*;

		public class databasetesting  {

			 
				static WebDriver driver;
				 @Test
			   public String setUp(String sqlQ ) throws Exception {
			 
				Connection conn = null;
				String dbUrl = "jdbc:mysql://172.16.1.148:3306/testtms";					
	           
				String username = "root";	
		     	String password = "root";				
			   
		     	try{
		     		Class.forName("com.mysql.jdbc.Driver");	
		     		conn = DriverManager.getConnection(dbUrl, username, password);
		     		System.out.println("connected......");
		     	
		     		java.sql.Statement state = conn.createStatement();
		     		
		     		ResultSet result1 = state.executeQuery(sqlQ);
		     	
		     		
		     			     		
		     		 while (result1.next()){ 
		     		String Enterprise = result1.getString("Count(EmployeeId)");
		     		
	    			 return Enterprise;
		     		 }
		     		 
		     	
		     	} 
		     
		     	
		     	catch(Exception e){
		     		System.out.println(e);
		     	}
		     	if (conn != null) 
		     	{
		     		try 
		     		{
		     			conn.close();
		     		} 
		     		catch (Exception e)
		     		{
		     			}
		     		}
				return sqlQ;
				 }
		}
		