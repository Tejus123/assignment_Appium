package amazon.assignment.test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import amazon.assignment.flow.KindleFlow;
import amazon.assignment.util.HelperPage;
import io.appium.java_client.android.AndroidDriver;

public class KindleTest_Andriod{
	AndroidDriver driver;
	String testName="KINDLEAMANZON";
	boolean testStatus=false;
	
	@BeforeTest
	public void initateDriver() throws IOException {
		String Broswer = HelperPage.readData(testName,"BROWSER");
		String url=HelperPage.readData(testName,"URL");
	
		DesiredCapabilities capabilities = HelperPage.Runcababilities(testName );
		driver = new AndroidDriver(new URL(url), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
	}

	@Test
	public void kindleTest() throws Exception {
		try {
			KindleFlow flow=new KindleFlow(driver, testName);
			flow.kindlePaperWhiteFlow();
			testStatus=true;
		}catch(Exception e) {
			throw e;
		}
	}

	@AfterClass
	public void closeBrowser() throws IOException, InterruptedException {
		HelperPage.screenShot(testName,testStatus,driver);
	}

}
