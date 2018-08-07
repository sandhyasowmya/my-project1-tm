package TEST_NG;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Common_Methods.Util_driver;
import Test_cases.LoginPage;
import Test_cases.Manage_EMP;
import Test_cases.databasetesting;

public class COO extends Util_driver {
	static ResourceBundle sup=ResourceBundle.getBundle("loginpage");
	static ResourceBundle sup1 =ResourceBundle.getBundle("Manage_emp");
	LoginPage pge = new LoginPage();
	Manage_EMP RS = new Manage_EMP();
	databasetesting db = new databasetesting();
	
	@Test
	public void coo_credentials() throws Exception{
		
//	databasetesting.setUp();
		
	Thread.sleep(2000);	
	 pge.loginmeth(sup.getString("Login_COO"),sup.getString("pass_COO"));
	 Thread.sleep(2000);	
     RS.search();
     pge.elementpresent(sup1.getString("verify_res_ele"));
	 driver.findElement(By.xpath(sup1.getString("Refresh"))).click();
	 System.out.println("Search functionality pass");
	 Thread.sleep(2000);	
	 driver.findElement(By.xpath(sup1.getString("coo_profiletracking"))).click();
	Thread.sleep(1000);
	 if(driver.findElement(By.xpath(sup1.getString("coo_profileclick_verify"))).isDisplayed()){
		 System.out.println("Profile tracting popup displayed");
	 } else{
			 System.out.println("Profile tracting popup NOT displayed") ;
		 }
	 Thread.sleep(1000);
	 Actions action = new Actions(driver);
	 action.sendKeys(Keys.ESCAPE).build().perform();
	 
	// driver.findElement(By.xpath(sup1.getString("coo_trackingprofile_close"))).click();
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath(sup1.getString("search_key"))).sendKeys("13133");
		boolean SRC;
		if( SRC = pge.elementpresent(sup1.getString("search_key_element")) != null){
		 System.out.println(SRC);
		}
		else{
			 System.out.println("Search fuctionality doesnot work");
		} 
		String UIcount ="249";
	 String databaseCount = db.setUp("SELECT Distinct count(EmployeeID) FROM testtms.employeemaster where Branch = 'IMSSPL' and IsDeleted=0 and empStatus = 'Active'and length(employeemaster.EmployeeId) > 4 ");
	   System.out.print("Total Emp count in database:");
	   System.out.println(databaseCount);
	   System.out.print("Total Emp count in Application:");
	   System.out.println(UIcount);
	   if(UIcount!=databaseCount){
		   System.out.println("Emp count matched with Database count");
	   } else{
			   System.out.println("Emp count mismatch");  
		   }
	   
	  
	}
		
	}

