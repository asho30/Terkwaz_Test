package com.terkwaz.testcases;


import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.terkwaz.base.TestBase;
import com.terkwaz.pages.HerokuAppDynamicLoading2Page;
import com.terkwaz.pages.HerokuAppDynamicLoadingPage;
import com.terkwaz.pages.HerokuAppPage;
import com.terkwaz.pages.HerokuAppUploadPage;
import com.terkwaz.utils.TestUtil;


public class HerokuApp_Test extends TestBase {
	
	HerokuAppPage herokuAppPage;
	HerokuAppUploadPage herokuAppUploadPage;
	HerokuAppDynamicLoadingPage herokuAppDynamicLoadingPage;
	HerokuAppDynamicLoading2Page herokuAppDynamicLoading2Page;
	
	public HerokuApp_Test() {
		super();
	}
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		logger = extent.startTest(method.getName());
		initialization(prop.getProperty("url2"));
		herokuAppPage = new HerokuAppPage();
		
	}
	
	
	@Test(priority = 1)
	public void TC1_UploadFile() throws InterruptedException {
		herokuAppUploadPage = herokuAppPage.press_File_Upload();
		herokuAppUploadPage.uploadFile(prop.getProperty("image_path"));
		String actualConfirmationMsg = herokuAppUploadPage.getConfirmationMsg();
		String expectedConfirmationMsg = prop.getProperty("expectedConfirmationMsg");
		Assert.assertTrue(actualConfirmationMsg.contains(expectedConfirmationMsg));
		
	}
	
	@Test(priority = 2)
	public void TC2_DynamicLoading() throws InterruptedException {
		herokuAppDynamicLoadingPage = herokuAppPage.press_Dynamic_Loading();
		herokuAppDynamicLoading2Page = herokuAppDynamicLoadingPage.press_Example2();
		herokuAppDynamicLoading2Page.press_Start();
		herokuAppDynamicLoading2Page.wait_Finishing();
		String actualConfirmationText = herokuAppDynamicLoading2Page.check_Text();
		String expectedConfirmationText = prop.getProperty("expectedConfirmationText");
		Assert.assertTrue(actualConfirmationText.contains(expectedConfirmationText));
		
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));
			

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

		} else {
			logger.log(LogStatus.PASS, "Test passed");
			String picturePath = TestUtil.TakeSnapshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));
			
		}

		extent.endTest(logger);
		driver.quit();
	}
	
	
	

}
