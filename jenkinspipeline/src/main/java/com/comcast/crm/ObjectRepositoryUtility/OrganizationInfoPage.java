package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver=null;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headertext;
	@FindBy(id="dtlview_Phone")
	private WebElement contact;
	
	public String getHeadertext() {
		return headertext.getText();
	}
	public WebElement getContact() {
		return contact;
	}
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	


}
