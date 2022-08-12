package com.project.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.project.utilities.Utilities;

public class LogOutPage extends Utilities{

	public LogOutPage(WebDriver driver) {
		super(driver);
	}
	
	//Localizadores
	By btnLogOutLocator = By.xpath("//a[@title='Log me out']");
	By btnSignInLocator = By.cssSelector("a.login");
	
	public void LogOut() {
		assertTrue(isDisplayed(btnLogOutLocator),getDate() + "-No se muestra bot�n LogOut");
		click(btnLogOutLocator);
		Reporter.log(getDate() + "Se hizo clic en el bot�n LogOut");
		assertTrue(isDisplayed(btnSignInLocator),getDate() + "No se muestra bot�n Sign In");
		Reporter.log("Se cerr� sesi�n satisfactoriamente");
	}

}
