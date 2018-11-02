package amazon.assignment.flow;

import java.io.IOException;

import amazon.assignment.pages.AmazonHomePage;
import amazon.assignment.pages.KindlePaperWhiteHomePage;
import amazon.assignment.pages.ShopByCategoryPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KindleFlow {
	private AndroidDriver driver;
	private String testName = "";

	public KindleFlow(AndroidDriver<AndroidElement> Driver, String testName) {
		this.driver = driver;
		this.testName = testName;
	}
	
	/**
	 * Method for Kindle PaperWhite add to cart flow 
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void kindlePaperWhiteFlow() throws IOException, InterruptedException{
		AmazonHomePage homepage=new AmazonHomePage(driver, testName);
		homepage.clickShopByDepartment();
		homepage.ClickOnCategoty();
		ShopByCategoryPage department=new ShopByCategoryPage(driver, testName);
		department.clickKindleLink();
		department.SelectKindleEreadersKindleLink();
		KindlePaperWhiteHomePage paper=new KindlePaperWhiteHomePage(driver, testName);
		paper.VerifyKidledevice();
	}


}
