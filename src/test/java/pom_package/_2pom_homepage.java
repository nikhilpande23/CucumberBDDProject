package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class _2pom_homepage {
	
	 WebDriver driver;
	
//	Constructor
	public _2pom_homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	Find elements
	
	@FindBy (xpath = "(//a[@class='nav-link'])[21]")
	WebElement customerMenu;
	
	@FindBy (xpath = "//p[.=' Customers']")
	WebElement customerOption;
	
	@FindBy (xpath = "//a[@class='btn btn-primary']")
	WebElement AddNewbutton;
	
	
	@FindBy (id = "Email")  
	WebElement emaildtbx;
	
	@FindBy (id = "Password")  
	WebElement Passwordtbx;
	
	
	@FindBy (id = "FirstName")
	WebElement firstNametbx;
	
	@FindBy (id = "LastName")
	WebElement LastNametbx;
	
	@FindBy (id = "Gender_Male")
	WebElement gender;
	
	@FindBy (id = "DateOfBirth")
	WebElement DateOfBirthtbx;
	
	@FindBy (id = "Company")
	WebElement CompanyNametbx;
	
	@FindBy (id = "IsTaxExempt")
	WebElement IsTaxExempt;
	
//	@FindBy (xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
//	WebElement NewsSlettertbx;
	
	@FindBy (id = "VendorId")
	WebElement ManagerOfVendor;
	
	
	@FindBy (xpath = "//button[@name='save']")
	WebElement savebutton;	
	
	// Methods
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void clickcustomerMenu() {
		customerMenu.click();
	}
	
	public void clickcustomerOption() {
		customerOption.click();	
	}
	
	public void clickAddNewbutton() {
		AddNewbutton.click();
	}
	
	public void emaildtbx(String email) {
		emaildtbx.sendKeys(email);
	}
	
	public void Passwordtbx(String password) {
		Passwordtbx.sendKeys(password);
	}
	
	public void firstNametbx(String fname) {
		firstNametbx.sendKeys(fname);
	}
	
	public void LastNametbx(String lname) {
		LastNametbx.sendKeys(lname);
	}
	
	public void clickgender() {
		gender.click();
	}
	
	public void DateOfBirthtbx(String DOB) {
		DateOfBirthtbx.sendKeys(DOB);
	}
	
	public void CompanyNametbx(String company) {
		CompanyNametbx.sendKeys(company);
	}
	
	public void clickIsTaxExempt() {
		IsTaxExempt.click();
	}
	
	public void ManagerOfVendorLISTBOX() {
		Select s=new Select(ManagerOfVendor);
		s.selectByIndex(0);
	}
	
	public void clicksavebutton() {
		savebutton.click();
	}
	
	public boolean isThereAddnewButton(){
		
		return AddNewbutton.isDisplayed();
		
	}
	
	
	

}
