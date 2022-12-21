package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _1pom_loginpage {
	
	public WebDriver driver;
	
	// constructor
	public _1pom_loginpage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "Email")
	WebElement email;
	
	@FindBy (id = "Password")
	WebElement password;
	
	@FindBy (xpath = "//button[.='Log in']")
	WebElement LoginBtn;
	
	@FindBy (xpath = "//a[.='Logout']")
	WebElement logoutbtn;
	
	public void enteruserid(String emailID) throws InterruptedException {
		Thread.sleep(1000);
		email.clear();
		Thread.sleep(1000);
		email.sendKeys(emailID);
		
	}
	
	public void enterPassword(String pwd) throws InterruptedException {
		Thread.sleep(1000);
		password.clear();
		Thread.sleep(1000);
		password.sendKeys(pwd);
		
	}
	
	public void clicklogin() throws InterruptedException {
	LoginBtn.click();
	Thread.sleep(1000);
	}
	
	public void logoutbtn() throws InterruptedException {
		logoutbtn.click();
		Thread.sleep(1000);
	}
	

}
