package com.symlexvpn.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.ExtentReporterNG;
import com.rumy103040.qa.base.TestBase;
import com.rumy103040.qa.util.TestUtil;
import com.symlexvpn.qa.pages.SymlexVPNUserLoginPage;
@Listeners(ExtentReporterNG.class)
public class SymlexVPNEndUserLoginPageTest extends TestBase{
	
	SymlexVPNUserLoginPage loginPage;
	TestUtil testUtil;
	String sheetName = "login";
	
	
	public SymlexVPNEndUserLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new SymlexVPNUserLoginPage();	
	}
	
	
	@DataProvider
	public Object[][] getLoginTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getLoginTestData")
	public void loginTest(String username, String password) throws IOException{
		loginPage.login(username, password);
		//takeScreenshot("products_after_successful_login_");
	}
	
	
	public static void takeScreenshot(String fileName) throws IOException{
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, 
				new File((System.getProperty("user.dir")+"/screenshots/" + fileName +System.currentTimeMillis()+".png")));

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
