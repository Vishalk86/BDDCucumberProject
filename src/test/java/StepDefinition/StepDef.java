package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;  // We use * to import all the packages at one time
import io.github.bonigarcia.wdm.WebDriverManager;

// Child Class of BaseClass
public class StepDef extends BaseClass
{
	@Before
	public void setup() throws Exception
	{
		readConfig = new ReadConfig();
		String browser = readConfig.getBrowser();  // get value (Browser) through ReadConfig file from config.properties file
		
		//Launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;		
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;				
		default:
			driver=null;
			break;
		}
		
		driver.manage().window().maximize();
	}	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() 
	{		
		loginpg = new LoginPage(driver);  // Create object of Page Object Class 'LoginPage' class and call its methods over here
		addNewCustPg = new AddNewCustomerPage(driver);
		searchCustPage = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailId, String password) 
	{
		loginpg.enterEmail(emailId);
		loginpg.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() 
	{
		loginpg.clickLoginBtn();
	}
	
	@When("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		String actualtitle = driver.getTitle();
		if(actualtitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}	
	
	@When("User click on Log out link")
	public void user_click_on_log_out_link() 
	{
		loginpg.clickLogoutBtn();
	}
	
	//@After
//	public void teardown(Scenario sc) // Scenario is a class and creating object 'sc' here
//	{
//		if(sc.isFailed()==true) // 'sc' checks scenario status whether it is fail or pass
//		{
//			//Convert WebDriver object to TakesScreenshot
//			String fileWithPath = "C:\\Users\\hp\\eclipse-workspace\\CucumberFramework\\Screenshot\\failedScreenshot.png";
//			TakesScreenshot scrShot = ((TakesScreenshot)driver); 
//			
//			//Call getScreenshotAs method to create image file
//			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//			
//			//Move image file to new destination
//			File DestFile = new File(fileWithPath);
//			
//			//Copy file at destination
//	  try {
//			FileUtils.copyFile(SrcFile, DestFile);        // For FileUtils import we add dependency of 'commons-io'
//			} catch (IOException e) {e.printStackTrace();}
//			
//		}
//		driver.quit();
//	}
	
		
	@AfterStep
	public void addScreenshotsToExtentReport(Scenario scenario)
	{
		if(scenario.isFailed())  // If we want to get screenshot on failed scenario
		{
		// Now we are getting screenshot on each steps in Scenarios
		// We Capture screenshot in Byte form and store in Byte array. Then we attache this byte array in report.
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        //attache image file report(data, media type, name of the attachment) | Call 'attach' method to attach screenshot to report on each step
		scenario.attach(screenshot, "image/png", scenario.getName());//screenshot - Byte Array | scenario.getName() - get scenario's method name
	    }				
	}
	
	
//	@After(order=1) // This is smaller then 2, this will execute after 2
//	public void teardown2()
//	{
//		System.out.println("teardown2 method will execute..");
//	}
//	
//	@BeforeStep
//	public void beforeStepMethod()
//	{
//		System.out.println("This line will print before each Step execution....");
//	}
//	
//	@AfterStep
//	public void afterStepMethod()
//	{
//		System.out.println("This line will print after each Step execution....");
//	}

	//============================= Add New Customer =====================================
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() 
	{
		String actualtitle = driver.getTitle();
		if(actualtitle.equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}	    
	}

	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() 
	{
		addNewCustPg.clickCustomerMenu();
	    
	}

	@When("User click on Customers Menu Item")
	public void user_click_on_customers_menu_item() {
		addNewCustPg.clickCustomerItem();
	}

	@When("User click on Add New button")
	public void user_click_on_add_new_button() {
		addNewCustPg.clickAddNewButton();
	}

	@Then("User can view Add New Customer page")
	public void user_can_view_add_new_customer_page() {
		String actualtitle = driver.getTitle();
		if(actualtitle.equals("Add a new customer / nopCommerce administration"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}	
	}

	@When("User enter Customer Info")
	public void user_enter_customer_info() {
		//addNewCustPg.enterCustomerEmailId("testnewname@gmail.com");
		addNewCustPg.enterCustomerEmailId(generateEmailId() + "@gmail.com");
		addNewCustPg.enterCustomerPassword("test1");
		addNewCustPg.enterCustomerFirstName("Rohan");
		addNewCustPg.enterCustomerLastName("Singh");
		addNewCustPg.clickCustomerGenderMale();
		addNewCustPg.enterCustomerDOB("10/10/1986");
		addNewCustPg.enterCustomerCompanyName("Test ABC Company");
		addNewCustPg.selectManagerOfVendor();
		addNewCustPg.enterAdminComment("This is test comment.");		
	}

	@When("User click on Save button")
	public void user_click_on_save_button() {
		addNewCustPg.clickSaveButton();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(expectedConfirmationMessage))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}		
	}
	
	//================================ Search Customer By Email Id ===================================
	@Given("Enter Customer Email Id")
	public void enter_customer_email_id() {		
		searchCustPage.enterEmailForSearch("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		searchCustPage.clickSearchButton();
	}

	@Then("Email id Should be available in Search Table")
	public void email_id_should_be_available_in_search_table() 
	{		
		if (searchCustPage.checkEmailId("victoria_victoria@nopCommerce.com") == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		// Assert.assertTrue(searchCustPage.checkEmailId("victoria_victoria@nopCommerce.com")); Or we can write this single line to validate
	}
	
	//================================ Search Customer By Name ===================================
	@Given("Enter Customer First Name")
	public void enter_customer_first_name() {
		searchCustPage.enterFirstName("Victoria");
	}

	@Given("Enter Customer Last Name")
	public void enter_customer_last_name() {
		searchCustPage.enterLastName("Terces");
	}

	@Then("Name Should be available in Search Table")
	public void name_should_be_available_in_search_table() {
		if (searchCustPage.checkName("Victoria Terces") == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
