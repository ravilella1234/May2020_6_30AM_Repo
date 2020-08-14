package com.project.CRM.keywordClasses;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywords 
{
	public  Properties orProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	public WebDriver driver;
	

	public void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public void setTestData(Hashtable<String, String> testData) {
		this.data = testData;
	}

	public void openBrowser()
	{
		String browser = data.get(dataKey);
		System.out.println("Opening the Browser....." + browser);
		
		if(browser.equals("chrome")) 
		{
			//Create Browser Profiles & Invoke them
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\JulyDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//Create Browser Profiles & Invoke them
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\JulyDrivers\\geckodriver.exe");
			driver =  new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigating to website....." + data.get(dataKey));
		driver.get(data.get(dataKey));
	}
	
	public void click()
	{
		System.out.println("Clicking on the element...." + orProp.getProperty(objectKey));
		//driver.findElement(By.xpath(orProp.getProperty(objectKey))).click();
		getElement(objectKey).click();
	}
	
	public void type()
	{
		System.out.println("Typing the text....." + orProp.getProperty(objectKey) +"-------" + data.get(dataKey));
		//driver.findElement(By.xpath(orProp.getProperty(objectKey))).sendKeys(data.get(dataKey));
		getElement(objectKey).sendKeys(data.get(dataKey));
	}
	
	public void verifyTitle()
	{
		System.out.println("Title verified...");
	}
	
	public WebElement getElement(String objectKey)
	{
		WebElement element = null;
		
		try 
		{
			if(objectKey.endsWith("_id")) {
				element = driver.findElement(By.id(orProp.getProperty(objectKey)));
			}else if(objectKey.endsWith("_name")) {
				element = driver.findElement(By.name(orProp.getProperty(objectKey)));
			}else if(objectKey.endsWith("_classname")) {
				element = driver.findElement(By.className(orProp.getProperty(objectKey)));
			}else if(objectKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(orProp.getProperty(objectKey)));
			}else if(objectKey.endsWith("_css")) {
				element = driver.findElement(By.cssSelector(orProp.getProperty(objectKey)));
			}
			
			WebDriverWait  wait = new WebDriverWait(driver, 30);
			//To check Visibility of Object
			wait.until(ExpectedConditions.visibilityOf(element));
			
			//To check state of the Object Whether it is Clickable or not
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//Report the failure Status
			reportFailure();
		}
		
		return element;
	}
	
	public void validateElementPresence()
	{
		if(!isElementPresent(objectKey))
		{
			//Report Failure
			reportFailure();
		}
	}
	
	
	public  void reportFailure() 
	{
		//Fail the test in giving the Fail Status
		
		//Take the screenshots , and embedded the screenshots in physical location as well in HTML Reports
	}

	public boolean isElementPresent(String objectKey) 
	{
		List<WebElement> element = null;
		
		if(objectKey.endsWith("_id")) {
			element = driver.findElements(By.id(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_name")) {
			element = driver.findElements(By.name(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_classname")) {
			element = driver.findElements(By.className(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_xpath")) {
			element = driver.findElements(By.xpath(orProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_css")) {
			element = driver.findElements(By.cssSelector(orProp.getProperty(objectKey)));
		}
		
		if(element.size()==0)
			return false;
		else
			return true;
	}
	
	
	

	public void quit()
	{
		if(driver!=null)
			driver.quit();
	}
	
}
