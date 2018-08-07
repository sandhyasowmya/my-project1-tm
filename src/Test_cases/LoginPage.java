package Test_cases;


import java.io.IOException;
import java.util.ResourceBundle;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Common_Methods.G_Driver;
import Common_Methods.Util_driver;


public class LoginPage extends Util_driver {
		
public  ResourceBundle resbun= ResourceBundle.getBundle("loginpage");


	

public void loginmeth(String user,String pass) throws InterruptedException{
		      
		 Thread.sleep(1000);
		
		driver.findElement(By.id(resbun.getString("user_element"))).sendKeys(user);
		
		driver.findElement(By.id(resbun.getString("pass_element"))).sendKeys(pass);
		
			Thread.sleep(2000);
		
		driver.findElement(By.xpath(resbun.getString("Submit"))).click();
		 
		
		}
   public String elementpresent(String xpath){
   
   	java.util.List<WebElement> list = driver.findElements(By.partialLinkText(xpath));
   	
   	int check=list.size();
   	if(check==0){
   		 
   		System.out.println("Element Present");
   		System.out.println("testcase pass");
   	}else{
   			System.out.println("Element Absent");
   		System.out.println("testcase failed");
   		}
	return xpath;
   	}
   	
   
  
public void login_validzzzz() throws InterruptedException{
	 
	loginmeth(resbun.getString("Login_HR"), resbun.getString("pass_HR"));
}

	
}


 




