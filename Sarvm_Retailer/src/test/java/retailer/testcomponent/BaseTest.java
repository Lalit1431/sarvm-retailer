package retailer.testcomponent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import retailer.pageobject.Landingpage;

public class BaseTest {
	public WebDriver driver;
	public Landingpage page;
	
	public WebDriver intializeDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;	
	}
	
	@BeforeMethod(alwaysRun = true)
	public Landingpage launchApplication() {
		driver=intializeDriver();
		page=new Landingpage(driver);
		page.goTo();
		return page;
	}
	
	/*@AfterMethod(alwaysRun = false)
	public void closeapplication() {
		driver.close();
	}*/
	

}
