package pageObject;

import java.security.KeyStore.TrustedCertificateEntry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountRegistrationForm extends BasePage {

	@FindBy(how = How.XPATH, using="//input[@id='input-firstname']")
	WebElement txtFirstName;
	@FindBy(how = How.XPATH, using="//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(how = How.XPATH, using="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(how = How.XPATH, using="//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(how = How.XPATH, using="//input[@id='input-password']")
	WebElement txtPassword; 	
	@FindBy(how = How.XPATH, using="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(how = How.XPATH, using="//*[@type='checkbox']")
	WebElement chkdPolicy;
	@FindBy(how = How.XPATH, using="//*[@type='submit']")
	WebElement btnContinue;
	@FindBy(how = How.XPATH, using="//*[@id='content']/h1")
	WebElement txtConfirmMessage;
	
	public AccountRegistrationForm(WebDriver driver) 
	{
		super(driver);
	}
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	public void ClickOnContinue()
	{
		btnContinue.click();
	}
	public String getConfirmMsg()
	{
		try {
			return (txtConfirmMessage.getText());
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
