package com.comcast.crm.generic.Webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {
	
 public void waitforpagetoload(WebDriver driver ,int seconds) {
	 
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds)); 
 }
 public void SwitchtoWindowOnURL(WebDriver driver,String partialurl) {
	 Set<String> children=driver.getWindowHandles();
	Iterator<String> lt= children.iterator();
	while(lt.hasNext()) {
		String url=lt.next();
		   driver.switchTo().window(url);
		  String currenturl=driver.getCurrentUrl();
		if (currenturl.contains(partialurl)) {
			break;
		}
	}
	 
 }
 public void SwitchtoWindowOnTITLE(WebDriver driver,String partialtitle) {
	 Set<String> children=driver.getWindowHandles();
	Iterator<String> lt= children.iterator();
	while(lt.hasNext()) {
		String url=lt.next();
		   driver.switchTo().window(url);
		  String title= driver.getTitle();
		  if (title.contains(partialtitle)) {
			break;
		}
	}
	 
 }
 public void select(WebElement Element,String text) {
	 Select sel=new Select(Element);
	 sel.selectByVisibleText(text);
 }
 public void select(WebElement Element,int index) {Select sel=new Select(Element);
 sel.selectByIndex(index);}
 
 public void explicitlywaitfortheElement(WebDriver driver,WebElement element,int seconds) {
	 WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(seconds));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 
 }
 public void switchToframe(WebDriver driver,int index) {
	 driver.switchTo().frame(index);
 }
 public void switchToframe(WebDriver driver,String nameId) {
	 driver.switchTo().frame(nameId);
 }
 public void switchToframe(WebDriver driver,WebElement element) {
	 driver.switchTo().frame(element);
 }
 public void switchtoParentFrame(WebDriver driver) {driver.switchTo().parentFrame();}


 public void mouseoverElement(WebDriver driver,WebElement element ) {
	 Actions act =new Actions(driver);
	 act.moveToElement(element).perform();
 }
 public void DoubleclickElement(WebDriver driver,WebElement element ) {
	 Actions act =new Actions(driver);
	 act.doubleClick(element).perform();
 }
 public void switchtoalertandAccept(WebDriver driver) {
	 Alert alt=driver.switchTo().alert();
	 alt.accept();
	 
 }
 public void switchtoalertandDismiss(WebDriver driver) {
	 Alert alt=driver.switchTo().alert();
	 alt.dismiss();
	 }
 
 
	 
 }

