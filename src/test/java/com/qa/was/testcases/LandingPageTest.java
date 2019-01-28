package com.qa.was.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.was.base.Base;
import com.qa.was.pages.LandingPage;

public class LandingPageTest extends Base {
	
	LandingPage landingPage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialize();
		landingPage = new LandingPage();
	}
	
	@Test(priority=0)
	public void vaidateTitle() {
		landingPage.validateTitle();
	}
	
	@Test(priority=1)
	public void login() {
		landingPage.login();
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
	
}
