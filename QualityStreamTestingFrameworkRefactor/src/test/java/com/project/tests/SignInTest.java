package com.project.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.project.pages.LoginPage;
import com.project.pages.SignInPage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class SignInTest {
	
	WebDriver driver;
	SignInPage signin;
	String browser = "chrome";
	String url ="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	
	@BeforeClass
	public void beforeClass() throws IOException {
		signin =  new SignInPage(driver);
		driver = signin.DriverConnection(browser);
		driver.manage().window().maximize();
		signin.visit(url);
		signin.setValues();
		
	}

	@Test
	public void SignIn() throws InterruptedException, IOException {
		signin.signIn();
		signin.personalInformation();
		signin.addressInformation();
		signin.clickSubmit();
		signin.validateRegister();
		
		
	}
	
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
