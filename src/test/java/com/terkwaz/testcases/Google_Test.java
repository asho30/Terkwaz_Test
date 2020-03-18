package com.terkwaz.testcases;


import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.terkwaz.base.TestBase;
import com.terkwaz.pages.GSearchResultPage;
import com.terkwaz.pages.GooglePage;
import com.terkwaz.utils.TestUtil;


public class Google_Test extends TestBase {
	
	GooglePage googlePage;
	GSearchResultPage gSearchResultPage;
	
	
	public Google_Test() {
		super();
	}
	
	
	@BeforeMethod
	public void start(Method method) throws InterruptedException, Throwable {
		
		logger = extent.startTest(method.getName());
		initialization(prop.getProperty("url1"));
		googlePage = new GooglePage();
		
	}
	
	
	@Test(priority = 1)
	public void TC1_GoogleSearch() throws InterruptedException {
		String expectedTitle ="Google";
		String actualTitle = googlePage.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		gSearchResultPage = googlePage.performSearch(prop.getProperty("searchKeyword"));
		String expectedTextRes =prop.getProperty("expectedText3rdRes");
		
		//If Global window
		String actualText3rdRes = gSearchResultPage.getText1stRes();
		Assert.assertTrue(actualText3rdRes.contains(expectedTextRes));
		
		//If Private window
		//String actualText3rdRes = gSearchResultPage.getText3rdRes();
		//Assert.assertTrue(actualText3rdRes.contains(expectedTextRes));
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
