package Common_Methods;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class Util_driver 

{

	 
	 public FileInputStream fis = null;
	 public FileOutputStream fos = null;
	 public HSSFWorkbook workbook = null;
	 public HSSFSheet sheet = null;
     public HSSFRow row = null;
	 public HSSFCell cell = null;
	 
	 
	 
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String browser) {
	try {
		if (browser.equalsIgnoreCase("Firefox")) {
			  System.setProperty("webdriver.gecko.driver",".//drivers//geckodriver.exe");
				driver = new FirefoxDriver();
		  } else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
					driver = new ChromeDriver();
				} 
			}	
			
			 catch (WebDriverException e) {
				System.out.println(e.getMessage());
			}
		
		
			System.out.println("driver=" + driver);
			driver.get("http://172.16.1.129:8000");
			driver.manage().window().maximize();
		}
	
	
  //  @AfterMethod
	public void takescreenshort_close(ITestResult result)
	{
    	
    	
    	if(ITestResult.FAILURE==result.getStatus()){
    			try{
    				
    				TakesScreenshot screenshot=(TakesScreenshot)driver;
    				// Call method to capture screenshot
    				File src=screenshot.getScreenshotAs(OutputType.FILE);
    				// Copy files to specific location 
    				// result.getName() will return name of test case so that screenshot name will be same as test case name
    				FileHandler.copy(src, new File(".//Screenshots//"+result.getName()+".png"));
    				System.out.println("Successfully captured a screenshot");
    			}catch (Exception e){
    				System.out.println("Exception while taking screenshot "+e.getMessage());
    			} 
    	
    	driver.quit();
    	}
			
	} 
	
			public static void waitForXpathPresent(String xpath) {

				WebDriverWait wdriver = new WebDriverWait(driver, 180);
				wdriver.until(ExpectedConditions.elementToBeClickable(By
						.partialLinkText(xpath)));

	}
			
			public static void alertaccept() throws InterruptedException{
				Alert alert = driver.switchTo().alert();		
			    String alertMessage= driver.switchTo().alert().getText();		
			    System.out.println(alertMessage);	
			    Thread.sleep(5000);
			    alert.accept();	
				}
 
			  public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
                  TakesScreenshot scrShot =((TakesScreenshot)webdriver);
                  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                  File DestFile=new File(fileWithPath); 
                  FileHandler.copy(SrcFile, DestFile);
			    }
			   
			  public boolean setCellData(String sheetName, int colNumber, int rowNum, String value) throws IndexOutOfBoundsException, IOException
			    {
				  
			    	 fis = new FileInputStream("D:\\sandhya_Wspace\\tms_script\\Testcases\\Updated_TMS_Testcases.xls");
			         workbook = new HSSFWorkbook(fis);
			         fis.close();
			    	
			    	try
			        {
			            sheet = workbook.getSheet(sheetName);
			            row = sheet.getRow(rowNum);
			            if(row==null)
			                row = sheet.createRow(rowNum);
			 
			            cell = row.getCell(colNumber);
			            if(cell == null)
			                cell = row.createCell(colNumber);
			 
			            cell.setCellValue(value);
			 
			            fos = new FileOutputStream("D:\\sandhya_Wspace\\tms_script\\Testcases\\Updated_TMS_Testcases.xls");
			            workbook.write(fos);
			            fos.close();
			        }
			        catch (Exception ex)
			        {
			            ex.printStackTrace();
			            return  false;
			        }
			        return true;
		    }
			
			  
            public static void generateAlert(WebDriver driver,String message){
            	 JavascriptExecutor js=(JavascriptExecutor) driver;
					js.executeScript("alert('"+message+"')");
            }

            public void ScreenShot(){
       		 
      		  DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
      	      Date date = new Date();
      	     String filename="ScreenShot";
      		  
      		  try{
      			    Thread.sleep(10000);
      		        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
      		        ImageIO.write(image, "jpg", new File("D:\\karthi\\screen\\"+filename+"-"+dateFormat.format(date)+".jpg"));
      		    }
      		    catch(Exception e){
      		        e.printStackTrace();
      		    }
      		}
      	
      	
      

      	public void alertcancel() {
      		Alert alt = driver.switchTo().alert();
      		alt.dismiss();

      	}

      	public String alertMessage() {
      		Alert alt = driver.switchTo().alert();
      		String s1 = alt.getText();
      		System.out.println(s1);
      		return s1;

      	}

      	public void waitPageLoad() {
      		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

      	}

      	
      	public void waitForLinkPresent(String link) {

      		WebDriverWait wdriver = new WebDriverWait(driver, 180);
      		wdriver.until(ExpectedConditions.elementToBeClickable(By.linkText(link)));

      	}

      
      	public void waitForIdPresent(String id) {

      		WebDriverWait wdriver = new WebDriverWait(driver, 180);
      		wdriver.until(ExpectedConditions.elementToBeClickable(By.linkText(id)));

      	}

      	public void waitForNamePresent(String name) {

      		WebDriverWait wdriver = new WebDriverWait(driver, 180);
      		wdriver.until(ExpectedConditions.elementToBeClickable(By.linkText(name)));

      	}
public void scroll(WebElement element) {
      	 Point p=element.getLocation();
		 int xcor=p.getX();
		 int ycor=p.getY();
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy("+xcor+","+ycor+")");
		 element.click();
		 
}
public void scrollpagedown(){
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
}

      	
      	public void verifyTitle(String s1) {
      		String s2 = driver.getTitle();
      		if (s1.equals(s2)) {
      			System.out.println("pass");

      		} else {
      			Assert.fail("fail");
      		}

      	}

      	public void refresh() {
      		driver.navigate().refresh();
      	}

      	
      	public void getWebElementValuebyXpath(String xpath) {
      		String s1 = driver.findElement(By.xpath(xpath)).getAttribute(
      				"value");
      		System.out.println(s1);
      	}

      	
      	public void getWebElementValuebyName(String name) {
      		String s1 = driver.findElement(By.name(name)).getAttribute(
      				"value");
      		System.out.println(s1);
      	}

      	
      	public void getWebElementValuebyId(String id) {
      		String s1 = driver.findElement(By.id(id)).getAttribute("value");
      		System.out.println(s1);
      	}


      	public String getText(String xpath) {
      		String s1 = driver.findElement(By.xpath(xpath)).getText();
      		return s1;
      	}

      	public String getValue(String xpath) {
      		String s1 = driver.findElement(By.xpath(xpath)).getAttribute(
      				"value");
      		return s1;
      	}

      	
      	public void verifyStringvalue(String s1, String s2) {
      		Assert.assertEquals(s1, s2);
      	}

      	
      	 
      	public void verifyStringvalue(String s1, String s2, String msg) {
      		Assert.assertEquals(s1, s2, msg);
      	}

    
      	public void verifyIntvalue(int a1, int a2, String msg) {
      		Assert.assertEquals(a1, a2, msg);
      	}

      	
      	public void verifyBooleanvalue(Boolean b1, Boolean b2, String msg) {
      		Assert.assertEquals(b1, b2, msg);
      	}

      	
      	
}	


