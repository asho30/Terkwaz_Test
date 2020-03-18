package com.terkwaz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.terkwaz.base.TestBase;


public class HerokuAppPage extends TestBase {


	@FindBy(linkText = "File Upload")
	WebElement File_Upload_link;
	
	@FindBy(linkText = "Dynamic Loading")
	WebElement Dynamic_Loading_link;
	
	public HerokuAppPage() {

		PageFactory.initElements(driver, this);
		
	}
	
	public HerokuAppUploadPage press_File_Upload() {
		File_Upload_link.click();
		return new HerokuAppUploadPage();
	}

	public HerokuAppDynamicLoadingPage press_Dynamic_Loading() {
		Dynamic_Loading_link.click();
		return new HerokuAppDynamicLoadingPage();
	}
}
