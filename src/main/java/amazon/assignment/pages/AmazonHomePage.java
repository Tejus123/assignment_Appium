package amazon.assignment.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import amazon.assignment.util.HelperPage;
import amazon.assignment.util.MobileBasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AmazonHomePage extends MobileBasePage{
	private AndroidDriver<AndroidElement> driver=null;
	private String testName="";
	private final By HAMBURGERMENU =By.xpath("//*[@text='Show Navigation Menu']");
	private final By CATEGORY =By.xpath("//*[@text='Shap by Category']");
	public AmazonHomePage(AndroidDriver<AndroidElement> driver, String testName) {
		this.driver=driver;
		this.testName=testName;
		waitForPageLoad();
	}
	
		/**
	 * method to click Shop By Department
	 * @return
	 * @throws IOException
	 */
	public AmazonHomePage clickShopByDepartment() throws IOException {
		driver.findElement(HAMBURGERMENU).click();
		
		return this;
	}
	/**
	 * method to click on category
	 * @return
	 * @throws IOException
	 */
	
	public AmazonHomePage ClickOnCategoty() {
		driver.findElement(CATEGORY).click();
		return this;
	}
	@Override
	public void waitForPageLoad() {
		HelperPage.waitForPageLoad(HAMBURGERMENU);
	}

	
}
