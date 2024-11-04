package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewDocumentpage {
	WebDriver driver=null;
	@FindBy(name="notes_title")
	WebElement titlelnk;
	@FindBy(xpath="(//input [@title='Save [Alt+S]'])[1]")
	private WebElement savelink;
	@FindBy(xpath="//html[@dir='ltr']")
	private WebElement Description;
	public WebElement getSavelink() {
		return savelink;
	}
	public WebElement getTitlelnk() {
		return titlelnk;
	}
	public createNewDocumentpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this );
	}
	public void tiletext(String title) {
		titlelnk.sendKeys(title);
	}
	public void WriteonDescription(String data) {
		Description.sendKeys(data);
	}

}
