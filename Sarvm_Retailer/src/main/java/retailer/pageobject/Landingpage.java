package retailer.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class Landingpage extends AbstractComponent{

public WebDriver driver;
	
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ion-card-content[contains( text(), 'English')]")
	WebElement englishlang;
	
	@FindBy(xpath="//h4[text()='Select Language']")
	WebElement selectlanguagetext;
	
	@FindBy(xpath="//ion-button[text()=' Continue ']")
	WebElement cont;
	
	
	public WebElement languageselection() throws InterruptedException {
		Thread.sleep(5000);
		englishlang.click();
		return selectlanguagetext;
	}
	
	public SignInpage continueProcess() {
		cont.click();
		SignInpage signin=new SignInpage(driver);
		return signin;
		
	}
	
	
	public void goTo() {
	driver.get("https://uat-ra.sarvm.ai/selected-language");
	
	}

	
	
}
