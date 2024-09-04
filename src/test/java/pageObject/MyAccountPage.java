package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(how = How.XPATH, using="//h2[text()='My Account']")
	WebElement txtHeaderMyAccount;
	
	@FindBy(how = How.XPATH, using="//div[@class='list-group']//a[text()='Logout']")
	WebElement linkLogout;
	
	public boolean IsMyAccountHeaderExist()
	{
		try {
			return txtHeaderMyAccount.isDisplayed();
		} catch (Exception e) 
		{
			return false;
		}
	}
	public void ClickOnLogout()
	{
		linkLogout.click();
	}
}
