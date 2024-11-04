package com.comcast.crm.campaigns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.Basetest.Baseclass;
import com.comcast.crm.ObjectRepositoryUtility.Homepage;
import com.comcast.crm.ObjectRepositoryUtility.Login;
import com.comcast.crm.ObjectRepositoryUtility.campaingnspage;
import com.comcast.crm.generic.Webdriverutility.Javautility;
import com.comcast.crm.generic.Webdriverutility.Webdriverutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class Tc_002_POM extends Baseclass{
@Test(groups="st")
	public void camp() throws Throwable {
		
        String browser=flib.getDatafrompropertyfile("browser");
		String url=flib.getDatafrompropertyfile("url");
		String user=flib.getDatafrompropertyfile("username");
		String pass=flib.getDatafrompropertyfile("password");
		WebDriver driver=jlib.chooseBrowser(browser);
		Login lg=new Login(driver);
	    Homepage hp=new Homepage(driver);
	    campaingnspage cp=new campaingnspage(driver);
		
		wlib.waitforpagetoload(driver, 10);
		lg.logintoapp(url,user, pass);
		hp.navigatetoCampaignPage();
		cp.getCamplnk().click();
		

	}

}
