package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxHomePage 
{
@FindBy(xpath="((//a[text()='OK'])[2]")private WebElement okButton;
	
	
	@FindBy(xpath="((//a[text()='Close'])[5]")private WebElement closeButton;
	
	
	@FindBy(id="lbl_username")private WebElement userName;
	
	
	@FindBy(id="lbl_curbalancetop")private WebElement balance;
	
	@FindBy(xpath="//span[text()='Logout']")private WebElement logoutButton;
	
	public NeoStoxHomePage(WebDriver driver)
	{
	
	   PageFactory.initElements(driver, this);
	}
	
	
	public void popUpHandle(WebDriver driver)
	
	{
	if(okButton.isDisplayed())
	{
		UtilityNew.wait(driver, 2000);
		 okButton.click();
	UtilityNew.scrollIntoView(driver, closeButton);
	UtilityNew.wait(driver, 2000);    
     closeButton.click();	    
	 Reporter.log("Handeling popup..", true);   
	}
	else    
	{
	   UtilityNew.wait(driver, 10000);
		Reporter.log("There is no popup", true);
	}
	}   
	    public String getUserName()
	{
	
	   String actualUserName =userName.getText();
       Reporter.log("getting user Name", true); 
	   return actualUserName;
	}
	
	public String getBalance(WebDriver driver)
	
	{
	
	UtilityNew.wait(driver, 1000);
	String actualBalance =balance.getText();
	Reporter.log("getting actual balance", true);
	return actualBalance;
	}
	
	public void logoutFromNeoStox(WebDriver driver)
	
	{
	
	  
	UtilityNew.wait(driver, 0);
	   userName.click();
	   
	UtilityNew.wait(driver, 1000);
	   logoutButton.click();
	   Reporter.log("Loggoing out from neoStox", true);
	}

}
