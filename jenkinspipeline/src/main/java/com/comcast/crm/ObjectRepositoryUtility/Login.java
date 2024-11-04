package com.comcast.crm.ObjectRepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.Webdriverutility.Webdriverutility;

public class Login extends Webdriverutility {
	WebDriver driver;
//object creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//object encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//business method
	//provide action
	public void logintoapp(String url,String username,String password) {
	    waitforpagetoload(driver, 15);
	    driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	
}
