package com.saucedemo.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.ExtentReportListener.ExtentReporterNG;
import com.rumy103040.qa.base.TestBase;
import com.rumy103040.qa.util.LoggerLoad;
import com.rumy103040.qa.util.TestUtil;
import com.saucedemo.qa.pages.SauceDemoLoginPage;
@Listeners(ExtentReporterNG.class)
public class SauceDemoLoginPageTest extends TestBase{
	
	SauceDemoLoginPage loginPage;
	TestUtil testUtil;
	String sheetName = "login";
	
	
	public SauceDemoLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new SauceDemoLoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		
		LoggerLoad.info("Check the Title of the Login Page..");
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority=2)
	public void robotLogoImageTest() throws IOException{
		boolean flag = loginPage.validateRobotImage();
		takeScreenshot("robot_image_login_page_");
		LoggerLoad.info("Check the Robot Logo of the Login Page..");
		//testUtil.takeScreenshotAtEndOfTest();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getSauceDemoLoginTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	//@Test(priority=3, dataProvider="getSauceDemoLoginTestData")
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
