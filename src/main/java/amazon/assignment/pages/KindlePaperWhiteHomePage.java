package amazon.assignment.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import amazon.assignment.util.HelperPage;
import amazon.assignment.util.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KindlePaperWhiteHomePage extends MobileBasePage{
	private AppiumDriver driver=null;
	private String testName="";
	private final By QUANTITY=By.id("quantity");
	private final By KINDLEREADEBLACK=By.xpath("//a[text()='Kindle E-Readers - Black,6 Glare-Free Touchscreen Display,wi - fi']");
	private final By BUYNOW=By.xpath("//a[text()='Buy Now']");
	
	private final By CLOSE=By.xpath("//text[@aria-label='Close']");
	
	public KindlePaperWhiteHomePage(AndroidDriver<AndroidElement> driver, String testName) {
		this.driver = driver;
		this.testName=testName;
		waitForPageLoad();
	}
	
	/**
	 * method to Click Kindle device	 * @return
	 * @throws IOException
	 */
	public KindlePaperWhiteHomePage verifyKidledevice() throws IOException {
		driver.findElement(KINDLEREADEBLACK).click();
		Dimension size = driver.manage().window().getSize();
		int starty=(int)(size.height.5);
		int endy=(int)(size.height.2);
		int startx=size.width/2;
		driver.swipe(startx,endy,startx,starty,2000);
		Assert.assertTrue("Buy Now is not displayed", driver.findElement(BUYNOW).isDisplayed());
	}	
	
	
	
	@Override
	public void waitForPageLoad() {
		HelperPage.waitForPageLoad(KINDLEREADEBLACK);
	}
	
}
