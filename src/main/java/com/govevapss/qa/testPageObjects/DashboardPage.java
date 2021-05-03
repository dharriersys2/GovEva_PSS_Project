package com.govevapss.qa.testPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver ldriver;

	public DashboardPage(WebDriver rdriver){

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);

	}


	@FindBy(xpath = "//div[@class='dropdown cat__top-bar__avatar-dropdown']//a[@class='dropdown-toggle']")
	@CacheLookup
	WebElement profilePic;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement logout;



	public void clickOnProfile() {

		profilePic.click();

	}


	public void clickOnLogout() {

		logout.click();
   
	}





















}
