package com.objects;

import org.openqa.selenium.WebDriver;

public class RediffHomePage {

	private WebDriver driver;
	public RediffHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
