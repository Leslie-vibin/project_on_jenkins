package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendorspage {
	WebDriver driver = null;
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement AddnewVendor;
public Vendorspage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements( driver,this);
	}
public WebElement getAddnewVendor() {
	return AddnewVendor;
}
}
