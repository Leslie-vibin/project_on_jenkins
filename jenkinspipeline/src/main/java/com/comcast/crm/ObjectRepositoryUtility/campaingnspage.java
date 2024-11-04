package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaingnspage {
	WebDriver driver=null;
@FindBy(xpath="//img[@title='Create Campaign...']")
private WebElement  camplnk;

public WebElement getCamplnk() {
	return camplnk;
}
public campaingnspage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this );
}
}
