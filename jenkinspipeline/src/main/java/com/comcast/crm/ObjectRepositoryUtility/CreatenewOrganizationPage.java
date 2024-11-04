package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatenewOrganizationPage {
	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement OrganizationnametextLink;
	@FindBy(name="industry")
	private WebElement industrynametextlink;
	@FindBy(xpath="(//input [@title='Save [Alt+S]'])[1]")
	private WebElement savelink;
	
	@FindBy(id="phone")
	private WebElement phonelink;
	@FindBy(name="rating")
	private WebElement rateing;
	@FindBy(name="accounttype")
	private WebElement accounttype;
			
			
			
	
	public WebElement getRateing() {
		return rateing;
	}
	
	public WebElement getAccounttype() {
		return accounttype;
	}
	
	public WebElement getPhonelink() {
		return phonelink;
	}
	public void setPhonelink(WebElement phonelink) {
		this.phonelink = phonelink;
	}
	public CreatenewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	public WebElement getOrganizationnametextLink() {
		return OrganizationnametextLink;
	}
	public WebElement getIndustrynametextlink() {
		return industrynametextlink;
	}
	public WebElement getSavelink() {
		return savelink;
	}
	public void selectIndustry(String Industryname) {
		Select sel=new Select(industrynametextlink);
		sel.selectByVisibleText(Industryname);
	}

    public void createNewName(String orgname) {
   OrganizationnametextLink.sendKeys(orgname);
   }
  
   
		public void Enterphonenumber(String phn) {
		phonelink.sendKeys(phn);
	}
	public void selectrating(String rating) {
		Select sel=new Select(rateing);
		sel.selectByVisibleText(rating);
	}
	public void selectaccounttype(String accounttypename) {
		Select sel=new Select(accounttype);
		sel.selectByVisibleText(accounttypename);
	}

}
