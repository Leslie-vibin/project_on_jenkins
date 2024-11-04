package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Documentspage {
	WebDriver driver=null;
	@FindBy(xpath="//img [contains(@title,'Create Document...')]")
	WebElement newdoclink;

	public WebElement getNewdoclink() {
		return newdoclink;
	}
	public Documentspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
}
