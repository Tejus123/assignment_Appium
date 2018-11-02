package amazon.assignment.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import amazon.assignment.flow.KindleFlow;
import amazon.assignment.util.HelperPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KindleTest_Andriod{
	AndroidDriver<AndroidElement> driver;
	String testName="KINDLEAMANZON";
	boolean testStatus=false;
	
	@BeforeTest
	public void initateDriver() throws IOException {
		
		Map<String, Object> phone = HelperPage.formfile(new File("Mobileconfig.properties"));
	
		Capabilities capabilities = HelperPage.setAll(phone).buils();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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
