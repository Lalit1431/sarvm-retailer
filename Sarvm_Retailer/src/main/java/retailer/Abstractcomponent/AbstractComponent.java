package retailer.Abstractcomponent;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {


	public WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public static Robot robot() throws AWTException {
		 Robot robot = new Robot();
		 return robot;
	}
	
	public static Actions action(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

}
