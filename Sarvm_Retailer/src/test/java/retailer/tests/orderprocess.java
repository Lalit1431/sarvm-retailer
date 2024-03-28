package retailer.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import retailer.pageobject.Order;
import retailer.pageobject.SignInpage;
import retailer.pageobject.VerifyOTPpage;
import retailer.pageobject.newhomepage;
import retailer.testcomponent.BaseTest;

public class orderprocess extends BaseTest {
	
	@Test()
	public void approvedOrder() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Order orders = homepage.navigatetoordermanagment();
		boolean isNewTabSelected = orders.verifynewtabselected();
		Assert.assertEquals(isNewTabSelected, false);
		orders.acceptingOrder();
		boolean isacceptedTabSelected = orders.verifyacceptedtab();
		Assert.assertEquals(isacceptedTabSelected, false);
		orders.processingOrder();
		boolean isprocessingTabSelected = orders.verifyprocessingtab();
		Assert.assertEquals(isprocessingTabSelected, false);
		orders.readyorder();
		boolean isreadyTabSelected = orders.verifyreadytab();
		Assert.assertEquals(isreadyTabSelected, false);
		String ordertype=orders.getordertype();
		if (ordertype.equals("DELIVERY") ){
			orders.selfdeliveryassign();
			boolean isdeliveryTabSelected = orders.verifydeliverytab();
			Assert.assertEquals(isdeliveryTabSelected, false);
			orders.selfdeliveryprocess();
	}
		else {
			orders.pickuporder();
			boolean isdeliveryTabSelected = orders.verifydeliverytab();
			Assert.assertEquals(isdeliveryTabSelected, false);
			orders.pickuppayment();    
	}
	}

}
