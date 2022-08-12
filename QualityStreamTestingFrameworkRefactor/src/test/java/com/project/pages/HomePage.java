package com.project.pages;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.project.utilities.Utilities;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends Utilities {

	public HomePage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}

	// localizadores
	// Localizadore de error al cargar página
	//By errorResourceLimit = By.xpath("//h1[text()='Resource Limit Is Reached']");
	@FindBy(xpath = "//h1[text()='Resource Limit Is Reached']")
	public WebElement errorResourceLimit;

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
	By totalLabelLocator = By.xpath("//div[@id='layer_cart']/div/div/div//strong[text()='Total']");
	By totalOrderLocator = By.id("layer_cart_product_price");
	By proceedToCheckoutLocator = By.xpath("//a[@title='Proceed to checkout']");

	// Localizadores Carrito de Compra
	By shoppinCartLabelLocator = By.id("cart_title");
	By shoppingCartContainsLocator = By.id("summary_products_quantity");

	
	
}
