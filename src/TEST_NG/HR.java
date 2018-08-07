package TEST_NG;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Common_Methods.Util_driver;
import Test_cases.LoginPage;
import Test_cases.Manage_EMP;

public class HR extends Util_driver {
	static ResourceBundle sup=ResourceBundle.getBundle("loginpage");
	static ResourceBundle sup1 =ResourceBundle.getBundle("Manage_emp");
	LoginPage pge = new LoginPage();
	Manage_EMP RS = new Manage_EMP();
	
	@Test(priority=4)
	public void HR_Roles() throws InterruptedException{
	     pge.loginmeth(sup.getString("Login_HR"), sup.getString("pass_HR"));
         RS.search();
         pge.elementpresent(sup1.getString("verify_res_ele"));
		 driver.findElement(By.xpath(sup1.getString("Refresh"))).click();
		 System.out.println("Search functionality pass");

		 RS.Edit_profile();
		 RS.search_Key();
		 RS.More_skills();
	}
	@Test(priority=5)
	public void project_tract() throws InterruptedException{
		 RS.projectTrackig(sup1.getString("projecttracking_indra"));
		 
		
	//	 driver.findElement(By.xpath(sup1.getString("action_13133"))).click();
//	       driver.findElement(By.xpath(sup1.getString("end_element"))).sendKeys(sup1.getString("endDate"));
//	        Thread.sleep(1000);
	   //     driver.findElement(By.xpath(sup1.getString("update_13133"))).click();
	       // alertaccept();
		 driver.findElement(By.xpath(sup1.getString("closebutton"))).click();
		 Actions act = new Actions(driver);
		 act.sendKeys(Keys.ESCAPE).build().perform();
	}
	   //  Thread.sleep(1000);
		 
	 }
  

