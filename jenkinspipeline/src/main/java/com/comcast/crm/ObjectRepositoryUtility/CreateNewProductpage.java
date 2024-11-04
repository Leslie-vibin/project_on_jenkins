package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.Webdriverutility.Webdriverutility;

public class CreateNewProductpage {
	Webdriverutility wlib=new Webdriverutility();
	WebDriver driver=null;
	//name
	@FindBy(name="productname")
	private WebElement productnametxt;
	//dates
	@FindBy(name="start_date")
	private WebElement Startdatelnk;
	
	@FindBy(name="sales_end_date")
	private WebElement enddatelnk;
	@FindBy(name="expiry_date")
	private WebElement expirydatelnk;
	//vendorname
	@FindBy(xpath="//img[@title='Select']")
	private WebElement addvendorlnk;
	@FindBy(id="search_txt")
	private WebElement searchtxt;
	@FindBy(name="search")
	private WebElement searchbtn;
	//uploadproimg
	@FindBy(xpath="//input[@type='file']")
	private WebElement Newfile;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savelnk;
	
public WebElement getSavelnk() {
		return savelnk;
	}


public WebElement getNewfile() {
		return Newfile;
	}


public CreateNewProductpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	

	public WebElement getProductnametxt() {
		return productnametxt;
	}

	public WebElement getStartdatelnk() {
		return Startdatelnk;
	}

	public WebElement getEnddatelnk() {
		return enddatelnk;
	}

	public WebElement getExpirydatelnk() {
		return expirydatelnk;
	}

	public WebElement getAddvendorlnk() {
		return addvendorlnk;
	}
	public void addVendorToproduct(String Vendorname) {
		addvendorlnk.click();
		
		
		wlib.SwitchtoWindowOnURL(driver, "Vendors&action");
		searchtxt.sendKeys(Vendorname);
		searchbtn.click();
		driver.findElement(By.xpath("//a[.='"+Vendorname+"']")).click();
		
		
		
		
	}
	

}
