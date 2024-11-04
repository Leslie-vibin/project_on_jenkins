package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewVendorCreation {
	WebDriver driver=null;
@FindBy(name="vendorname")
private WebElement vendorNAMETXT;
@FindBy(xpath="//input[@type='submit']")
private WebElement savelnk;

public WebElement getVendorNAMETXT() {
	return vendorNAMETXT;
}
public NewVendorCreation(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements( driver,this);
	
}
public WebElement getSavelnk() {
	return savelnk;
}
 
}
