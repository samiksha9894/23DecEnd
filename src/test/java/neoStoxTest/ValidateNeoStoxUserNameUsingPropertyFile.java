package neoStoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase.BaseNew;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignLogin;
import neoStoxUtility.UtilityNew;


public class ValidateNeoStoxUserNameUsingPropertyFile extends BaseNew{


		NeoStoxSignLogin login;
		NeoStoxPasswordPage password;
		NeoStoxHomePage home;

		@BeforeClass
		public void launchNeoStox() throws IOException
		{

		    launchBrowser();

		   login= new NeoStoxSignLogin(driver);
		   password = new NeoStoxPasswordPage(driver);
		   home = new NeoStoxHomePage(driver);
		   
		}  
		   
		 @BeforeMethod  
		   
		   public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
		   
		   { 
		   
		   
		   login.sendMobileNum(driver, UtilityNew.readDataFromPropertyFile("mobileNum"));
		   login.clickOnSignButton(driver);
		   Thread.sleep(2000);
		   password.sendPassword(driver,UtilityNew.readDataFromPropertyFile("password"));
		   password.clickOnSubmitButton(driver);
		   Thread.sleep(2000);
		   home.popUpHandle(driver);
		   
		   }
		   @Test
		public void validateUserName() throws EncryptedDocumentException, IOException {

		Assert.assertEquals(home.getUserName(), UtilityNew.readDataFromPropertyFile("userName"));   
		 UtilityNew.takeScreenShot(driver, home.getUserName());  
		   }
		   
		   @Test
		   public void validateACBalance()
		   {
		   Assert.assertNotNull(home.getBalance(driver));
		   Reporter.log("AC balance is"+home.getBalance(driver), true);
		   
		   
		   
		   }
		 @AfterMethod
		   public void logout()
		   
		   {
		   
		   home.logoutFromNeoStox(driver);
		   
		   }
		   
		@AfterClass
		 public void closeApplication() throws InterruptedException
		 {
		 
		 closingBrowser(driver);
		   
}
}