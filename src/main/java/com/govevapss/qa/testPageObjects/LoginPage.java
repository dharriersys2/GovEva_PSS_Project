package com.govevapss.qa.testPageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);

	}


	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement txtUsername;
	
	
	@FindBy(xpath = "//*[@class='placeholder']")
	@CacheLookup
	WebElement companyName;
	
	@FindBy(xpath = "//input[@autocomplete='off']")
	@CacheLookup
	WebElement selectCompany;
	
	@FindBy(xpath = "//input[@autocomplete='off']")
	@CacheLookup
	WebElement enterCompany;
	
	@FindBy(xpath = "//*[@name='Password']")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	@CacheLookup
	WebElement click_login;
	
	

	
	public void setUsername(String un) {
		
		txtUsername.sendKeys(un);
	}
	
	public void setCompanyName(String comName) throws InterruptedException {
		
		companyName.click();
		selectCompany.sendKeys(comName);
		Thread.sleep(5000);
		
		enterCompany.sendKeys(Keys.ENTER);
		
	}
	
	
	public void setPassword(String pw) {
		
		txtPassword.sendKeys(pw);
	}
	
	public void clickLoginBtn() {
		
		click_login.click();
		
	}




}
