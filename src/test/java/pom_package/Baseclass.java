package pom_package;

import java.util.Properties;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import ch.qos.logback.classic.Logger;
import org.apache.logging.log4j.*;

public class Baseclass {
	
	public WebDriver driver;
	public _1pom_loginpage loginPg;
	public _2pom_homepage pomcreatecustomer;
	public _3pom_SearchCustomer pomsearchcustomer;
	
	public static org.apache.logging.log4j.Logger Log;
	
	public Properties readConfig;
	
	// Created for generating random string for unique email.
	public String generateEmailId()
	{
		return (RandomStringUtils.randomAlphabetic(5)); 
	}
}