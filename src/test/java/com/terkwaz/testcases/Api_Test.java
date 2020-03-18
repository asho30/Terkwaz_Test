package com.terkwaz.testcases;


import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.terkwaz.base.TestBase;
import com.terkwaz.client.RestClient;


public class Api_Test extends TestBase {
	String url;
	RestClient restClient;
	String Response [];
	
	public Api_Test() {
		super();
	}
	
	@BeforeMethod
	public void start(Method method) throws ClientProtocolException, IOException {
		
		logger = extent.startTest(method.getName());
		String serviceUrl = prop.getProperty("serviceUrl");
		String apiUrl = prop.getProperty("apiUrl");
		url = serviceUrl + apiUrl;
		System.out.println("URL for API -->" + url);
		
		
	}
	
	
	@Test
	public void FactsAPITest() throws ClientProtocolException, IOException {
		restClient= new RestClient();
		Response = restClient.get(url);
		Assert.assertEquals(Response[0], "200");
		Assert.assertNotNull(Response[1]);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
			

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

		} else {
			logger.log(LogStatus.PASS, "Test passed");
			logger.log(LogStatus.PASS, "Status Code: " + Response[0]);
			logger.log(LogStatus.PASS, "Response Body: " + Response[1]);
			
		}

		extent.endTest(logger);
		//driver.quit();
	}
	
	
	

}
