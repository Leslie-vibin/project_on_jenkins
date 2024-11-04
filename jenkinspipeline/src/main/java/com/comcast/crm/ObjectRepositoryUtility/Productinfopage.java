package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productinfopage {
WebDriver driver=null;
	
	@FindBy(className="lvtHeaderText")
	private WebElement Headertxtlnk;
public WebElement getHeadertxtlnk() {
		return Headertxtlnk;
	}
public Productinfopage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}

}
