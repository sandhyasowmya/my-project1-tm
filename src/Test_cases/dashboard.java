package Test_cases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class dashboard  {

	
	public static WebDriver driver;
	   @BeforeTest
		public static void methodurl() throws InterruptedException
		{
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://172.16.1.148:8000");
		Thread.sleep(1000);
		
		driver.findElement(By.id("Username")).sendKeys("Indrashekargr");
		
		driver.findElement(By.id("password")).sendKeys("sGr81kDn");
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div/div/form/button")).click();
		}

	
	
	
	
	@Test(priority=1)
	public void spreadSheetTest() throws InterruptedException{
		
		Thread.sleep(30000);
		
		String outerIFrame="https://app.powerbi.com/view?r=eyJrIjoiZmI1YTYyN2ItYzRjYy00M2FlLTliMTgtYjM5NjVhYjMyMjczIiwidCI6IjY2N2E5YmIxLWQ3NjMtNDY2NC05NDQ1LTAxNDMwNTdiNGQ5NSJ9";
//		resdriver.switchTo().defaultContent();
		// resdriver.switchTo().frame(0);
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='"+outerIFrame+"']")));
		System.out.println("Outer frame switched!");
		
		Thread.sleep(2000);
		
		int FrameSize= driver.findElements(By.tagName("iframe")).size();
		System.out.println("Frame size: "+FrameSize);
		
		Thread.sleep(2000);
		
//		resdriver.findElement(By.xpath("//div[contains(text(),'All')]")).click();
		
		driver.findElement(By.xpath("//input[@name='search-field']")).click();
		
		String innerFrame="https://app.powerbi.com/13.0.4829.178/visualSandboxMinimal.html?plugin=textFilter25A4896A83E0487089E2B90C9AE57C8A&locale=en-US&instanceId=d14d9ef0-629d-51c7-162b-ba48baf8f328";
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='"+innerFrame+"']")));
		System.out.println("Innner frame switched!");
		
		
		Thread.sleep(2000);
		
		WebElement available_item=driver.findElement(By.xpath("//input[@name='search-field']"));
		available_item.sendKeys("13268");
		if(available_item.isDisplayed()){
			System.out.println("Item is present");
		}else
		{
			System.out.println("Item is not present");
		}
		
		available_item.click();
		
	}
	
	}
	
