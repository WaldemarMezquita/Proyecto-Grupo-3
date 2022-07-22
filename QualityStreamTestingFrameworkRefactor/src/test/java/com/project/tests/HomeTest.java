package com.project.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import com.project.utilities.Utilities;
import com.project.pages.HomePage;

public class HomeTest {
	WebDriver driver;
	// HomePage homePage;
	String url = "http://automationpractice.com/index.php";
	String browserType = "chrome";
	Utilities utilities;

	// localizadores
	By yourLogoLocator = By.xpath("//img[@src='http://automationpractice.com/modules/blockbanner/img/sale70.png']");
	By contactUsLocator = By.id("contact-link");
	By logInLocator = By.id("header_user_info");

	By itemLocator = By.xpath(
			"//ul[@id='homefeatured']/li/div/div/div[@class='product-image-container']/a[@href='http://automationpractice.com/index.php?id_product=1&controller=product']/img[@alt='Faded Short Sleeve T-shirts']");
	By addToCartLocator = By
			.xpath("//ul[@id='homefeatured']/li/div/div/div/a[@data-id-product='1']/span[text()='Add to cart']");
	By overLocator = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]");

	// Localizadores al agregar al carrito un item
	By confirmAddToCart = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2");
	

	@BeforeClass
	public void beforeClass() {
		utilities = new Utilities(driver);
		driver = utilities.DriverConnection(browserType);
		utilities.maximize();
		utilities.visit(url);

	}

	@Test
	public void testHomepage() throws Exception{

		utilities.scroll("0","800");
		utilities.mouseOver(overLocator, addToCartLocator);
		
		Thread.sleep(13000);
		assertTrue(driver.findElement(confirmAddToCart).isDisplayed(),"no se muestra elemento ConfirmAddToCart");
		Reporter.log("Se agregó correctamente el poducto a la carretilla");
		utilities.takeScreenShot(driver,"./src/test/resources/ScreenShots/","test1.png");
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
