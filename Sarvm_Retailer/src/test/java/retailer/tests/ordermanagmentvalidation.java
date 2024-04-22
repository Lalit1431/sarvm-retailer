package retailer.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import retailer.pageobject.Order;
import retailer.pageobject.OrderHistory;
import retailer.pageobject.SignInpage;
import retailer.pageobject.VerifyOTPpage;
import retailer.pageobject.newhomepage;
import retailer.testcomponent.BaseTest;

public class ordermanagmentvalidation extends BaseTest{
	
	
	//verify that retailer is able to reject order from order management screen
	@Test
	public void rejectorder() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Order orders = homepage.navigatetoordermanagment();
		boolean isNewTabSelected = orders.verifynewtabselected();
		Assert.assertEquals(isNewTabSelected, false);
		String orderid = orders.getorderid();
		System.out.println(orderid);
		orders.rejectorder();
		OrderHistory history = orders.navigatetoOrderhistory();
		//boolean isCompletedTabSelected= history.verifycompletedtabselected();
		//System.out.println(isCompletedTabSelected);
		history.selectrejectedtab();
		String rejectidtext=history.getrejectedid(orderid);
		System.out.println(rejectidtext);
		Assert.assertEquals(rejectidtext, orderid);
	}

}
