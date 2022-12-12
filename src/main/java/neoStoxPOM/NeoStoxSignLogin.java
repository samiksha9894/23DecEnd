package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxSignLogin 
{
@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement mobileNumField;
	
	@FindBy(xpath="//a[@id='lnk_signup1']")private WebElement signInButton;
	
	public NeoStoxSignLogin(WebDriver driver)
	
	{
	     PageFactory.initElements(driver, this);
		
	}
		
		public void sendMobileNum(WebDriver driver,String mobileNum)
		{
		
		UtilityNew.wait(driver, 1000);	
		mobileNumField.sendKeys(mobileNum);	
		Reporter.log("sending mobile number..",true);	
			
		}	
			
		public void clickOnSignButton(WebDriver driver)	
		{	
	
		     UtilityNew.wait(driver, 1000);
             signInButton.click();
             Reporter.log("clicking on sign in Button", true);


}
}