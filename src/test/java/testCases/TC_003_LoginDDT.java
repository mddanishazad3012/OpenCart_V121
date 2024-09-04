package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups= {"Datadriven", "Master"})
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException 
	{
		try 
		{
			logger.info("** Clicking On Login **");
			HomePage hm = new HomePage(driver);
			hm.ClickOnMyAccount();
			hm.ClickOnLogin();

			logger.info("** My Account Validation Starts **");
			LoginPage lp = new LoginPage(driver);
			lp.txtUserName(email);
			lp.txtPassword(pwd);
			lp.ClickOnLogin();

			logger.info("Msg My Account Validation");
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.IsMyAccountHeaderExist();
			Assert.assertEquals(targetPage, true, "My Account");
//		Assert.assertTrue(targetPage);
			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					macc.ClickOnLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					macc.ClickOnLogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***** Finished TC_003_LoginDDT ******");
	}
}
