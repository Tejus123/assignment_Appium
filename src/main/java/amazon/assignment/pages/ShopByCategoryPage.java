package amazon.assignment.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import amazon.assignment.util.HelperPage;
import amazon.assignment.util.MobileBasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ShopByCategoryPage extends MobileBasePage{
	private AndroidDriver driver=null;
	private String testName="";
	private final By KINDLE=By.xpath("//a[text()='Kindle E-Readers & eBooks']");
	private final By KINDLEBOOK=By.xpath("//a[text()='Kindle E-Readers & eBooks']");
	public ShopByCategoryPage(AndroidDriver<AndroidElement> driver, String testName) {
		this.driver=driver;
		this.testName=testName;
		waitForPageLoad();
	}
	
	/**
	 * method to click Kindle
	 * @return
	 * @throws IOException
	 */
	public ShopByCategoryPage clickKindleLink() throws IOException {
		driver.findElement(KINDLE).click();
		return this;
	}
	/**
	 * method to click Kindle search
	 * @return
	 * @throws IOException
	 */
	public ShopByCategoryPage SelectKindleEreadersKindleLink() throws IOException {
		driver.findElement(KINDLEBOOK).click();
		return this;
	}
	@Override
	public void waitForPageLoad() {
		HelperPage.waitForPageLoad(KINDLE);
	}	
}
