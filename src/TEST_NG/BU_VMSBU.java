package TEST_NG;

import static org.testng.Assert.assertTrue;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common_Methods.Util_driver;
import Test_cases.LoginPage;
import Test_cases.Manage_EMP;
import Test_cases.databasetesting;

public class BU_VMSBU extends Util_driver{

	static ResourceBundle sup=ResourceBundle.getBundle("loginpage");
	static ResourceBundle sup1 =ResourceBundle.getBundle("Manage_emp");
	LoginPage pge = new LoginPage();
	Manage_EMP RS = new Manage_EMP();
	databasetesting db = new databasetesting();
	 
	@Test(priority=6)
	public void BU_Head() throws Exception{	
	     Thread.sleep(1000);
	   
	     pge.loginmeth(sup.getString("Login_BU"),sup.getString("pass_BU"));
	     Thread.sleep(2000);
	     System.out.println("BU Head Login Succesfully");
         RS.search();
	     driver.findElement(By.xpath(sup1.getString("Refresh_Buhead"))).click();
		 System.out.println("Search functionality pass");		
 
		
		// System.out.println(SRC);
       
     //    RS.More_skills();
         String UIcount ="109"; 
	     String databaseCount = db.setUp("SELECT Distinct count(EmployeeID) FROM testtms.employeemaster where Branch = 'IMSSPL' and IsDeleted=0 and empStatus = 'Active' and buid=13");
		   System.out.print("VMSBU Total Emp count in database:");
		   System.out.println(databaseCount);
		   System.out.print("VMSBU Total Emp count in Application:");
		   System.out.println(UIcount);
		   if(UIcount!=databaseCount){
			   System.out.println("Emp count matched with Database count");
		   } else{
				   System.out.println("Emp count mismatch");  
			   }
}
	

@Test(priority=7)
public void project_BU() throws InterruptedException{
    RS.projectTrackig(sup1.getString("projecttracking_sathya"));
	// Thread.sleep(1000);
	 // driver.findElement(By.xpath(sup1.getString("projecttracking_sathya"))).click();
 //   driver.findElement(By.xpath(sup1.getString("action_sathya"))).click();
  //    driver.findElement(By.xpath(sup1.getString("end_element"))).sendKeys(sup1.getString("endDate"));
  //     Thread.sleep(1000);
  //     driver.findElement(By.xpath(sup1.getString("update_sathya"))).click();
   //    alertaccept();
    //  pge.elementpresent(sup1.getString("verify_res_ele"));
	 Thread.sleep(2000);
//	 RS.Editprofile_status(sup1.getString("editstats_10757"));
	
    
	 driver.findElement(By.xpath(sup1.getString("closebutton"))).click();
      
       Actions action = new Actions(driver);
  	 action.sendKeys(Keys.ESCAPE).build().perform();
    //Thread.sleep(1000);
  	 driver.findElement(By.xpath(sup1.getString("search_key"))).sendKeys("13275");
		String SRC= pge.elementpresent(sup1.getString("search_key_element"));
}	

}