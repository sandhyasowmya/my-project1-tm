package Common_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class G_Driver {

		
			public static WebDriver driver;
				
				
		/*		public static void methodurl()
				{
//					org.openqa.selenium.remote.DesiredCapabilities cap = new org.openqa.selenium.remote.DesiredCapabilities();
//					cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//					System.setProperty("webdriver.gecko.driver",".//drivers//geckodriver.exe");
//				
//			FirefoxOptions fireopt=new FirefoxOptions(cap);
//					
//					driver = new FirefoxDriver(fireopt);
//               System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
				
				
//				 driver = new ChromeDriver();                    
			
				
				 System.setProperty("webdriver.gecko.driver","D:\\selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
					driver = new FirefoxDriver();
					// driver.manage().window().maximize();
				} */
			  @BeforeClass
				@Parameters("browser")
				public void openBrowser(String browser) {
					try {
						if (browser.equalsIgnoreCase("Firefox")) {
							System.setProperty("webdriver.gecko.driver",".//drivers//geckodriver.exe");
							driver = new FirefoxDriver();
						} else if (browser.equalsIgnoreCase("chrome")) {
							System.setProperty("webdriver.chrome.driver",
									".//drivers//chromedriver.exe");
							driver = new ChromeDriver();
						} else if (browser.equalsIgnoreCase("IE")) {
							

							System.setProperty("webdriver.ie.driver",
									".//drivers//IEDriverServer.exe");
							driver = new InternetExplorerDriver();
						}
					
					} catch (WebDriverException e) {
						System.out.println(e.getMessage());
					}

				}
}