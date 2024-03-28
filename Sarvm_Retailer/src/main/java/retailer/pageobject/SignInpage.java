package retailer.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class SignInpage extends AbstractComponent {
	public WebDriver driver;
	
	public SignInpage (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter Mobile Number']")
	WebElement mobilenumber;
	
	@FindBy(xpath="(//ion-button)[2]")
	WebElement getotp;
	
	public  VerifyOTPpage getotp() {
	mobilenumber.sendKeys("4202200200");
	getotp.click();
	VerifyOTPpage verifyotp=new VerifyOTPpage(driver);
	return verifyotp;
	}
}
