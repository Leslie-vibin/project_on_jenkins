package com.comcast.crm.contacttest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
/**
 * @author leslie vibin y  
 */
public class Assert_working extends Baseclass{
@Test(groups="st")
	public void createcontact() throws Throwable {
	String orgname=elib.getDatafromexcel("org", 2, 0)+jlib.generateRandom(1000);
	String contact=elib.getDatafromexcel("org", 2, 6);
	String type=elib.getDatafromexcel("org", 2, 7);
	String rating=elib.getDatafromexcel("org", 2, 8);
	String accounttype=elib.getDatafromexcel("org",1, 10);
	Homepage home=new Homepage(driver);
	home.getOrglink().click();
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getAddnewOrglink().click();
	CreatenewOrganizationPage cnp=new CreatenewOrganizationPage(driver);
	cnp.createNewName(orgname);
	cnp.selectIndustry(type);
	cnp.Enterphonenumber(contact);
	cnp.selectrating(rating);
	cnp.selectaccounttype(accounttype);
	cnp.getSavelink().click();
	
	OrganizationInfoPage cip=new OrganizationInfoPage(driver);
    
	String header=cip.getHeadertext();
	Boolean status=header.contains(orgname);
	//Assert.assertEquals(status,true);
	Assert.assertTrue(status);
//	if (header.contains(orgname)) {System.out.println("the names are verified");
//		
//	}else {System.out.println("not verified");}
    String confirmno=cip.getContact().getText();
    SoftAssert assobj =new SoftAssert();
    assobj.assertEquals(confirmno, contact);
    assobj.assertAll();
//    if (confirmno.contains(contact)) {System.out.println("verifiednumber");
//		}
//    else {System.out.println("not verifiednumber");}
 
    }
}
