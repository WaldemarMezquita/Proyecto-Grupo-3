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
		Reporter.log(getDate() + "-" + "Se hizo clic en el bot�n Sign in en el home");
	}
	
	public void TypeEmail(String email) {
		Type(email, txtEmailLocator);
		Reporter.log(getDate() + "-" + "Se ingres� el correo: " + email);
	}
	
	public void TypePassWord(String password) {
		Type(password, txtPasswordLocator);
		Reporter.log(getDate() + "-" + "Se ingres� la contrase�a: " + password);
		
	}
	
	public void ClickSignButton() {
		assertTrue(findElement(btnSignInLocator).isEnabled(), getDate() + "-" + "No est� habilitado bot�n Sign In");
		findElement(btnSignInLocator).click();
		Reporter.log(getDate() + "-" + "Se hizo clic en el bot�n Sign In en el login");
	}
	
	public void ValidateLogIn() throws InterruptedException {
		Thread.sleep(2000);
		if(isDisplayed(lblErrorLocator)){
			Thread.sleep(2000);
			assertTrue(isDisplayed(lblErrorLocator), getDate() + "-" +  "No se muestra ning�n error");
			Reporter.log("Se encontr� el siguiente error: " + getText(lblErrorDetail));
			
		}else {
			Thread.sleep(2000);
			assertTrue(isDisplayed(lblWelcome), getDate() + "-" +  "No se muestra texto Welcome");
			Reporter.log( getDate() + "-" + "Se inici� sesi�n correctamente");
			assertTrue(isDisplayed(lblAccount), getDate() + "-" +  "No se muestra informaci�n de la cuenta");
			Reporter.log( getDate() + "-" + "Se muestra la informaci�n de la cuenta del usuario");
		}
		
	}
	
	public void LogOut() {
		assertTrue(isDisplayed(btnLogOutLocator),getDate() + "-No se muestra bot�n LogOut");
		click(btnLogOutLocator);
		Reporter.log(getDate() + "Se hizo clic en el bot�n LogOut");
		//assertTrue(isDisplayed(btnSignInLocator),getDate() + "No se muestra bot�n Sign In");
		Reporter.log("Se cerr� sesi�n satisfactoriamente");
	}
	
	

}
