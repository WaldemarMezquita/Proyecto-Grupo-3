package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.utilities.Utilities;

public class HomePage extends Utilities{
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	//localizadores
	By yourLogoLocator = By.xpath("//img[@src='http://automationpractice.com/modules/blockbanner/img/sale70.png']");
	By contactUsLocator = By.id("contact-link");
	By logInLocator = By.id("header_user_info");
	
	By itemLocator = By.xpath("//ul[@id='homefeatured']/li/div/div/div[@class='product-image-container']/a[@href='http://automationpractice.com/index.php?id_product=1&controller=product']/img[@alt='Faded Short Sleeve T-shirts']");
	
	
	public WebElement yourLogo() {
		return findElement(yourLogoLocator);
	}
	
	public WebElement contactUs() {
		return findElement(contactUsLocator);
	}
	
	public WebElement logInLocator() {
		return findElement(logInLocator);
	}
	
	public WebElement itemLocator() {
		return findElement(itemLocator);
	}
	

}
