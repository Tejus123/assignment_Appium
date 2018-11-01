package amazon.assignment.flow;

import java.io.IOException;

import amazon.assignment.pages.AmazonHomePage;
import amazon.assignment.pages.KindlePaperWhiteHomePage;
import amazon.assignment.pages.ShopByCategoryPage;
import io.appium.java_client.android.AndroidDriver;

public class KindleFlow {
	private AndroidDriver Driver;
	private String testName = "";

	public KindleFlow(AndroidDriver Driver, String testName) {
		this.Driver = Driver;
		this.testName = testName;
	}
	
	/**
	 * Method for Kindle PaperWhite add to cart flow 
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public void kindlePaperWhiteFlow() throws IOException, InterruptedException{
		AmazonHomePage homepage=new AmazonHomePage(Driver, testName);
		homepage.clickShopByDepartment();
		homepage.ClickOnCategoty();
		ShopByCategoryPage department=new ShopByCategoryPage(Driver, testName);
		department.clickKindleLink();
		department.SelectKindleEreadersKindleLink();
		KindlePaperWhiteHomePage paper=new KindlePaperWhiteHomePage(Driver, testName);
		paper.VerifyKidledevice();
	}


}
