package com.terkwaz.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.terkwaz.base.TestBase;


public class HerokuAppDynamicLoadingPage extends TestBase {

	@FindBy(linkText = "Example 2: Element rendered after the fact")
	WebElement Example2_link;
	
	
	public HerokuAppDynamicLoadingPage() {

		PageFactory.initElements(driver, this);
		
	}

	public HerokuAppDynamicLoading2Page press_Example2() {
		Example2_link.click();
		return new HerokuAppDynamicLoading2Page();
	}
	

}
