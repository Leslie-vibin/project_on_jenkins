package com.comcast.crm.document;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.Basetest.Baseclass;
import com.comcast.crm.ObjectRepositoryUtility.Documentspage;
import com.comcast.crm.ObjectRepositoryUtility.Homepage;
import com.comcast.crm.ObjectRepositoryUtility.Login;
import com.comcast.crm.ObjectRepositoryUtility.createNewDocumentpage;
import com.comcast.crm.generic.Webdriverutility.Javautility;
import com.comcast.crm.generic.Webdriverutility.Webdriverutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class tc_008_pom extends Baseclass {
@Test(groups="rt")
	public void createdoc(Method mtd) throws Throwable {
		Reporter.log(mtd.getName()+"test start",true);
		Reporter.log("start of home page",true);
		Homepage hp = new Homepage(driver);
		Documentspage dp = new Documentspage(driver);
		createNewDocumentpage cnd = new createNewDocumentpage(driver);
		hp.getDoclink().click();
		dp.getNewdoclink().click();
		String doc = elib.getDatafromexcel("org", 5, 0);
		cnd.tiletext(doc);
		wlib.switchToframe(driver, 0);
		String data = elib.getDatafromexcel("org", 1, 11);
		cnd.WriteonDescription(data);
		wlib.switchtoParentFrame(driver);
		cnd.getSavelink().click();
		Reporter.log(mtd.getName()+"test End",true);
       
	}

}
