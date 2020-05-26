package com.launch;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentEnv;
	public static Properties childEnv;
	public static Properties orprop;
	
	
	public static void init() throws Exception
	{
	    fis = new FileInputStream(projectPath+"//data.properties");
		p = new Properties();
		p.load(fis);	
		
		fis = new FileInputStream(projectPath + "//or.properties");
		orprop = new Properties();
		orprop.load(fis);
		
		
		fis = new FileInputStream(projectPath + "//environment.properties");
		parentEnv = new Properties();
		parentEnv.load(fis);
		String e = parentEnv.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath + "//" + e + ".properties");
		childEnv = new Properties();
		childEnv.load(fis);
		String url = childEnv.getProperty("amazonurl");
		System.out.println(url);
		
		fis = new FileInputStream(projectPath + "//log4j.properties");
		PropertyConfigurator.configure(fis);
		
	}
	
	
	public static void launchBrowser(String browser)
	{
		if(p.getProperty(browser).equalsIgnoreCase("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\May Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "false");
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 8");
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox")) 
		{
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\May Drivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers//geckodriver.exe");
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("maychromeprofile");
			
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			
			driver = new FirefoxDriver(option);
		}
		driver.manage().window().maximize();
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childEnv.getProperty(url));
		driver.navigate().to(childEnv.getProperty(url));
	}
	
	
	
	public static WebElement getElement(String locatorKey)
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")){
			element = driver.findElement(By.id(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orprop.getProperty(locatorKey)));
		}
		return element;

	}
	
	
	public static void elementClick(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(locatorKey)).click();
	}

	
	public static void typeText(String locatorKey, String text) 
	{	
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.name(locatorKey)).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		getElement(locatorKey).sendKeys(option);
		//driver.findElement(By.id(locatorKey)).sendKeys(option);
	}
	

}
