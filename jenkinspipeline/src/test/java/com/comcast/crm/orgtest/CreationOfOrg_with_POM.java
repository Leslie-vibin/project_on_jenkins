package com.comcast.crm.orgtest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.Basetest.Baseclass;
import com.comcast.crm.ObjectRepositoryUtility.CreatenewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.Homepage;
import com.comcast.crm.ObjectRepositoryUtility.Login;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationsPage;
import com.comcast.crm.generic.Webdriverutility.Javautility;
import com.comcast.crm.generic.Webdriverutility.Webdriverutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreationOfOrg_with_POM extends Baseclass {

	@Test
	public void createorg() throws Throwable {

		Homepage op = new Homepage(driver);
		op.getOrglink().click();
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getAddnewOrglink().click();
		CreatenewOrganizationPage cno = new CreatenewOrganizationPage(driver);
		String orgname = elib.getDatafromexcel("org", 2, 0) + jlib.generateRandom(1000);
		String industryname = elib.getDatafromexcel("org", 1, 7);
		cno.selectIndustry(industryname);
		cno.createNewName(orgname);
		cno.getSavelink().click();
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.getHeadertext();
		
		//Assert.assertEquals(header, orgname);
	//	Assert.assertTrue(true);
		if (header.contains(orgname)) {
			System.out.println("the names are verified");

		} else {
			System.out.println("tne name  is not wright");
		} 
		op.getOrglink().click();
		org.getSearchedt().sendKeys(orgname);
		wlib.select(org.getSerachDD(), "Organization Name");
		org.getSearchbtn().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='" + orgname + "' and @title='Organizations']/../..//a[.='del']")).click();
		wlib.switchtoalertandAccept(driver);

	}

}
