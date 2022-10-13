package com.project.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.project.utilities.Utilities;

import dev.failsafe.internal.util.Assert;

public class LoginPage extends Utilities{

	public LoginPage(WebDriver driver) {
		super (driver);
		// TODO Auto-generated constructor stub
	}

	//Localizadores
	By logInLblLocator = By.linkText("Sign in");
	By LblAuthLocator = By.cssSelector("h1.page-heading");
	By txtEmailLocator = By.id("email");
	By txtPasswordLocator = By.id("passwd");
	By btnSignInLocator = By.id("SubmitLogin");
	
	//Error Login Locators
	By lblErrorLocator = By.xpath("//div[@id='center_column']/div/p[text()='There is 1 error']");
	By lblErrorDetail = By.xpath("//div[@id='center_column']/div/ol/li");
	
	//succesfull login locators
	By lblWelcome = By.cssSelector("p.info-account");
	By lblAccount = By.xpath("//a[@title='View my customer account']");
	
	//LogOut locators
	By btnLogOutLocator = By.xpath("//a[@title='Log me out']");
	//By btnSignInLogOutLocator = By.cssSelector("a.login");
	
	public void ClickSignInHome() {
		click(logInLblLocator);
		assertTrue(isDisplayed(LblAuthLocator),getDate() + "-" + "No se muestra label Authentication");
		Reporter.log(getDate() + "-" + "Se hizo clic en el botón Sign in en el home");
	}
	
	public void TypeEmail(String email) {
		Type(email, txtEmailLocator);
		Reporter.log(getDate() + "-" + "Se ingresó el correo: " + email);
	}
	
	public void TypePassWord(String password) {
		Type(password, txtPasswordLocator);
		Reporter.log(getDate() + "-" + "Se ingresó la contraseña: " + password);
		
	}
	
	public void ClickSignButton() {
		assertTrue(findElement(btnSignInLocator).isEnabled(), getDate() + "-" + "No está habilitado botón Sign In");
		findElement(btnSignInLocator).click();
		Reporter.log(getDate() + "-" + "Se hizo clic en el botón Sign In en el login");
	}
	
	public void ValidateLogIn() throws InterruptedException {
		Thread.sleep(2000);
		if(isDisplayed(lblErrorLocator)){
			Thread.sleep(2000);
			assertTrue(isDisplayed(lblErrorLocator), getDate() + "-" +  "No se muestra ningún error");
			Reporter.log("Se encontró el siguiente error: " + getText(lblErrorDetail));
			
		}else {
			Thread.sleep(2000);
			assertTrue(isDisplayed(lblWelcome), getDate() + "-" +  "No se muestra texto Welcome");
			Reporter.log( getDate() + "-" + "Se inició sesión correctamente");
			assertTrue(isDisplayed(lblAccount), getDate() + "-" +  "No se muestra información de la cuenta");
			Reporter.log( getDate() + "-" + "Se muestra la información de la cuenta del usuario");
		}
		
	}
	
	public void LogOut() {
		assertTrue(isDisplayed(btnLogOutLocator),getDate() + "-No se muestra botón LogOut");
		click(btnLogOutLocator);
		Reporter.log(getDate() + "Se hizo clic en el botón LogOut");
		//assertTrue(isDisplayed(btnSignInLocator),getDate() + "No se muestra botón Sign In");
		Reporter.log("Se cerró sesión satisfactoriamente");
	}
	
	

}
