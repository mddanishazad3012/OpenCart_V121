package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationForm;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression", "Master"})
	public void verify_Account_Reg() throws InterruptedException 
	{
		try 
		{
			logger.info("******** Home Page Validation Starts ********");
			HomePage hp = new HomePage(driver);
			hp.ClickOnMyAccount();
			hp.ClickOnRegister();
			Thread.sleep(3000);
			logger.info("******** Home Page Validation Ends ********");
			logger.info("******** Registration Page Validation Starts ********");
			AccountRegistrationForm accreg = new AccountRegistrationForm(driver);
			accreg.setFirstName(randomString());
			accreg.setLastName(randomString());
			accreg.setEmail(randomString() + "@gmail.com");
			accreg.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			accreg.setPassword(password);
			accreg.setConfirmPassword(password);
			accreg.setPrivacyPolicy();
			accreg.ClickOnContinue();
			logger.info("******** Confirm Message Validation ********");
			String confirmMsg = accreg.getConfirmMsg();
			Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
			logger.info("******** Home Page Validation Ends ********");
		} 
		catch (Exception e) 
		{
			logger.error("Test Case Falied..");
			logger.debug("Debug logs");
			Assert.fail();
		}
	}

}
