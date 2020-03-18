package com.terkwaz.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.terkwaz.base.TestBase;


public class HerokuAppDynamicLoading2Page extends TestBase {

	@FindBy(xpath = "//*[@id=\"start\"]/button")
	WebElement Start_Button;
	
	@FindBy(id = "finish")
	WebElement Finish_Header;
	
	public HerokuAppDynamicLoading2Page() {

		PageFactory.initElements(driver, this);
		
	}

	public void press_Start() {
		Start_Button.click();
	}

	public void wait_Finishing() {
		WebDriverWait wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(Finish_Header));
		
	}

	public String check_Text() {
		return Finish_Header.getText();
	}
	

}
