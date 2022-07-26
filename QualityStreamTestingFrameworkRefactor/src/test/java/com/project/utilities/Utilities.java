package com.project.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

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

	// funci�n para hcer mouse over y hacer clic en un elemento que se muestra
	// s�lo cuando se pasa el punto osbr eun un elemento
	// Recibe como par�metrodos elementos:
	// 1� elemento es sobre el cual se debe hacer mouse over(locator)
	// 2� es el elemento(locatorClick) que se muestra al hacer over y sobre el que
	// se quiere hacer clic
	public void mouseOver(By locator, By locatorClick) {

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(locator)).moveToElement(driver.findElement(locatorClick)).click()
				.build().perform();

	}

	// Funci�n para hacer scroll, recibe como par�metro la cantidad que se va a
	// desplazar
	// si se envia en X cierta cantidad se va a desplazar el scroll en X dicha
	// cantidad
	// lo mismo aplica para el segundo par�metro Y
	public void scroll(String x, String y) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(" + x + "," + y + ")");

	}

	public void fWait(final By locator, int timeOut, int pollingEvery) {

		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingEvery)).ignoring(NoSuchElementException.class);

		WebElement welement = fwait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}

//M�todo para tomar captura de pantalla
	public void takeScreenShot(WebDriver webdriver, String path, String description) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(path + " " + description);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
	
	//Funci�n para obetner fecha en formato String
	public String getDate() {
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date();
		return dateformat.format(date);
	}

}
