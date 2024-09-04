package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(how = How.XPATH, using="//input[@id='input-email']")
	WebElement setUserName;
	@FindBy(how = How.XPATH, using="//input[@id='input-password']")
	WebElement setPassword;
	@FindBy(how = How.XPATH, using="//input[@value='Login']")
	WebElement btnLogin;
	
	public void txtUserName(String user)
	{
		setUserName.sendKeys(user);
	}
	public void txtPassword(String pwd)
	{
		setPassword.sendKeys(pwd);
	}
	public void ClickOnLogin()
	{
		btnLogin.click();
	}
}
