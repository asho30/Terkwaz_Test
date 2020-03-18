package com.terkwaz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.terkwaz.base.TestBase;


public class GSearchResultPage extends TestBase {
	
	
	@FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div[1]/div[3]/div/div/div/div[1]/div/div[2]/div/div[1]/a/h3")
	WebElement Result1st;
	
	@FindBy(xpath = "//*[@id='rso']/div[3]/div[1]/div/div[1]/a/h3")
	WebElement Result3rd;
	
	public GSearchResultPage() {

		PageFactory.initElements(driver, this);
		
	}

	public  String getText1stRes() {
		String actualText =Result1st.getText();
		return actualText;
	}
	
	public  String getText3rdRes() {
		String actualText =Result3rd.getText();
		return actualText;
	}
	
}
