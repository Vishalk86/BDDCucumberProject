package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;   // local driver object
	
	public LoginPage(WebDriver rDriver)  // rDriver - remote driver object
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement LogoutBtn;	
	
	//action method, we perform an action on element
	public void enterEmail(String emailId)
	{
		email.clear();
		email.sendKeys(emailId);
	}
	
	//action method, we perform an action on element
	public void enterPassword(String passwordvalue)
	{
		password.clear();
		password.sendKeys(passwordvalue);
	}
	
	public void clickLoginBtn()
	{
		LoginBtn.click();
	}
	
	public void clickLogoutBtn()
	{
		LogoutBtn.click();
	}

}
