package retailer.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class OrderHistory extends AbstractComponent{
	public WebDriver driver;
	
	public OrderHistory(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//ion-label[text()='Completed']")
	WebElement compeletedtab;
	
	@FindBy(xpath="//ion-label[text()='Rejected']//parent::div")
	WebElement rejectedTab;
	/*@FindBy(xpath="(//p[contains(.,'"+valueAfterColon+"')])")
	WebElement rejectedid;*/
	
	public boolean verifycompletedtabselected() throws InterruptedException {
	Thread.sleep(2000);
	String classAttributeValue = compeletedtab.getAttribute("ng-reflect-ng-class");
	// Check if the "Completed" tab is selected based on the value of ng-reflect-ng-class
	boolean isCompletedTabSelected = classAttributeValue.contains("filterActive");	    
	return  isCompletedTabSelected;
		}
	public String getrejectedid(String mainid) {
	    // Construct the XPath expression
	    String xpathExpression = "(//p[contains(.,'" + mainid + "')])";
	    System.out.println("XPath Expression: " + xpathExpression);

	    // Find the element
	    WebElement element = driver.findElement(By.xpath(xpathExpression));
	    String rejectedidtext = element.getText();
	    System.out.println("Text of the element: " + rejectedidtext);
	    int colonIndex = rejectedidtext.indexOf(":"); // Find the index of colon
		String valueAfterColon = rejectedidtext.substring(colonIndex + 2);
		return valueAfterColon;

	}
	
	
	public void selectrejectedtab() {
		rejectedTab.click();
	}

	
	
	
}
