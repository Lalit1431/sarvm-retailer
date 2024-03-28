package retailer.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import retailer.Abstractcomponent.AbstractComponent;

public class Orders extends AbstractComponent{
	public WebDriver driver;
	
	public Orders (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

  //  Orders ord=new Orders(driver);
    
    Actions act=AbstractComponent.action(driver);
    
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
	
	
	public boolean verifynewtabselected() throws InterruptedException {
	 Thread.sleep(10000);
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
	
    public void yespopup() {
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

}
