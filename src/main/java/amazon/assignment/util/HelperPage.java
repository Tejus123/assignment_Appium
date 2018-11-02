package amazon.assignment.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HelperPage {
	
	static AndroidDriver<AndroidElement> driver;
	static String filePath="src/main/java/amazon/assignment/data";
	static String sheetName="TestData";
	private final DesiredCapabilities capabilities = new DesiredCapabilities();
	public Capabilities buils ()
	{
		return capabilities;
	}
	/**
	 * method to set Enviroment
	 * To be called in @BeforeClass
	 * @return 
	 * @return 
	 */
	
	
	public static WebDriver setEnvironment(WebDriver webDriver,String BrowserName ) { 
		
		if (BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Softwares\\chromedriver\\chromedriver.exe");
			webDriver = new ChromeDriver();
			return webDriver;
		}
		else if(BrowserName.equalsIgnoreCase("Safari"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Softwares\\chromedriver\\chromedriver.exe");
			webDriver = new SafariDriver();	
		}
		else if(BrowserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Softwares\\chromedriver\\chromedriver.exe");
			webDriver = new FirefoxDriver();	
		}
		else if (BrowserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.IE.driver","D:\\Selenium Softwares\\IEDriverServer_x64_3.8.0\\IEDriverServer.exe");
			webDriver = new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("Please select proper browser");
		}
		return webDriver;
		
	}
	
	
	
	
	
	
	public static Map<String, Object> formfile(File file)
	{
		try 
		{
		return fromStreams(new FileInputStream(file));	
		}
		catch(FileNotFoundException  e)
		{
			throw new RuntimeException(e);
			
		}
	}
	
	public static Map<String, Object> fromStreams(InputStream is)
	{
		try 
		{
			Properties properties = new Properties();
			properties.load(is);
			is.close();
		return fromProperties(properties);	
		}
		catch(IOException  e)
		{
			throw new RuntimeException(e);
			
		}
	}
	public static Map<String, Object> fromProperties(Properties properties)
	{
		Map<String, Object> map = new HashMap<>(properties.size());
		for (Object Key: properties.keySet())
		{
			map.put((String) Key,properties.getProperty( (String) Key));
		}
		return map;
		
	}
	/**
	 * Reading data from Excel based on Column Name
	 * @param fileName
	 * @return 
	 * @throws IOException 
	 */
	public static String readData(String fileName,String ColumnName) throws IOException {
		int count=0;
		File file =    new File(filePath+"\\"+fileName+".xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			if(sheet.getRow(0).getCell(k).getStringCellValue().equals(ColumnName) ){
				count=k;
				break;
			}
		}
		return sheet.getRow(1).getCell(count).getStringCellValue();
	}
	
	/**
	 * Reading Numeric(Like phone number) from Excel based on Column Name
	 * @param fileName
	 * @return 
	 * @throws IOException 
	 */
	public static String readNumData(String fileName,String ColumnName) throws IOException {
		int count=0;
		File file =    new File(filePath+"\\"+fileName+".xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			if(sheet.getRow(0).getCell(k).getStringCellValue().equals(ColumnName) ){
				count=k;
				break;
			}
		}
		int d=(int) sheet.getRow(1).getCell(count).getNumericCellValue();
		String value=Integer.toString(d);
		return value;
	}
	
	/**
	 * Reading date from Excel based on Column Name 
	 * @param fileName
	 * @return 
	 * @throws IOException 
	 */
	public static String readDate(String fileName,String ColumnName) throws IOException {
		int count=0;
		File file =    new File(filePath+"\\"+fileName+".xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			if(sheet.getRow(0).getCell(k).getStringCellValue().equals(ColumnName) ){
				count=k;
				break;
			}
		}
		Date date=sheet.getRow(1).getCell(count).getDateCellValue();
		DateFormat dateFormat=new SimpleDateFormat("mm-dd-yyyy");
		String value=dateFormat.format(date);
		return value;
	}
	
	
	
	public static HelperPage   setAll(Map<String,Object> devicePropeties)
	{
		for(String key: devicePropeties.keySet())
		{
			String value =(String) devicePropeties.get(key);
			if(StringUtils.equalsIgnoreCase(value,"true")||StringUtils.equalsIgnoreCase(value,"false"));
			{
				Capabilities.setCapability(key,Boolean.parseBoolean(value));
			}
			else	
			{
				Capabilities.setCapability(key,value);
			}
			
		}
		
		
	}
	/**
	 * Reading data from Excel based on Column Name
	 * @param fileName
	 * @return 
	 * @throws IOException 
	 */
	public static int readIntData(String fileName,String ColumnName) throws IOException {
		int count=0;
		File file =    new File(filePath+"\\"+fileName+".xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			if(sheet.getRow(0).getCell(k).getStringCellValue().equals(ColumnName) ){
				count=k;
				break;
			}
		}
		return (int)sheet.getRow(1).getCell(count).getNumericCellValue();
	}

	/**
	 * method to take screenshot with testname and timestamp
	 * works only when test is failed
	 * @param testName
	 * @param testStatus
	 * @param webDriver 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void screenShot(String testName,boolean testStatus, WebDriver webDriver) throws IOException, InterruptedException
	{
		if(!testStatus) {
		File scr=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Screenshot\\"+testName+"_"+getTimeStamp()+".png");
		FileHandler.copy(scr, dest);
		}
		webDriver.close();
		webDriver.quit();
	}
	
	/**
	 * method to get Time Stamp
	 * @return
	 */
	public static String getTimeStamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");  
		   LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	/**
	 * Method for wait for Page load
	 * @param element
	 */
	public static void waitForPageLoad(By element) {
		try {
			WebDriverWait wait=new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		}catch(Exception e){
			e.printStackTrace();
		}
	}	

}
