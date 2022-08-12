package com.project.tests;

import org.testng.annotations.Test;

import com.project.pages.LoginPage;
import com.project.utilities.Utilities;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;

public class LogInTest {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browserType = "chrome";
	LoginPage login;
	
	@BeforeClass
	public void beforeClass() {
		login = new LoginPage(driver);
		driver = login.DriverConnection(browserType);
		login.visit(url);
		driver.manage().window().maximize();
	}

	@Test
	public void Login() throws InterruptedException {
		
		login.ClickSignInHome();
		login.TypeEmail("rmezquita@gmail.com");
		login.TypePassWord("123456");
		login.ClickSignButton();
		login.ValidateLogIn();
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
