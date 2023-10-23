package com.testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseClassRedIff;
import com.objects.RediffHomePage;

public class HomePageTest extends BaseClassRedIff {

	@Test
	public void verifyTitle() {
		RediffHomePage rff = new RediffHomePage(driver);
		String title = rff.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
	}

}
