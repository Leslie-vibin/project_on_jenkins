package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactsinfopage {
	WebDriver driver;
	@FindBy(xpath="//a[@title='Organizations']")
	
	private WebElement findorglnk;
	public WebElement getFindorglnk() {
		return findorglnk;
	}
	public Contactsinfopage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	//td[.='Organization Name']/../../child::tr[3]/td[6]
}
