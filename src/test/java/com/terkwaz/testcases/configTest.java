package com.terkwaz.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.terkwaz.base.TestBase;


public class configTest extends TestBase {
	
	@BeforeSuite()
	public void setExtent() {

		extent = new ExtentReports("AutoReport/index.html", true);
		extent.addSystemInfo("Framework", "Page Object");
		extent.addSystemInfo("Author", "AAshour");
		extent.addSystemInfo("Enviroment", "Win 10");
		extent.addSystemInfo("Test", "Terkwaz Test");

	}

	@AfterSuite()
	public void endReport() {

		extent.flush();

	}
	
	

}
