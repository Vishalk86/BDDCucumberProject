Feature: Login

#@Sanity
Scenario: Successful Login with Valid Credentials
	 Given User Launch Chrome Browser
	 When User opens URL "https://admin-demo.nopcommerce.com/login"
	 And User enters Email as "admin@yourstore.com" and Password as "admin"
	 And Click on Login
	 Then Page Title should be "Dashboard / nopCommerce administration"
	 When User click on Log out link
	 Then Page Title should be "Your store. Login"
	 Then Close browser
 
 
  Data Driven Testing
@Regression
Scenario Outline: Successful Login with Valid Credentials (Data Driven Testing)
	 Given User Launch Chrome Browser
	 When User opens URL "https://admin-demo.nopcommerce.com/login"
	 And User enters Email as "<email>" and Password as "<password>"
	 And Click on Login
	 Then Page Title should be "Dashboard / nopCommerce administration"
	 When User click on Log out link
	 Then Page Title should be "Your store. Login"
	 Then Close browser
 
 Examples:
 |email|password|
 |admin@yourstore.com|admin|
 |admin@yourstore.com123|admin|