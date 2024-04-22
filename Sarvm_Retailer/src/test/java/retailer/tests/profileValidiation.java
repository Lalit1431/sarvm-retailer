package retailer.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import retailer.Abstractcomponent.Profile;
import retailer.pageobject.SignInpage;
import retailer.pageobject.VerifyOTPpage;
import retailer.pageobject.newhomepage;
import retailer.testcomponent.BaseTest;

public class profileValidiation extends BaseTest {

	// verify that retailer is able to reject order from order management screen
	@Test
	public void rejectorder() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Profile profile = homepage.profile();
		profile.submitShopAddressDetails();
	}

	// verify that retailer is able to edit profile or not
	@Test
	public void editProfile() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Profile profile = homepage.profile();
		profile.editProfile();
	}

	// verify that retailer is able to edit profile or not
	@Test
	public void checktermsandcondtion() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Profile profile = homepage.profile();
		String termstext =profile.checkTermsandConditionlink();
		String originalterms="Terms of use";
		Assert.assertEquals(originalterms,termstext);
	}

	@Test
	public void checkprivacypolicy() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Profile profile = homepage.profile();
		String termstext =profile.checkPrivacyPolicylink();
		String originalterms="Privacy Policy";
		Assert.assertEquals(originalterms,termstext);
	}

	@Test
	public void checkCompanyLink() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Profile profile = homepage.profile();
		String termstext =profile.checkcompanylink();
		String originalterms="Sarvm.AI";
		Assert.assertEquals(originalterms,termstext);
	}

	@Test
	public void checkCompanyAddress() throws InterruptedException, AWTException {
		WebElement selectlanguagetext = page.languageselection();
		Assert.assertTrue(selectlanguagetext.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		SignInpage signin = page.continueProcess();
		VerifyOTPpage verifyotp = signin.getotp();
		newhomepage homepage = verifyotp.verifyOTP();
		Profile profile = homepage.profile();
		String termstext =profile.checkcompanyaddress();
		String originalterms="SarvM.AI System Pvt Ltd";
		Assert.assertEquals(originalterms,termstext);
	}

	
}
