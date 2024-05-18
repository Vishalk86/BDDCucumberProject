package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

// Parent Class
public class BaseClass 
{
	public static WebDriver driver;
	public LoginPage loginpg;
	AddNewCustomerPage addNewCustPg;
	SearchCustomerPage searchCustPage;
	ReadConfig readConfig;

	// Every time generate unique email id and return
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}

}
