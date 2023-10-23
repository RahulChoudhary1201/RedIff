package com.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.utils.Constants;

public class BaseClassRedIff {

	public static WebDriver driver;

	private WebDriver initChromeDriver(String url) {
		System.out.println("Opening Chrome Browser with new Profile...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Constants.CONSTANT_DURATION);
		return driver;
	}
	private WebDriver initFireFoxDriver(String url) {
		System.out.println("Opening Firefox Browser with new Profile...");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Constants.CONSTANT_DURATION);
		return driver;
	}
	private WebDriver initEdgeDriver(String url) {
		System.out.println("Opening Edge Browser with new Profile...");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Constants.CONSTANT_DURATION);
		return driver;
	}

	private void setDriver(String browserName, String url) {
		String name = browserName.toLowerCase();
		switch (name) {
			case "chrome" :
				driver = initChromeDriver(url);
				break;
			case "firefox" :
				driver = initFireFoxDriver(url);
				break;
			case "edge" :
				driver = initEdgeDriver(url);
			default :
				System.out.println("Invalid Browser name: " + browserName
						+ "Opening Chrome Browser...");
				driver = initChromeDriver(url);
		}
	}

	@Parameters({"name", "url"})
	@BeforeSuite
	public void startingBrowser(String name, String url) {
		try {
			setDriver(name, url);
		} catch (Exception e) {
			System.out.println("Error..." + e.getStackTrace().toString());
		}
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
