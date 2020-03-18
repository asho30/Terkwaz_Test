package com.terkwaz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.terkwaz.base.TestBase;


public class HerokuAppUploadPage extends TestBase {

	@FindBy(id = "file-upload")
	WebElement File_Upload_choose;
	
	@FindBy(id = "file-submit")
	WebElement Submit_Button;
	
	@FindBy(className = "example")
	WebElement confirmationMsg;
	
	
	public HerokuAppUploadPage() {

		PageFactory.initElements(driver, this);
		
	}

	public void uploadFile(String image_path) {
		File_Upload_choose.sendKeys(image_path);
		Submit_Button.click();
	}

	public String getConfirmationMsg() {
		//System.out.print(confirmationMsg.getText());
		//System.out.print(prop.getProperty("expectedConfirmationMsg"));
		return confirmationMsg.getText();

	}
	

}
