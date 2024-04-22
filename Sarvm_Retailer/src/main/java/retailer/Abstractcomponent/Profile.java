package retailer.Abstractcomponent;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile extends AbstractComponent {

	public WebDriver driver;

	public Profile(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-label[text()=' Shop Address ']")
	WebElement shopaddressbtn;
	@FindBy(xpath = "//ion-input[@id='shop_name']")
	WebElement shopname;
	@FindBy(xpath = "//ion-input[@id='shop_number']")
	WebElement shopnumber;
	@FindBy(xpath = "//ion-input[@id='Building/Locality']")
	WebElement building;
	@FindBy(xpath = "//ion-input[@id='Landmark']")
	WebElement Landmark;
	@FindBy(xpath = "//ion-input[@id='Pincode']")
	WebElement Pincode;
	@FindBy(xpath = "//ion-input[@id='City']")
	WebElement City;
	@FindBy(xpath = "//input[@name='fullName']")
	WebElement fullname;
	@FindBy(xpath = "//input[@name='altMobileNumber']")
	WebElement altMobileNumber;
	@FindBy(xpath = "//textarea[@name='About']")
	WebElement aboutme;
	@FindBy(xpath = "//ion-button[text()='Save changes']")
	WebElement savechangesbtn;
	@FindBy(xpath = "//div[contains(.,'User Data')]")
	WebElement savetoast;
	@FindBy(xpath = "//ion-label[text()=' Help ']")
	WebElement helpbtn;
	@FindBy(xpath = "//p[text()='Terms & Conditions']/parent::ion-col")
	WebElement termsandcondbtn;
	@FindBy(tagName = "h1")
	WebElement termofuse;
	@FindBy(xpath = "//p[text()='Privacy policies']/parent::ion-col")
	WebElement privacypolicybtn;
	@FindBy(xpath = "//p[text()='https://sarvm.ai/']/parent::ion-label")
	WebElement companylink;
	@FindBy(xpath = "//img[@alt='Sarvm.AI']")
	WebElement sarvmlogo;
	@FindBy(xpath = "//p[contains(.,'Karnataka 560001')]/parent::ion-label")
	WebElement companyaddress;

	public void submitShopAddressDetails() throws InterruptedException {
		shopaddressbtn.click();
		Thread.sleep(1000);
		// Create JavaScriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Set value of the input field using JavaScript
		js.executeScript("arguments[0].value = 'New Address'", shopname);
		js.executeScript("arguments[0].value = '459'", shopnumber);
		driver.quit();
	}

	public void editProfile() throws InterruptedException {
		fullname.clear();
		fullname.sendKeys("Lalit Test");
		altMobileNumber.clear();
		altMobileNumber.sendKeys("4578963210");
		aboutme.clear();
		aboutme.sendKeys("my details");
		savechangesbtn.click();
		// Thread.sleep(1000);
		// System.out.println(savetoast.getText());
	}

	public String checkTermsandConditionlink() throws InterruptedException {
		helpbtn.click();
		termsandcondbtn.click();
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

	public String checkPrivacyPolicylink() throws InterruptedException {
		helpbtn.click();
		privacypolicybtn.click();
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

	public String checkcompanylink() throws InterruptedException {
		helpbtn.click();
		companylink.click();
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allwindowhandles = driver.getWindowHandles();
		Iterator<String> iterator = allwindowhandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(5000);
				String value = sarvmlogo.getAttribute("alt");
			}

		}
		return sarvmlogo.getAttribute("alt");
	}

	public String checkcompanyaddress() throws InterruptedException {
		helpbtn.click();
		companyaddress.click();
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
