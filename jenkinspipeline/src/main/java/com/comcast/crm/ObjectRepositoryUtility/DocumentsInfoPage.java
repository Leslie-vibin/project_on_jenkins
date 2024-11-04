package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DocumentsInfoPage {
	WebDriver driver=null;
	public DocumentsInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}

}
