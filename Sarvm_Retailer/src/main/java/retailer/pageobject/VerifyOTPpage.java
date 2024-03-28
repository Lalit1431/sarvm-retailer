package retailer.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class VerifyOTPpage extends AbstractComponent{
	public WebDriver driver;
	
	public VerifyOTPpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ion-input[@maxlength='4']")
	WebElement OTPfield;
	
	@FindBy(xpath="//input[@type='button']")
	WebElement verify;
	
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
		 newhomepage homepage=new newhomepage(driver);
		 return homepage;
				 
		 
	}
	
}
