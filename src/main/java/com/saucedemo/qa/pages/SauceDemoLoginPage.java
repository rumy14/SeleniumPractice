package com.saucedemo.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rumy103040.qa.base.TestBase;
import com.rumy103040.qa.pages.HomePage;

public class SauceDemoLoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div/form/input[1]")
	WebElement username;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div/form/input[2]")
	WebElement password;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div/form/input[3]")
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/img")
	WebElement robotLogo;
	
	//Initializing the Page Objects:
	public SauceDemoLoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateRobotImage(){
		return robotLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}
