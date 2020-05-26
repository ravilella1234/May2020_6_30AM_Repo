package com.launch;

import org.apache.log4j.Logger;

public class TC_005 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_005.class);
	
	public static void main(String[] args) throws Exception 
	{
		
		init();
		log.info("Initializing the Properties & configuration files......");
		
		launchBrowser("chromebrowser");
		log.info("Opened the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url : " + childEnv.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");	
		log.info("Selected the option  Books By using the locator :- " + orprop.getProperty("amazondropbox_id") );
		
		typeText("amazonsearchtext_name","Harry potter");
		log.info("Entered the text Harry Portter by using the locator :- " + orprop.getProperty("amazonsearchtext_name"));
			
		elementClick("amzonsearchbotton_xpath");
		log.info("Clicked on Search Button By using the locator :- " + orprop.getProperty("amzonsearchbotton_xpath"));
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();

	}

	

}
