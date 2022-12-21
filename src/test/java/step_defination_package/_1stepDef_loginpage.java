package step_defination_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom_package.Baseclass;
import pom_package._1pom_loginpage;
import pom_package._2pom_homepage;
import pom_package._3pom_SearchCustomer;

public class _1stepDef_loginpage extends Baseclass {
	
	@Before
	public void setup() throws IOException {
		
		Log = LogManager.getLogger("_1stepDef_loginpage");
		
			readConfig = new Properties();
			FileInputStream fis = new FileInputStream("config.properties");
			readConfig.load(fis);
		
		String browser = readConfig.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize(); // X
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // X
		}
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
//		System.out.println("setup method executed");
		Log.info("setup method executed");
	}
	
	 /////////////////// COMMON STEPS /////////////////////////
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
	    loginPg = new _1pom_loginpage(driver);
	    pomcreatecustomer=new _2pom_homepage(driver);
	    pomsearchcustomer=new _3pom_SearchCustomer(driver);
	    
	    Log.info("launched Chrome browser");
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	}

	@And("user enters email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String passw) throws InterruptedException {
		
	    loginPg.enteruserid(email);
	    loginPg.enterPassword(passw);
	    
	}

	@And("click on Login")
	public void click_on_login() throws InterruptedException {
	    loginPg.clicklogin();
	    
	}
	
	 /////////////////// LOGIN FEATURE STEPS /////////////////////////

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle ) {
	   String actualTitle = driver.getTitle();
	    if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); //pass
		}
	    else {
			Assert.assertTrue(false);
		}
	}

	@When("user click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	    loginPg.logoutbtn();
	    
	}
	
		//////////////////// LOGIN by DDT ////////////////////////////
	
	@When("^by DDT email as (.*) and Password as (.*)$")
	public void by_ddt_email_as_wrong_email_com_and_password_as_admin(String email, String password) throws InterruptedException {
		loginPg.enteruserid(email);
		loginPg.enterPassword(password);
	}
	@And("close the browser")
	public void close_the_browser() {
	    driver.close();
	}
	
	    /////////////////// CREATE CUSTOMER /////////////////////////
	@Then("user can view Dashboard")
	public void user_can_view_Dashboard() throws InterruptedException {
		Assert.assertEquals("Dashboard / nopCommerce administration",pomcreatecustomer.getPageTitle());
		Thread.sleep(2000);
	}
	
	@When("user clicks on Customer menu")
	public void user_clicks_on_customer_menu() {
		pomcreatecustomer.clickcustomerMenu();
	}
	@And("user clicks on Customer option")
	public void user_clicks_on_customer_option() {
		pomcreatecustomer.clickcustomerOption();
	}
	@And("user clicks on Add new button")
	public void user_clicks_on_add_new_button() throws InterruptedException {
		pomcreatecustomer.clickAddNewbutton();
		Thread.sleep(5000);
	}
	@Then("user can view Add a new customer page")
	public void user_can_view_add_a_new_customer_page() throws InterruptedException {
	   
	    Assert.assertEquals("Add a new customer / nopCommerce administration",pomcreatecustomer.getPageTitle());
	    Thread.sleep(2000);
	}
	@When("user enters customers information")
	public void user_enters_customers_information() {
		
		pomcreatecustomer.emaildtbx(generateEmailId() + "@gmail.com"); // to get auto generated random email ID
		
		pomcreatecustomer.Passwordtbx("KING1818");
		pomcreatecustomer.firstNametbx("Virat");
		pomcreatecustomer.LastNametbx("Kohli");
		pomcreatecustomer.clickgender();
		pomcreatecustomer.DateOfBirthtbx("11/05/1988");
		pomcreatecustomer.CompanyNametbx("Indian Cricket Team");
		pomcreatecustomer.clickIsTaxExempt();
		pomcreatecustomer.ManagerOfVendorLISTBOX();
	
	}
	
	@When("clicks on save button")
	public void clicks_on_save_button() {
	    pomcreatecustomer.clicksavebutton();
	}

	
	@Then ("Add new button should present on that webpage")
	public void isThereAddnewButton(){
		boolean conf=pomcreatecustomer.isThereAddnewButton();
		if (conf==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
	   
//	@And("close the browser")
//	public void close_the_browser() throws InterruptedException {
//	Thread.sleep(2000);
//	driver.quit();
//	}
	
	//////////////////////////////////// Search customer by EMAIL/////////////////////////////////////
	
	@Then("Enter customer EMail")
	public void enter_customer_e_mail() {
		pomsearchcustomer.enterEmailAdd("meivwv@gmail.com");  
	}
	@When("Click on search button")
	public void click_on_search_button() {
		pomsearchcustomer.clickSeachButton();
	}
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	    String expectedEmail= "meivwv@gmail.com";
	   Assert.assertTrue( pomsearchcustomer.searchCustomerByEmail(expectedEmail));
	}
	@And("close browser")
	public void close_browser() {
	    driver.close();
	}
	
	//////////////////////////////////// Search customer by NAME/////////////////////////////////////

	@Then("Enter customer First name")
	public void enter_customer_first_name() {
		pomsearchcustomer.enterCustomerFname("Virat");
	}
	@Then("Enter customer Last name")
	public void enter_customer_last_name() {
		pomsearchcustomer.enterCustomerLname("Kohli");
	}
	@Then("User should found name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expextedName="Virat Kohli";
		Assert.assertTrue(pomsearchcustomer.searchCustomerByName(expextedName));
	}
	
//	This is hooks  (1st  type) will execute after each scenario
	@After
	public void teardown(Scenario sc) throws IOException {
		
		System.out.println("Teardown method executed");
		
		if (sc.isFailed())
		{
		String name	=sc.getName();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./target/screenshot/ "+name+" .png");
		Files.copy(src, dest);
		}
		
		driver.quit();
		
		Log.info("all tabs quited");
	}
	
//	This is hooks  (2nd type) will execute after EACH STEP
	@BeforeStep
	public void beforeStepAnnotationHOOK() {
		System.out.println("This is before step annotation");
	}
	@AfterStep
	public void afterStepAnnotationHOOK() {
		System.out.println("This is After step annotation");
	}
	
	@AfterStep
	public void addScreenshot(Scenario sc) {
//		To attach screenshot for each steps in extent report - Then dont add If statement
		
		if (sc.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot,"image/png",sc.getName());
		}
		
	}
}
