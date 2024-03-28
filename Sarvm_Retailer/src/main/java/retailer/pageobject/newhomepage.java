package retailer.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class newhomepage extends AbstractComponent {

	public WebDriver driver;
	public newhomepage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//div[text()='Order Management']")
	WebElement ordermanagment;
	
    
	public Order navigatetoordermanagment() throws InterruptedException {
		Thread.sleep(5000);
		ordermanagment.click();
		Thread.sleep(2000);
		Order orders = new Order(driver);
		return orders;
		
	}
}
	
	
