package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author leslie vibin y
 */
public class OrganizationsPage {
	WebDriver driver;
	@FindBy(xpath="//img[@alt='Create Organization...']")
	WebElement AddnewOrglink;
	@FindBy(xpath="//input[@class='txtBox']")
	WebElement Searchedt;
	@FindBy(id="bas_searchfield")
	WebElement SerachDD;
	@FindBy(name="submit")
	WebElement Searchbtn;
	public WebElement getSearchbtn() {
		return Searchbtn;
	}
	public WebElement getSerachDD() {
		return SerachDD;
	}
	public WebElement getSearchedt() {
		return Searchedt;
	}
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	public WebElement getAddnewOrglink() {
		return AddnewOrglink;
	}
	

}
