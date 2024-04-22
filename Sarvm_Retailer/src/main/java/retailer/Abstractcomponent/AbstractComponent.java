package retailer.Abstractcomponent;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {


	public WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/profile']")
	WebElement profilebtn;
	
	public Profile profile() throws InterruptedException {
		Thread.sleep(2000);
		profilebtn.click();
		Profile profile=new Profile(driver);
		return profile;
	}

	public static Robot robot() throws AWTException {
		Robot r=new Robot();
		return r;
	}
	
	public void waitforelementclickable(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(findby));
	}

}
