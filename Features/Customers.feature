Feature: Customer

Background: Steps common for all Scenarios
   Given User Launch Chrome Browser
	 When User opens URL "https://admin-demo.nopcommerce.com/login"
	 And User enters Email as "admin@yourstore.com" and Password as "admin"
	 And Click on Login
	 Then User can view Dashboard

@Regression
Scenario: Add New Customer
	 When User click on Customers Menu
	 And User click on Customers Menu Item
	 And User click on Add New button
	 Then User can view Add New Customer page
	 When User enter Customer Info
	 And User click on Save button
	 Then User can view confirmation message "The new customer has been added successfully."

@Regression	 
Scenario: Search Customer by Email Id
	 When User click on Customers Menu
	 And User click on Customers Menu Item
	 And Enter Customer Email Id
	 When Click on Search button
	 Then Email id Should be available in Search Table
	 
@Regression		 
Scenario: Search Customer by Name
	 When User click on Customers Menu
	 And User click on Customers Menu Item
	 And Enter Customer First Name
	 And Enter Customer Last Name
	 When Click on Search button
	 Then Name Should be available in Search Table
	 