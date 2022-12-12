package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;


public class BaseNew 
{
	 protected WebDriver driver;
	 public void launchBrowser() throws IOException
	 {
	
	   System.setProperty("webdriver.chrome.driver", "E:\\Software\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.get(UtilityNew.readDataFromPropertyFile("URL"));
	driver.manage().window().minimize();
	Reporter.log("Launching browser",true);
	
	UtilityNew.wait(driver, 1000);
	 }
	  public static void closingBrowser(WebDriver driver) throws InterruptedException
	 
	  {
	     Reporter.log("closing browser", true);
	 
	 Thread.sleep(500);
	driver.close();
	  }
}
