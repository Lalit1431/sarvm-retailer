package retailer.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class VerifyOTPpage extends AbstractComponent {
	public WebDriver driver;

	public VerifyOTPpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-input[@maxlength='4']")
	WebElement OTPfield;

	@FindBy(xpath = "//input[@type='button']")
	WebElement verify;
	@FindBy(xpath = "//div[@class='otp-btn-disabled']")
	WebElement disableVerify;
	@FindBy(xpath = "//div[@class='otp-btn']")
	WebElement enableVerify;
	@FindBy(xpath = "//ion-button[text()=' SMS']")
	WebElement smsbutton;
	@FindBy(xpath = "(//a[text()=' Terms & Conditions '])[2]")
	WebElement termslink;
	@FindBy(tagName = "h1")
	WebElement termofuse;
	@FindBy(xpath = "(//a[text()=' Privacy Policy'])[2]")
	WebElement privacylinks;

	public newhomepage verifyOTP() throws InterruptedException, AWTException {
		OTPfield.click();
		Robot r = AbstractComponent.robot();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		verify.click();
		newhomepage homepage = new newhomepage(driver);
		return homepage;
	}

	public String getDisableVerifyValue() {
		return disableVerify.getAttribute("class");
	}

	public String getEnableVerifyValue() throws AWTException, InterruptedException {
		OTPfield.click();
		Robot r = AbstractComponent.robot();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_NUMPAD7);
		return enableVerify.getAttribute("class");
	}

	public String getDisableSMSValue() {
		return smsbutton.getAttribute("color");
	}

	public boolean getEnableSMSvalue() {
		waitforelementclickable(smsbutton);
		// Check if the button is enabled after 30 seconds
		boolean isEnabled = smsbutton.isEnabled();
		return isEnabled;
	}

	public String checkTermsandCondLink() throws InterruptedException {
		Actions act = new Actions(driver);
		act.click(termslink).perform();
		// termofuse.click();

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allwindowhandles = driver.getWindowHandles();
		Iterator<String> iterator = allwindowhandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(5000);
				// System.out.println("Heading of child window is " + termofuse.getText());

			}

		}
		return termofuse.getText();
	}

	public String checkpolicylink() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.click(privacylinks).perform();
		// termofuse.click();

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allwindowhandles = driver.getWindowHandles();
		Iterator<String> iterator = allwindowhandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(5000);
			}

		}
		return termofuse.getText();
	}

}