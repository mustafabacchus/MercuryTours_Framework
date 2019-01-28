package com.qa.was.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.was.base.Base;

public class LandingPage extends Base {
	
	@FindBy(name="userName")
	WebElement user;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="login")
	WebElement signIn;
	
	public LandingPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateTitle() {
		assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	}
	
	public void login() {
		user.sendKeys(prop.getProperty("user"));
		pass.sendKeys(prop.getProperty("pass"));
		signIn.click();
	}
	
}
