package com.terkwaz.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.terkwaz.base.TestBase;


public class GooglePage extends TestBase {
	
	@FindBy(name = "q")
	WebElement SearchTextBox;
	
	
	public GooglePage() {

		PageFactory.initElements(driver, this);
		
	}
	
	public  String getTitle() {
		String actualTitle =driver.getTitle();
		return actualTitle;
	}
	
	public GSearchResultPage performSearch(String searchKeyword) {
		SearchTextBox.sendKeys(searchKeyword);
		SearchTextBox.sendKeys(Keys.ENTER);
		return new GSearchResultPage();
	}


}
