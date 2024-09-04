package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_VerifyLogin extends BaseClass {

	@Test(groups= {"Sanity", "Master"})
	public void verify_Login() 
	{
		logger.info("**** Starting TC_002_LoginPage_Validation ****");
		try {
			
			logger.info("** Clicking On Login **");
			HomePage hm = new HomePage(driver);
			hm.ClickOnMyAccount();
			hm.ClickOnLogin();
			Thread.sleep(3000);

			logger.info(" ** Login Validation Starts ** ");
			LoginPage lp = new LoginPage(driver);
			lp.txtUserName(p.getProperty("email"));
			lp.txtPassword(p.getProperty("password"));
			lp.ClickOnLogin();

			logger.info("Msg My Account Validation");
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.IsMyAccountHeaderExist();
			Assert.assertEquals(targetPage, true, "My Account");
//			Assert.assertTrue(targetPage);
			macc.ClickOnLogout();
		} catch (Exception e) 
		{
			Assert.fail();
		}
		logger.info("**** Finished TC_002_LoginPage_Validation ****");
	}
}
