package com.comcast.crm.Basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.ObjectRepositoryUtility.Homepage;
import com.comcast.crm.ObjectRepositoryUtility.Login;
import com.comcast.crm.generic.Webdriverutility.Javautility;
import com.comcast.crm.generic.Webdriverutility.Utilityclassobject;
import com.comcast.crm.generic.Webdriverutility.Webdriverutility;
import com.comcast.crm.generic.databaseutility.Databaseutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class Baseclass {
	public Databaseutility dlib=new Databaseutility();
	public FileUtility flib=new FileUtility();
	public Javautility jlib= new Javautility();
	public Webdriverutility wlib =new Webdriverutility();
	public WebDriver driver;
	public static WebDriver sdriver;
	public Excelutility elib =new Excelutility();
	

	@BeforeSuite(groups= {"st","rt"})
	public void configbsuite() throws SQLException
	{System.out.println("db connect");
		dlib.getDBconnection();
	}
//@Parameters("BROWSER")
	@BeforeClass(groups= {"st","rt"})
	public void configbc() throws Throwable
	{
		System.out.println(" launch browser");
	 // String browser=flib.getDatafrompropertyfile("browser");
		String browser=System.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
	sdriver=driver;
	Utilityclassobject.setdriver(driver);
	}
	@AfterClass(groups= {"st","rt"})
	public void configAc()
	{
		System.out.println(" close browser");
		driver.quit();
		
	}
	@BeforeMethod(groups= {"st","rt"})
	public void configbm() throws Throwable
	{     
		System.out.println(" login");
		String url=flib.getDatafrompropertyfile("url");
		String username=flib.getDatafrompropertyfile("username");
		String pass=flib.getDatafrompropertyfile("password");
		//String username=System.getProperty("username");
				//String pass=System.getProperty("password");
		Login lp=new Login(driver);
		lp.logintoapp(url, username, pass);
	}
	@AfterMethod(groups= {"st","rt"})
	public void configam()
	{
		System.out.println("logout");
		Homepage hp=new Homepage(driver);
		hp.signout();
	}
	@AfterSuite(groups= {"st","rt"})
	public void configAftersuite() throws SQLException
	{     System.out.println("db disconnect  ");
		dlib.colseDbconnection();
	}


}
