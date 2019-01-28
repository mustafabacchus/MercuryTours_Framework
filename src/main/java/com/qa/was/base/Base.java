package com.qa.was.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.was.util.Util;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static Actions act;
	
	public Base() {
		//Setup config properties
		try {
			prop = new Properties();
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + 
					"\\src\\main\\java\\com\\qa\\was\\config\\Config.properties");
			prop.load(fin);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() throws Exception {
		//Initialize driver
		String browser = prop.getProperty("browser");
		
		//chrome
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		//firefox
		} else if(browser.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumBrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Browser initialization error");
		}
		
		//Create actions instance
		act = new Actions(driver);
		//Open url
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
