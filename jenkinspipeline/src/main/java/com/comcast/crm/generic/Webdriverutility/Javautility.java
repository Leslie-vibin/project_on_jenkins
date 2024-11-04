package com.comcast.crm.generic.Webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Javautility {
	WebDriver driver= null;
public int generateRandom(int limit) {
	Random ran=new Random();
	int number=ran.nextInt(limit);
	return number;
}
public String getSystemdate() {
	Date date =new Date();
    SimpleDateFormat date1=new SimpleDateFormat("YYYY-MM-dd");
   String startdate= date1.format(date);       
    return startdate;
}
public String  getrequrieddDate(int days) {
Date date =new Date();
 SimpleDateFormat date1=new SimpleDateFormat("YYYY-MM-dd");
 String startdate= date1.format(date);
   Calendar calender=date1.getCalendar();
   calender.add(calender.DAY_OF_MONTH, days);
  String enddate= date1.format(calender.getTime());
	return enddate;
}
public WebDriver chooseBrowser(String browser)
{
	if(browser.equalsIgnoreCase("chrome"))
{
	driver=new ChromeDriver();
	return driver;
	
}
if(browser.equalsIgnoreCase("edge"))
{
	driver=new EdgeDriver();
	return driver;
}
if(browser.equalsIgnoreCase("firefox"))
{
	driver=new FirefoxDriver();
	return driver;
}
return driver;
}

}
