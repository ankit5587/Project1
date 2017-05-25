package com.bajaj.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkipSignInPage {

	private WebDriver driver;

	public SkipSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//********************************************************************************//
	//This is page factory model //
	//********************************************************************************//
	
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstName_F;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastName_F;
	
	@FindBy(css="textarea[ ng-model='Adress']")
	WebElement textAreaAdd_F;
	
	@FindBy(css="input[ ng-model='EmailAdress']")
	WebElement emailAdress_F;
	
	//********************************************************************************//
	//This is page object model //
	//********************************************************************************//
//	By firstName = By.xpath("//input[@placeholder='First Name']");
//	By lastName = By.xpath("//input[@placeholder='Last Name']");
//	By textAreaAdd = By.cssSelector("textarea[ ng-model='Adress']");
//	By emailAdress = By.cssSelector("input[ ng-model='EmailAdress']");
//	By phone = By.xpath("//input[@ng-model='Phone']");
//	By maleGender = By.xpath("//input[@value='Male']");
//	By femaleGender = By.xpath("//input[@value='FeMale']");
//	By checkBoxCriket= By.xpath("//input[@value='Cricket']");
//	By checkBoxMovies =By.xpath("//input[@value='Movies']");
//	By checkBoxHockey= By.xpath("//input[@value='Hockey']");
//	By languageMultiselect = By.xpath("//div[@id='msdd']");
//	By skilselectDropdown = By.xpath("//select[@id='Skills']");
//	By countryselectDropdown =By.xpath("//select[contains(@id,'countries')]");
//	By countryComboBox =By.xpath("//span[@role='combobox']");
//	By YearofDate =By.xpath("//select[@id='yearbox']");
//	By MonthofDate = By.xpath("//select[@placeholder='Month']");
//	By DayofDate = By.xpath("//select[@id='daybox']");
//	By passWord = By.xpath("//input[@ng-model='Password']");
//	By confirmPassWord =By.xpath("//input[@ng-model='CPassword']");
//	By submitButton = By.xpath("//button[@type='submit']");
//	By refreshButton = By.xpath("//button[@value='Refresh']");

	
public void Enterdetails(String fname,String lname,String address,String email){
	firstName_F.sendKeys(fname);
	lastName_F.sendKeys(lname);
	textAreaAdd_F.sendKeys(address);
	emailAdress_F.sendKeys(email);
//	driver.findElement(phone).sendKeys("1234567890");
//	driver.findElement(maleGender).click();
//	driver.findElement(languageMultiselect).click();
	}

public void goToHomePage() {
	driver.navigate().to("http://demo.automationtesting.in/");
	
}
}

