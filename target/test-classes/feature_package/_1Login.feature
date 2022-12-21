
	Feature: Login

	Background: common steps for log in
			Given User launch Chrome browser
	    When user opens URL "https://admin-demo.nopcommerce.com/login"


	@Login
  Scenario: successful login with Valid credentials
	   	
	    And user enters email as "admin@yourstore.com" and Password as "admin"
	    And click on Login
    	Then Page title should be "Dashboard / nopCommerce administration"
   	 	When user click on Logout link
    	Then Page title should be "Your store. Login"
    	And close the browser
    	
   @LoginDDT
   Scenario Outline: login by DDT valid & invalid credentials
   		When by DDT email as <email> and Password as <password>
	    And click on Login
    	Then Page title should be "Dashboard / nopCommerce administration"
   	 	When user click on Logout link
    	Then Page title should be "Your store. Login"
    	And close the browser
    	
    	Examples:
    	|email|password|
			|admin@yourstore.com|admin|
			|vqs@apwsx.com|pASSSSSS|		
	