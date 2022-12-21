
Feature: Customers

	Background: steps common for all scenarios
		Given User launch Chrome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then user can view Dashboard
    And user clicks on Customer menu
    And user clicks on Customer option


	@AddNewCustomer
  Scenario: Add new customer
    And user clicks on Add new button
    Then user can view Add a new customer page
    When user enters customers information
    And clicks on save button
    Then Add new button should present on that webpage
    And close the browser
    
  @SearchByEmail
  Scenario: Search Customer by Email
   And Enter customer EMail
   When Click on search button
   Then User should found Email in the Search table
   And close browser
   
   @SearchByName
   Scenario: Search Customer by Name
    And Enter customer First name
    And Enter customer Last name
   When Click on search button
   Then User should found name in the Search table
   And close browser