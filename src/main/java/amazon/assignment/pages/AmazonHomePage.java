package amazon.assignment.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import amazon.assignment.util.HelperPage;
import amazon.assignment.util.MobileBasePage;
import io.appium.java_client.android.AndroidDriver;

public class AmazonHomePage extends MobileBasePage{
	private AndroidDriver Driver=null;
	private String testName="";
	private final By HAMBURGERMENU =By.xpath("//*[@text='Show Navigation Menu']");
	private final By CATEGORY =By.xpath("//*[@text='Shap by Category']");
	public AmazonHomePage(AndroidDriver Driver, String testName) {
		this.Driver=Driver;
		this.testName=testName;
		waitForPageLoad();
	}
	
		/**
	 * method to click Shop By Department
	 * @return
	 * @throws IOException
	 */
	public AmazonHomePage clickShopByDepartment() throws IOException {
		Driver.findElement(HAMBURGERMENU).click();
		
		return this;
	}
	public AmazonHomePage ClickOnCategoty() {
		Driver.findElement(CATEGORY).click();
		return this;
	}
	@Override
	public void waitForPageLoad() {
		HelperPage.waitForPageLoad(HAMBURGERMENU);
	}

	
}
