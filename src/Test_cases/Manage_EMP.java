package Test_cases;



import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

import Common_Methods.Util_driver;



	public class Manage_EMP extends Util_driver{

		
			 public ResourceBundle resbun = ResourceBundle.getBundle("loginpage");
			 public ResourceBundle resbun1 = ResourceBundle.getBundle("Manage_emp");
			 LoginPage pge = new LoginPage();
			
			 public void search() throws InterruptedException{
				 
				 WebDriverWait wait=new WebDriverWait(driver, 20);
				 
				 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(resbun1.getString("editskills"))));
				  
				driver.findElement(By.xpath(resbun1.getString("editskills"))).click(); 
				
				
					Thread.sleep(4000);
				
				Select o = new Select(driver.findElement(By.xpath(resbun1.getString("category"))));
				Thread.sleep(2000);
				o.selectByIndex(8);
				Select a = new Select(driver.findElement(By.xpath(resbun1.getString("skills"))));
				Thread.sleep(2000);
				a.selectByIndex(1);
				Select b = new Select(driver.findElement(By.xpath(resbun1.getString("rating"))));
				Thread.sleep(2000);
				b.selectByIndex(1);
				Select c = new Select(driver.findElement(By.xpath(resbun1.getString("availability"))));
				Thread.sleep(2000);
				c.selectByIndex(2);
		    	driver.findElement(By.xpath(resbun1.getString("search"))).click(); 
		    	
			 
			 }
			 
			 public void Edit_profile() throws InterruptedException
			 {
				 Thread.sleep(1000);
				 WebElement element1 = driver.findElement(By.xpath("//td[contains(text(),'13133')]/..//img[@ng-click='editEmployee(user.EmployeeId)']"));

				 if(element1.isDisplayed()){
					 
					 System.out.println("Element is present in view");
					 
				 }else{
					 System.out.println("Element is not present in view");
				 }
				 
				 Thread.sleep(2000);
				 scroll(element1);
				 Select I = new Select(driver.findElement(By.xpath(resbun1.getString("Avail"))));
				 I.selectByIndex(3);
				 Thread.sleep(1000);
				 driver.findElement(By.xpath(resbun1.getString("update"))).click(); 
				 Thread.sleep(2000);
				  alertaccept();
				  }
			 
			 public void search_Key()
			 {
				// waitForXpathPresent(resbun1.getString("search_key"));
				 driver.findElement(By.xpath(resbun1.getString("search_key"))).sendKeys("13133");
				String SRC= pge.elementpresent(resbun1.getString("search_key_element"));
				 System.out.println(SRC);
			 }
			 
			 
			 public void projectTrackig(String xpath1) throws InterruptedException
			 {
				 Thread.sleep(1000);
				 WebElement element = driver.findElement(By.xpath(xpath1));
//				 ((JavascriptExecutor) resdriver).executeScript("arguments[0].", element);
				 if(element.isDisplayed()){
					 
					 System.out.println("Elemnet is present in view");
					 
				 }else{
					 System.out.println("Element is not present in view.");
				 }
				 
				 Thread.sleep(3000);
				 Point p=element.getLocation();
				 int xcor=p.getX();
				 int ycor=p.getY();
				 JavascriptExecutor js=(JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy("+xcor+","+ycor+")");
				 Thread.sleep(2000);
				 element.click();
				 Thread.sleep(1000);
				 driver.findElement(By.xpath(resbun1.getString("plus"))).click();
			 driver.findElement(By.xpath(resbun1.getString("project_name_element"))).sendKeys(resbun1.getString("projectName"));
				 driver.findElement(By.xpath(resbun1.getString("company_element"))).sendKeys(resbun1.getString("companyName"));				 
				 Thread.sleep(2000);
				 driver.findElement(By.xpath(resbun1.getString("startdate_element"))).sendKeys(resbun1.getString("startdate"));
//				String date = "10-june-2015";
//				String splitarry[]=date.split("-");
//				String month_year=splitarry[1];
//				String day = splitarry[0];
				
		//		 Select SA = new Select(resdriver.findElement(By.xpath(resbun1.getString("status_Project"))));
			//	 SA.selectByIndex(3);
				 Thread.sleep(1000);
				 driver.findElement(By.xpath(resbun1.getString("add_project"))).click();
				 Thread.sleep(1000);
				 
				     Alert alert = driver.switchTo().alert();		
			        String alertMessage= driver.switchTo().alert().getText();		
			        System.out.println(alertMessage);	
		        Thread.sleep(5000);
			        alert.accept();	
			        Thread.sleep(1000);
			        
				 //Update project details
				 
			 }
			/* String dateval = "30-12-2014";
				 public static void selectdateJS (WebDriver driver,WebElement element1,String dateval){
					 JavascriptExecutor js=(JavascriptExecutor) driver;
					js.executeScript("arguments[0].setAttribute('value','+dateval+');",element1);
				 }
				 */
			 
			 //More Skill
			 public void More_skills() throws InterruptedException
	         {
				 WebElement element1 = driver.findElement(By.xpath("//td[text()='13133']/..//a[@ng-click='skillUpdate(user.UserId,user.EmployeeId,user.FirstName,user.LastName,user.RoleID)']"));
			// ((JavascriptExecutor) resdriver).executeScript("arguments[0].", element1);
				 if(element1.isDisplayed()){
					 
					 System.out.println("Skills is present in view");
					 
				 }else{
					 System.out.println("Skills not present in view.");
				 }
				 
				 Thread.sleep(3000);
				 Point p=element1.getLocation();
				 int xcor=p.getX();
				 int ycor=p.getY();
				 JavascriptExecutor js=(JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy("+xcor+","+ycor+")");
				 Thread.sleep(2000);
				 element1.click();
				 Thread.sleep(1000);
	         
			
			
			 
//To Add Skills
			
		
				driver.findElement(By.xpath(resbun1.getString("addnewskill"))).click();
				 Select Cat = new Select(driver.findElement(By.xpath(resbun1.getString("add_category"))));
				 Cat.selectByVisibleText("Domain");;
				 Select skil = new Select(driver.findElement(By.xpath(resbun1.getString("add_skills"))));
				 skil.selectByVisibleText("L2 Support");
				 Select Rating = new Select(driver.findElement(By.xpath(resbun1.getString("add_rating"))));
				 Rating.selectByIndex(3);
				 driver.findElement(By.xpath(resbun1.getString("click_add"))).click();
				 Thread.sleep(500);
				 Alert alert = driver.switchTo().alert();		
			        String alertMessage= driver.switchTo().alert().getText();		
			        System.out.println(alertMessage);	
			        Thread.sleep(5000);
			        alert.accept();	
			        Thread.sleep(1000);
			   //To delete skill   
			        
			       WebElement del = driver.findElement(By.xpath(resbun1.getString("delete_skill")));
			       Thread.sleep(3000);
					 Point p1=del.getLocation();
					 int xcord=p1.getX();
					 int ycord=p1.getY();
					 JavascriptExecutor js1=(JavascriptExecutor) driver;
					 js.executeScript("window.scrollBy("+xcor+","+ycor+")");
					 Thread.sleep(2000);
					 del.click(); 
					 Thread.sleep(1000);
					 Alert alert1 = driver.switchTo().alert();		
				        String alertMessage1= driver.switchTo().alert().getText();		
				        System.out.println(alertMessage1);	
				        Thread.sleep(5000);
				        alert1.accept();	
				      //  System.out.println("Successfully Deleted 'Domain' Skill");
				        Thread.sleep(1000);
				        alertaccept();
			       driver.findElement(By.xpath(resbun1.getString("Close_X"))).click();
			       Actions action = new Actions(driver);
				   	 action.sendKeys(Keys.ESCAPE).build().perform();
	         }
		       
			    
			//edit profile status for BU Head and Reporting Head
			public void Editprofile_status(String xpath) throws InterruptedException{
				 WebElement element1 = driver.findElement(By.xpath(xpath));

				 if(element1.isDisplayed()){
					 
					 System.out.println("Element is present in view");
					 
				 }else{
					 System.out.println("Element is not present in view");
				 }
				 element1.click();
				 Select I = new Select(driver.findElement(By.xpath("//select[@ng-change='statusChange(employee.Availability)']")));
				 I.selectByIndex(1);
				 Thread.sleep(1000);
				 driver.findElement(By.xpath("//button[@ng-click='updateEmployeeStatus(employee.EmployeeId,employee.Availability)']")).click(); 
				 Thread.sleep(2000);
			  alertaccept();
				  }
			}
			
			 
			       
				 
	        
			
	


