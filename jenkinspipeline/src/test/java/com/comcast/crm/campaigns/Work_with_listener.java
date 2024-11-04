package com.comcast.crm.campaigns;
/**
 * CLASS FOR  checking extent report,utilityclassobject.
 * @author leslie vibin y
 */
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.Basetest.Baseclass;
import com.comcast.crm.generic.Webdriverutility.Utilityclassobject;
import com.comcast.crm.listenerUtility.Listimp_class2;

@Listeners(com.comcast.crm.listenerUtility.Listimp_class2.class)
public class Work_with_listener extends Baseclass {

	@Test(groups = { "st", "rt" })
	public void createinvoice() {
		// Listimp_class2.test.log(Status.INFO, "starting test case 1");
		Utilityclassobject.getTest().log(Status.INFO, "started using utility");
		System.out.println("execute test 1");
		String var = driver.getTitle();
 		Assert.assertEquals(var, "login");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");

	}

	@Test(groups = { "st", "rt" })
	public void invoicewithcontact() {
		System.out.println("execute test 2");
		Utilityclassobject.getTest().log(Status.INFO, "started using utility case 2");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}
}
