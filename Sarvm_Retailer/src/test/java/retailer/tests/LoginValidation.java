package retailer.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import retailer.pageobject.SignInpage;
import retailer.pageobject.VerifyOTPpage;
import retailer.testcomponent.BaseTest;

public class LoginValidation extends BaseTest {

	@Test
	public void checkVerifygetEnabled() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		String maindisablevalue="otp-btn-disabled";
		String disablevalue = verifyotp.getDisableVerifyValue();
		Assert.assertEquals(maindisablevalue,disablevalue);
		String mainenablevalue="otp-btn";
		String enablevalue = verifyotp.getEnableVerifyValue();
		Assert.assertEquals(mainenablevalue, enablevalue);	
	}
	
	@Test
	public void checkSMSgetenabled() throws InterruptedException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		String maindisablesmsvalue="medium";
		String disablesmsvalue=verifyotp.getDisableSMSValue();
		Assert.assertEquals(maindisablesmsvalue,disablesmsvalue);
		boolean isEnabled = verifyotp.getEnableSMSvalue();
		Assert.assertTrue(isEnabled, "Send SMS button is not enabled after 30 seconds");
	}
	
	@Test
	public void checktermslinks() throws InterruptedException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		String originalterms="Terms of use";
		String termstext = verifyotp.checkTermsandCondLink();
		Assert.assertEquals(originalterms,termstext);
	}
	
	
	@Test
	public void checkpolicylinks() throws InterruptedException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		String originalterms="Privacy Policy";
		String termstext = verifyotp.checkpolicylink();
		Assert.assertEquals(originalterms,termstext);
	
}

}