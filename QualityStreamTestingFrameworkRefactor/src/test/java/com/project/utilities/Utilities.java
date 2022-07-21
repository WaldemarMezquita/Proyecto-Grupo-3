package com.project.utilities;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	WebDriver driver;

	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver DriverConnection(String browserType) {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "./src/test/resources/Drivers/firefoxDriver/geckodriver.exe"); driver = new
		 * FirefoxDriver();
		 * 
		 * return driver;
		 */

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();

			return driver;
			
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/Drivers/firefoxDriver/geckodriver.exe");
			driver = new FirefoxDriver();

			return driver;

		} else if (browserType.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "./src/test/resources/Drivers/edgeDriver/msedgedriver.exe");

			return driver;
			
		} else {

			System.out.println("El navegador " + browserType
					+ " no se encuentra configurado, por favor agregar el driver respectivo");
			return null;
		}

	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void Type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void visit(String url) {
		driver.get(url);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	// función para hcer mouse over y hacer clic en un elemento que se muestra
	// sólo cuando se pasa el punto osbr eun un elemento
	// Recibe como parámetrodos elementos:
	// 1° elemento es sobre el cual se debe hacer mouse over(locator)
	// 2° es el elemento(locatorClick) que se muestra al hacer over y sobre el que
	// se quiere hacer clic
	public void mouseOver(By locator, By locatorClick) {

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(locator)).moveToElement(driver.findElement(locatorClick)).click()
				.build().perform();

	}

	// Función para hacer scroll, recibe como parámetro la cantidad que se va a
	// desplazar
	// si se envia en X cierta cantidad se va a desplazar el scroll en X dicha
	// cantidad
	// lo mismo aplica para el segundo parámetro Y
	public void scroll(String x, String y) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(" + x + "," + y + ")");

	}
	
	public void fWait(final By locator, int timeOut, int pollingEvery) {
		
		Wait<WebDriver> fwait =  new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingEvery))
				.ignoring(NoSuchElementException.class);
		
		WebElement welement = fwait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}

}
