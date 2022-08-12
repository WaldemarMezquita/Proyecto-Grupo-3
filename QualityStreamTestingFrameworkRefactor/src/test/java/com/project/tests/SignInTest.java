package com.project.tests;

import org.testng.annotations.Test;

import com.project.pages.LoginPage;
import com.project.pages.SignInPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class SignInTest {
	
	WebDriver driver;
	SignInPage signin;
	String browser = "chrome";
	String url ="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	
	
	@BeforeClass
	public void beforeClass() {
		signin =  new SignInPage(driver);
		driver = signin.DriverConnection(browser);
		driver.manage().window().maximize();
		signin.visit(url);
		
	}

	@Test
	public void SignIn() throws InterruptedException {
		signin.signIn();
		signin.personalInformation("Roberto", "Mezquita", "waldemar.mezquita@gmail.co", "123456");
		signin.addressInformation("", "", "", "", "", "", "", "", "");
		signin.clickSubmit();
		signin.validateRegister();
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
