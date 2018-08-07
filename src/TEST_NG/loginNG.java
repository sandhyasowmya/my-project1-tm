package TEST_NG;

import java.io.IOException;
import java.util.ResourceBundle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Common_Methods.Util_driver;

import Test_cases.LoginPage;
import Test_cases.admin;

public class loginNG  extends Util_driver {

		static ResourceBundle sup=ResourceBundle.getBundle("loginpage");
		LoginPage pge = new LoginPage();
		
		admin ad = new admin();
		
		@Test(priority = 0)
		public void method() throws IOException, InterruptedException 
		{
			
				Thread.sleep(1000);
		if(driver.findElement(By.xpath(sup.getString("Login_screen"))).isDisplayed())
			{
              setCellData("Login", 14, 5, "Pass");
               System.out.println("Switched to URL");
			     }
			     else{
			    	setCellData("Login", 14, 5, "Fail");
			    	 System.out.println("Failed to Switch");
			     }
			
		 if(driver.findElement(By.xpath(sup.getString("ele_in_loginScreen"))).isDisplayed()){
			setCellData("Login", 14, 6, "Pass");
			 System.out.println("LOGO and company name is present");
	     }
	     else{
	    	 setCellData("Login", 14, 6, "Fail");
	    	 System.out.println("LOGO and company name is not present");
	     } 
		 driver.findElement(By.xpath(sup.getString("Submit"))).click();
		 setCellData("Login", 14,9 , "Pass");
		 alertaccept();
		 
		 Thread.sleep(2000);
		  pge.loginmeth(sup.getString("invalid_user"), sup.getString("invalid_pass"));
		 
		   Thread.sleep(1000);
		  Alert alert = driver.switchTo().alert();		
	        String alertMessage= driver.switchTo().alert().getText();		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        alert.accept();	
	      if(alertMessage != null )
	      {
	        setCellData("Login", 14,11 , "Pass");
	      }
	     else{
	    	setCellData("Login", 14, 11, "Fail");
	         }
	   
	   pge.elementpresent(sup.getString("Verify_invalid"));
	       
	  
	   driver.navigate().refresh();
    
	   pge.loginmeth("", "");
	   
		  
	   System.out.println("Empty Credentials");
	   Alert alert2 = driver.switchTo().alert();		
       String alertMessage2= driver.switchTo().alert().getText();		
       System.out.println(alertMessage2);	
      Thread.sleep(5000);
      alert2.accept();	
      if(alertMessage2 != null )
      {
       setCellData("Login", 14,13 , "Pass");
      }
     else{
    	setCellData("Login", 14, 13, "Fail");
         }
      pge.elementpresent(sup.getString("Verify_Empty"));
      driver.navigate().refresh();
      Thread.sleep(2000);
      pge.loginmeth(sup.getString("Login_HR"), "");
      Alert alert3 = driver.switchTo().alert();		
      String alertMessage3= driver.switchTo().alert().getText();		
      System.out.println(alertMessage3);	
      Thread.sleep(5000);
      alert3.accept();	
      if(alertMessage3 != null )
      {
       setCellData("Login", 14,14 , "Pass");
      }
       else{
	        setCellData("Login", 14, 14, "Fail");
           }
      driver.navigate().refresh();
      
      pge.loginmeth("", sup.getString("pass_HR"));
      Alert alert4 = driver.switchTo().alert();		
      String alertMessage4= driver.switchTo().alert().getText();		
      System.out.println(alertMessage4);	
      Thread.sleep(5000);
      alert4.accept();	
      if(alertMessage4 != null )
        {
       setCellData("Login", 14,15 , "Pass");
        }
         else{
              setCellData("Login", 14, 15, "Fail");
             }
  
      driver.navigate().refresh();
		
		  pge.loginmeth(sup.getString("Login_HR"), sup.getString("pass_HR"));
		  
		  pge.elementpresent(sup.getString("Verify_HR"));
	      System.out.println("HR login");
	      Thread.sleep(1000);
	   if(driver.findElement(By.xpath(sup.getString("Verify_HR"))).isDisplayed()){
	      
	 
	  setCellData("Login", 14,10 , "Pass");
	     }
	     else{
	   	setCellData("Login", 14, 10, "Fail");
	     }

	} 
	     	 
	}
	 




