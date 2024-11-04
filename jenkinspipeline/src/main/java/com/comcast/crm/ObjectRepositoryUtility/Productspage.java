package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productspage {
	WebDriver driver=null;
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement addnewProductlnk;
public Productspage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
public WebElement getAddnewProductlnk() {
	return addnewProductlnk;
}

}
