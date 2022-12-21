package runner__package;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions
(
		features = "src/test/resources/feature_package/" ,
		glue = "step_defination_package" ,
		dryRun = false ,
		monochrome = true ,
//		tags = "@FT and @ST" ,
		
//		1. for html report
		plugin = {"pretty", "html:target/cucumber-reports/NewReport.html"} 

//		2. for extent report
//		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class _1Runner_loginpage extends AbstractTestNGCucumberTests //extends is optional. only to run by TestNG
{
	// 	class will be empty
}
