package com.project.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.project.utilities.Utilities;

public class SignInPage extends Utilities{

	public SignInPage(WebDriver driver) {
		super (driver);
	}
	
	
	
	
	
	//localizadores sign in page
	By lblCrateAccountLocator = By.xpath("//form/h3[text()='Create an account']");
	By txtCreateEmailLocator = By.id("email_create");
	By btnCreateAccountLocator = By.id("SubmitCreate");
	
	
	//localizadores formulario de información personal
	By lblPersonalInformationLocator = By.xpath("//form/div/h3[text()='Your personal information']");
	By radioBtnGenderLocator = By.id("uniform-id_gender1");
	By txtCustomerFirstNameLocator = By.name("customer_firstname");
	By txtCustomerLastNameLocator = By.id("customer_lastname");
	By txtCustomerEmailLocator = By.id("email");
	By txtCustomerPasswordLocator = By.id("passwd");
	By selectDayLocator = By.id("days");
	By selectMonthLocator = By.id("months");
	By selectYearsLocator = By.id("years");
	By chkbxNewsletterLocator= By.id("newsletter");
	By chkbxOffersLocator = By.id("optin");
	
	//localizadores Your Address
	By txtFirstNameLocator = By.id("firstname");
	By txtLastNameLocator = By.id("lastname");
	By txtCompanyLocator = By.id("company");
	By txtAddressLocator = By.id("address1");
	By txtAddress2Locator = By.id("address2");
	By txtCityLocator = By.id("city");
	By txtStateLocator = By.id("id_state");
	By txtZipCodeLocator = By.id("postcode");
	By selectCountryLocator = By.id("id_country");
	By txtAdditionalInfoLocator = By.id("other");
	By txtPhoneLocator = By.id("phone");
	By txtMobilePhone = By.id("phone_mobile");
	By txtAddressAlias = By.id("alias");
	By btnSubmitAccount = By.id("submitAccount");
	
	//Localizadores de error y exito
	By lblErrorLocator = By.xpath("//div[@class='alert alert-danger']/p");
	By listErrorLocator = By.xpath("//div[@class='alert alert-danger']/ol");
	By lblExitRegisterLocator = By.cssSelector("p.info-account"); 
	By btnMyPersonalInfoLocator = By.xpath("//a[@title='Information']/span");

	
	public void signIn() {
		
		assertTrue(isDisplayed(lblCrateAccountLocator),getDate() + "- No se muestra label Create an Account");
		Type("waldemar.mezquita@gmail.co", txtCreateEmailLocator);
		Reporter.log(getDate()+"-se ingresó correo: " + getText(txtCreateEmailLocator));
		click(btnCreateAccountLocator);
		Reporter.log(getDate()+"-Se hizo clic en botón Create an Account");
		
	}
	
	public void personalInformation(String firstName, String lastName, String email, String password) throws InterruptedException {
		Thread.sleep(15000);
		//assertTrue(isDisplayed(lblPersonalInformationLocator),getDate() + "-No se encontró el label Personal Information");
		Reporter.log(getDate() + "-Se muestra label personal information");
		click(radioBtnGenderLocator);
		Type(firstName, txtCustomerFirstNameLocator);
		Type(lastName, txtCustomerLastNameLocator);
		assertEquals(getValue(txtCustomerEmailLocator), email);
		Type(password, txtCustomerPasswordLocator);
		Type("10",selectDayLocator);
		Type("July",selectMonthLocator);
		Type("1990",selectYearsLocator);
		click(chkbxNewsletterLocator);
		click(chkbxOffersLocator);
		
	}
	
	public void addressInformation(String company, String address, String address2, String city, String state, String country, String homePhone, String mobilePhone, String aliasAddress) {
		Type(company, txtCompanyLocator);
		Type(address, txtAddressLocator);
		Type(address2,txtAddress2Locator);
		Type(city, txtCityLocator);
		Type(state,txtStateLocator);
		Type("56565556", btnCreateAccountLocator);
		Type(country, selectCountryLocator);
		Type("knsaklsanlksandalkd", txtAdditionalInfoLocator);
		Type(homePhone, txtPhoneLocator);
		Type(mobilePhone, txtMobilePhone);
		Type(aliasAddress, txtAddressAlias);
		
	}
	
	public void clickSubmit() {
		assertTrue(isDisplayed(btnSubmitAccount),"No se muestra habilitado el botón Registrar");
		click(btnSubmitAccount);
		Reporter.log("Se hizo click en Register");
		
		if(isDisplayed(lblErrorLocator)) {
			assertFalse(isDisplayed(lblErrorLocator));
			Reporter.log(getDate() + "Se encontraron los siguientes errores: ");
			Reporter.log(getDate() + getText(listErrorLocator));
		}else {
			Reporter.log(getDate() + "-No se enontró errores");
		}
		
		
		
	}
	
	public void validateRegister() {
		assertTrue(isDisplayed(lblExitRegisterLocator), getDate() + "-No se muestra label: Welcome to your account. Here you can manage all of your personal information and orders");
		assertTrue(isDisplayed(btnMyPersonalInfoLocator), getDate() + "-No se muestra botón My Personal Information");
	}
	
}
