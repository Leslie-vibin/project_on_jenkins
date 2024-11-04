package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.*;
/**
 * @author leslie vibin y
 */
public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	@FindBy(linkText="Organizations")
	WebElement orglink;
	
	@FindBy(linkText="Contacts")
	WebElement contactlink;
	@FindBy(linkText="Campaigns")
	WebElement campaignlink;
	@FindBy(linkText="More")
	WebElement Morelink;
	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']")
	private WebElement logout;
	@FindBy(linkText="Sign Out")
	private WebElement Signout;
	@FindBy(linkText="Documents")
	private WebElement doclink;
	@FindBy(linkText="Vendors")
	private WebElement vendorlink;
	@FindBy(linkText="Products")
	private WebElement productlink;
	public WebElement getProductlink() {
		return productlink;
	}
	public WebElement getDoclink() {
		return doclink;
	}
	public WebElement getOrglink() {
		return orglink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	public WebElement getCampaignlink() {
		
		return campaignlink;
	}
	public void navigatetoCampaignPage() {
		Actions act =new Actions(driver);
		act.moveToElement(Morelink).perform();
		
		campaignlink.click();
		
	}
	public void navigatetoVendorsPage() {
		Actions act =new Actions(driver);
		act.moveToElement(Morelink).perform();
		
		vendorlink.click();
		
	}
	public void signout() {Actions act =new Actions(driver);
	act.moveToElement(logout).perform();

	
	Signout.click();
		}
	
	
	

}
