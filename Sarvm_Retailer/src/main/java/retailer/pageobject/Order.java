package retailer.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class Order extends AbstractComponent{

	public WebDriver driver;
	public Order(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//ion-segment-button[@ng-reflect-value='new']")
	WebElement newTab;
	@FindBy(xpath="(//div[@class='orderDetails'])[1]//ion-button[text()='Accept']")
	WebElement acceptbtn;
	@FindBy(xpath="//ion-button[text()='Ok']")
	WebElement OKbtn;
	@FindBy(xpath="(//ion-label[text()='Accepted'])[3]")
	WebElement acceptedTab;
	@FindBy(xpath="//ion-button[text()='Process']")
	WebElement processBtn;
	@FindBy(xpath="//span[text()='Process']")
	WebElement processBtn2;
	@FindBy(xpath="(//ion-label[text()='Processing'])[4]")
	WebElement processingTab;
	@FindBy(xpath="(//ion-button[text()='Ready'])[2]")
	WebElement ready;
	@FindBy(xpath="//span[text()='Ready']")
	WebElement ready2;
	@FindBy(xpath = "(//ion-label[text()='Ready'])[2]")
	WebElement readyTab;
	@FindBy(xpath="(//ion-card[@class='card ion-margin-bottom md hydrated']//span[@class='status-text'])[4]")
	WebElement ordertype;
	@FindBy(xpath="(//ion-button[text()='Dispatch'])[2]")
	WebElement dispatch;
	@FindBy(xpath = "//span[text()='Dispatch']")
	WebElement dispatchbtn;
	@FindBy(xpath="//p[text()='Me']")
	WebElement me;
	@FindBy(xpath="(//ion-label[text()='Delivery'])[4]")
	WebElement deliveryTab;
	@FindBy (xpath="//ion-button[text()='Start Delivery']")
	WebElement startdelivery;
	@FindBy(xpath="//ion-button[text()='Yes']")
	WebElement yes;
	@FindBy(xpath="//ion-button[text()='Reached Delivery Location']")
	WebElement reachedlocation;
	@FindBy(xpath="//ion-button[text()='Delivered ']")
	WebElement delivered;
	@FindBy(xpath="(//ion-button[text()=' Payment Received ? '])")
	WebElement paymentreceived;
	@FindBy(xpath="(//ion-button[text()='Pickup'])[2]")
	WebElement pck;
	@FindBy(xpath="//span[text()='Pickup']")
	WebElement pickupbtn;
	
	public boolean verifynewtabselected() throws InterruptedException {
		 Thread.sleep(5000);
	     String newclassAttributeValue = newTab.getAttribute("class");
	     boolean isNewTabSelected = newclassAttributeValue.contains("segment-button-after-checked");
	     return  isNewTabSelected;
	     
		}
	public void acceptingOrder() {
	    acceptbtn.click();
	    OKbtn.click();
	    driver.switchTo().activeElement();
	    driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();
	    
		}
	public boolean verifyacceptedtab() {
		   String acceptedclassAttributeValue = acceptedTab.getAttribute("class");
		   boolean isacceptedTabSelected = acceptedclassAttributeValue.contains("segment-button-after-checked");
		    return isacceptedTabSelected;
		    }
	public void processingOrder() throws InterruptedException {
        processBtn.click();
        Thread.sleep(1000);
        driver.switchTo().activeElement();
        Thread.sleep(1000);
        Actions act=new Actions(driver);
        act.click(processBtn2).perform();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();
      	}	
	public boolean verifyprocessingtab(){
	    String processingclassAttributeValue = processingTab.getAttribute("class");
	    boolean isprocessingTabSelected = processingclassAttributeValue.contains("segment-button-after-checked");
	   return isprocessingTabSelected;
	    }
	public void readyorder() throws InterruptedException {
		ready.click();
		Thread.sleep(1000);
	    driver.switchTo().activeElement();
	    Actions act=new Actions(driver);
	    act.click(ready2).perform();
	    Thread.sleep(1000);  
	    driver.switchTo().activeElement();
	    driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();
	   }
	public boolean verifyreadytab() {
		   String readyclassAttributeValue = readyTab.getAttribute("class");
		   boolean isreadyTabSelected = readyclassAttributeValue.contains("segment-button-after-checked");
			return isreadyTabSelected;
	}
	public String getordertype() {
		String ordertyp = ordertype.getText();
		return ordertyp;
	}
	public void selfdeliveryassign() throws InterruptedException {
		Thread.sleep(2000);
		Actions act1=new Actions(driver);
		act1.click(dispatch).perform();
	    driver.switchTo().activeElement();
	    act1.click(dispatchbtn).perform();
	    driver.switchTo().activeElement();
	    me.click();
	}
	public boolean verifydeliverytab() {
    String deliveryclassAttributeValue = deliveryTab.getAttribute("class");
    boolean isdeliveryTabSelected = deliveryclassAttributeValue.contains("segment-button-after-checked");
	return isdeliveryTabSelected;
		  }
	public void selfdeliveryprocess() {
	startdelivery.click();
	driver.switchTo().activeElement();
    yes.click();
    reachedlocation.click();
	driver.switchTo().activeElement();
    yes.click();
    delivered.click();
	driver.switchTo().activeElement();
	yes.click();
	paymentreceived.click();
    driver.switchTo().activeElement();
    yes.click();
	}
	public void pickuporder() throws InterruptedException {
	Thread.sleep(2000);
	Actions act2=new Actions(driver);
	act2.click(pck).perform();
    driver.switchTo().activeElement();
    act2.click(pickupbtn).perform();
    driver.switchTo().activeElement();
    yes.click();
    }
	
	public void pickuppayment() {
		paymentreceived.click();
	    driver.switchTo().activeElement();
	    yes.click();
	}
	}






