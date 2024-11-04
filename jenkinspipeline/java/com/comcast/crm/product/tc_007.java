package com.comcast.crm.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.Webdriverutility.Javautility;
import com.comcast.crm.generic.Webdriverutility.Webdriverutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class tc_007 {
@Test
	public void createproduct() throws Throwable {
	FileUtility flib =new FileUtility();
	Excelutility elib =new Excelutility();
	Javautility jlib=new Javautility();
	Webdriverutility wlib=new Webdriverutility();
	String browser=flib.getDatafrompropertyfile("browser");
	String url=flib.getDatafrompropertyfile("url");
	String user=flib.getDatafrompropertyfile("username");
	String pass=flib.getDatafrompropertyfile("password");
	//WebDriver driver= null;
	WebDriver driver=jlib.chooseBrowser(browser);
	driver.navigate().to(url);
	driver.get(url);
	wlib.waitforpagetoload(driver, 10);
	driver.findElement(By.name("user_name")).sendKeys(user);
	driver.findElement(By.name("user_password")).sendKeys(pass);
	
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[.='Products']")).click(); 
	driver.findElement(By.xpath("//img[contains(@title,'Create Product...')]")).click();
	String productname=elib.getDatafromexcel("org", 1, 9);
	
	driver.findElement(By.name("productname")).sendKeys(productname);
	driver.findElement(By.xpath("(//tbody/tr/td/div/child::input[@title='Save [Alt+S]'])[1]")).click();
	

	}

}
