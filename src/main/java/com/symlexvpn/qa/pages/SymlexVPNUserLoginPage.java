package com.symlexvpn.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rumy103040.qa.base.TestBase;
import com.rumy103040.qa.pages.HomePage;

public class SymlexVPNUserLoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="/html/body/div[5]/div/section/div/form/div[1]/input")
	WebElement username;
	
	@FindBy(xpath="/html/body/div[5]/div/section/div/form/div[2]/input")
	WebElement password;
	
	@FindBy(xpath="/html/body/div[5]/div/section/div/form/button")
	WebElement loginBtn;
	
	
	//Initializing the Page Objects:
	public SymlexVPNUserLoginPage(){
		PageFactory.initElements(driver, this);
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
