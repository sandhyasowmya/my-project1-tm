package Test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver",".//drivers//geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.google.com");
	
}
}
