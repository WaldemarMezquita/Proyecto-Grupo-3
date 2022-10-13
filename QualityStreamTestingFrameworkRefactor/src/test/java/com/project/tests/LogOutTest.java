package com.project.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.project.pages.LogOutPage;
import com.project.pages.SignInPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class LogOutTest {
	WebDriver driver;
	LogOutPage logout;
	String browser = "chrome";
	//String url ="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

	@BeforeClass
	public void beforeClass() {
		logout =  new LogOutPage(driver);
		driver = logout.DriverConnection(browser);
		driver.manage().window().maximize();
		//logout.visit(url);
		
	}

	@Test
	public void logOut() {
		logout.LogOut();
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
