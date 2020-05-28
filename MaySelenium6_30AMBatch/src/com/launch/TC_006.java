package com.launch;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{
	
	
	public static void main(String[] args) throws Exception 
	{
		
		init();
		test=report.startTest("TC_006");
		test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to url : " + childEnv.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");	
		test.log(LogStatus.PASS, "Selected the option  Books By using the locator :- " + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_name","Harry potter");
		test.log(LogStatus.PASS, "Entered the text Harry Portter by using the locator :- " + orprop.getProperty("amazonsearchtext_name"));	
		
		elementClick("amzonsearchbotton_xpath");
		test.log(LogStatus.PASS, "Clicked on Search Button By using the locator :- " + orprop.getProperty("amzonsearchbotton_xpath"));
		
		report.endTest(test);
		report.flush();
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();

	}

	

}
