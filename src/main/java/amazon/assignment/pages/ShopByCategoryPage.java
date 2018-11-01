package amazon.assignment.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import amazon.assignment.util.HelperPage;
import amazon.assignment.util.MobileBasePage;
import io.appium.java_client.android.AndroidDriver;

public class ShopByCategoryPage extends MobileBasePage{
	private AndroidDriver Driver=null;
	private String testName="";
	private final By KINDLE=By.xpath("//a[text()='Kindle E-Readers & eBooks']");
	private final By KINDLEBOOK=By.xpath("//a[text()='Kindle E-Readers & eBooks']");
	public ShopByCategoryPage(AndroidDriver Driver, String testName) {
		this.Driver=Driver;
		this.testName=testName;
		waitForPageLoad();
	}
	
	/**
	 * method to click Kindle
	 * @return
	 * @throws IOException
	 */
	public ShopByCategoryPage clickKindleLink() throws IOException {
		Driver.findElement(KINDLE).click();
		return this;
	}
	/**
	 * method to click Kindle
	 * @return
	 * @throws IOException
	 */
	public ShopByCategoryPage SelectKindleEreadersKindleLink() throws IOException {
		Driver.findElement(KINDLEBOOK).click();
		return this;
	}
	@Override
	public void waitForPageLoad() {
		HelperPage.waitForPageLoad(KINDLE);
	}	
}
