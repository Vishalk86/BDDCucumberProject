package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage 
{
	
WebDriver ldriver;   // local driver object
	
	public AddNewCustomerPage(WebDriver rDriver)  // rDriver - remote driver object
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath ="//*[text()=' Dashboard']/parent::a/parent::li/following-sibling::li[3]")
	WebElement CustomerMenu;
	
	@FindBy(xpath ="//*[text()=' Dashboard']/parent::a/parent::li/following-sibling::li[3]/ul/li[1]/a/p")
	WebElement CustomerItem;
	
	@FindBy(xpath ="//a[@class='btn btn-primary']/i")
	WebElement AddNewButton;
	
	@FindBy(xpath ="//input[@name='Email']")
	WebElement CustomerEmailId;
	
	@FindBy(xpath ="//input[@name='Password']")
	WebElement CustomerPassword;
	
	@FindBy(xpath ="//input[@name='FirstName']")
	WebElement CustomerFirstName;
	
	@FindBy(xpath ="//input[@name='LastName']")
	WebElement CustomerLastName;
	
	@FindBy(xpath ="//input[@id='Gender_Male' and @type='radio']")
	WebElement CustomerGenderMale;
	
	@FindBy(xpath ="//input[@name='DateOfBirth']")
	WebElement CustomerDOB;
	
	@FindBy(xpath ="//input[@name='Company']")
	WebElement CustomerCompanyName;
	
	@FindBy(xpath ="(//input[@name='IsTaxExempt'])[1]")
	WebElement TestExempt;
	
	@FindBy(xpath ="//textarea[@name='AdminComment']")
	WebElement AdminComment;
	
	@FindBy(xpath ="//select[@name='VendorId']")
	WebElement ManagerOfVendor;
	
	@FindBy(xpath ="//button[@name='save']")
	WebElement SaveButton;
	
	public void clickCustomerMenu()
	{
		CustomerMenu.click();
	}
	
	public void clickCustomerItem()
	{
		CustomerItem.click();
	}
	
	public void clickAddNewButton()
	{
		AddNewButton.click();
	}
	
	public void enterCustomerEmailId(String email)
	{
		CustomerEmailId.sendKeys(email);
	}
	
	public void enterCustomerPassword(String password)
	{
		CustomerPassword.sendKeys(password);
	}
	
	public void enterCustomerFirstName(String firstName)
	{
		CustomerFirstName.sendKeys(firstName);
	}
	
	public void enterCustomerLastName(String lastName)
	{
		CustomerLastName.sendKeys(lastName);
	}
	
	public void clickCustomerGenderMale()
	{
		CustomerGenderMale.click();
	}
	
	public void enterCustomerDOB(String dob)
	{
		CustomerDOB.sendKeys(dob);
	}
	
	public void enterCustomerCompanyName(String companyName)
	{
		CustomerCompanyName.sendKeys(companyName);
	}
	
	public void enterAdminComment(String adminComment)
	{
		AdminComment.sendKeys(adminComment);
	}
	
	public void selectManagerOfVendor()
	{
		Select vendor = new Select(ManagerOfVendor);
		vendor.selectByIndex(1);
	}
	
	public void clickSaveButton()
	{
		SaveButton.click();
	}
}
