package com.bajaj.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By EmailIdForSignup = By.id("email");
	By SignInButton = By.id("btn1");
	By SkipSignInButton =By.id("btn2");
	By EnterImage= By.id("enterimg");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public SignInPage GotoSignInPage()
	{
		driver.findElement(SignInButton).click();
		return new SignInPage(driver);
	}
	
	public SkipSignInPage GotoSkipSignInPage()
	{
		driver.findElement(SkipSignInButton).click();
		return new SkipSignInPage(driver);
	}
	
	public SkipSignInPage ClickOnEnter()
	{
		driver.findElement(EnterImage).click();
		return new SkipSignInPage(driver);
	}
	
	public void EnterEmail(String email)
	{
		driver.findElement(EmailIdForSignup).sendKeys(email);
	}
}
