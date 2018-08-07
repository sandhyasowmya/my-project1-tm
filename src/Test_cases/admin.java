package Test_cases;

import java.util.ResourceBundle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import Common_Methods.Util_driver;

public class admin extends  Util_driver{

	static ResourceBundle sup=ResourceBundle.getBundle("admin");
	
	public void Adminroles() throws InterruptedException{
		driver.findElement(By.xpath(sup.getString("Admin_element"))).click();
		driver.findElement(By.xpath(sup.getString("skillmaster"))).click();
		driver.findElement(By.xpath(sup.getString("add_skillcategory"))).click();
	    driver.findElement(By.xpath(sup.getString("categoryname_text"))).sendKeys("selenium");
		driver.findElement(By.xpath(sup.getString("description"))).sendKeys("Selenium webdriver or RC");
		driver.findElement(By.xpath(sup.getString("Submitcategory"))).click();
		 Alert alert = driver.switchTo().alert();		
	        String alertMessage= driver.switchTo().alert().getText();		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        alert.accept();	
	        Thread.sleep(5000);
		driver.findElement(By.xpath(sup.getString("update_selenium"))).click();
	
		driver.findElement(By.xpath(sup.getString("editskil_categoryname"))).sendKeys("1");
		driver.findElement(By.xpath(sup.getString("editdescription"))).sendKeys("1");
		driver.findElement(By.xpath(sup.getString("updateskills"))).click();
		 Alert alert1 = driver.switchTo().alert();		
	        String alertMessage1= driver.switchTo().alert().getText();		
	        System.out.println(alertMessage1);	
	        Thread.sleep(5000);
	        alert1.accept();	
		
	}
}
