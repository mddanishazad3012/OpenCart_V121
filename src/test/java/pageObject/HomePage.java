package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(how = How.XPATH, using="//span[text()='My Account']")
	WebElement linkMyAccount;
	
	//*[@title='My Account']
	@FindBy(how = How.XPATH, using="//a[normalize-space()='Register']")
	WebElement linkRegister;
	@FindBy(how = How.XPATH, using="//a[text()='Login']")
	WebElement linkLogin;
	public void ClickOnMyAccount()
	{
		linkMyAccount.click();
	}
	public void ClickOnRegister()
	{
		linkRegister.click();
	}
	public void ClickOnLogin()
	{
		linkLogin.click();
	}
}
