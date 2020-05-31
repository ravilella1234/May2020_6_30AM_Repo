package com.launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC_008 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_008");
		test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to url : " + childEnv.getProperty("amazonurl"));
		
		WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));

		
		loc.sendKeys("sony");
		String text = loc.getAttribute("value");
		System.out.println("Text is : " + text);
	}

}
