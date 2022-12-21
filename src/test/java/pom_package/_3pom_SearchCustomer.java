package pom_package;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class _3pom_SearchCustomer {
	
	WebDriver driver;
	
	public _3pom_SearchCustomer (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@type='email']")
	WebElement emailAdd;
	
	@FindBy (id = "search-customers")
	WebElement searchBtn;
	
	@FindBy (xpath = "//table[@id='customers-grid']")
	WebElement searchResult;
	
	@FindBy (xpath = "//input[@name='SearchFirstName']")
	WebElement FirstNametxbx;
	
	@FindBy (xpath = "//input[@name='SearchLastName']")
	WebElement LastNametxbx;
	 
	@FindBy (xpath = "//table[@id='customers-grid']//tbody/tr")
	List <WebElement> tableRows;
	
	
	@FindBy (xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List <WebElement> tableColumns;
	
	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}
	
	public void clickSeachButton() {
		searchBtn.click();
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean found = false;
		
		int ttlRows = tableRows.size();
//		int ttlColumns = tableColumns.size();
		
		for (int i = 1 ; i <= ttlRows; i++) {
			WebElement webElementEmail = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]"));
			String actualEmail = webElementEmail.getText();
			
			if (actualEmail.equals(email)) {
				found=true;
				break;
			}
		}
		return found;
	}
	
	public void enterCustomerFname(String Fname) {
		FirstNametxbx.sendKeys(Fname);	
	}
	
	public void enterCustomerLname(String Lname) {
		LastNametxbx.sendKeys(Lname);
	}
	
	public boolean searchCustomerByName(String name) {
		boolean found=false;
		int ttlRows = tableRows.size();
		
		for (int i = 1; i <= ttlRows; i++) {
			WebElement webElementName = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]"));
			String actualName = webElementName.getText();
			if (actualName.equals(name)) {
				found=true;
				break;
			}
		}
		return found;
	}
}
