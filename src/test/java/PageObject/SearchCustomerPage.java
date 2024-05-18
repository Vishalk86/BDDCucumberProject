package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage 
{
WebDriver ldriver;   // local driver object
	
	public SearchCustomerPage(WebDriver rDriver)  // rDriver - remote driver object
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath = "//input[@name='SearchEmail']")
	WebElement emailId;
	
	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement searchButton;
	
	@FindBy(xpath = "(//table[@id='customers-grid']//tr)/td[2]")
	List<WebElement> TableRows;
	
	@FindBy(xpath = "//input[@name='SearchFirstName']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='SearchLastName']")
	WebElement LastName;
	
    //action method, we perform an action on element
	public void enterEmailForSearch(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public void enterFirstName(String firstName)
	{
		FirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		LastName.sendKeys(lastName);
	}
	
	public boolean checkEmailId(String emailId)
	{
		boolean found = false;
		int rows = TableRows.size();
		for(int i=1; i<=rows; i++)
		{
			String email = ldriver.findElement(By.xpath("(//table[@id='customers-grid']//tr)["+ (i+1) +"]/td[2]")).getText();
			if (email.equals(emailId))
			{
				found = true;
				break;
			}
		}		
		return found;		
	}
	
	public boolean checkName(String expectedName)
	{
		boolean found = false;
		int rows = TableRows.size();
		for(int i=1; i<=rows; i++)
		{
			String searchedName = ldriver.findElement(By.xpath("(//table[@id='customers-grid']//tr)["+ (i+1) +"]/td[3]")).getText();
			if (searchedName.equals(expectedName))
			{
				found = true;
				break;
			}
		}		
		return found;		
	}

}
