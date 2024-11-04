package com.comcast.crm.miscelleneous;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.Basetest.Baseclass;

public class Work_with_Screenshort1 {
	@Test
	public void  screenshort() throws Exception{
	
		
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.youtube.com/");
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	File src=edriver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("./Screenshort/test.png"));
	
	
	 
	}

}
