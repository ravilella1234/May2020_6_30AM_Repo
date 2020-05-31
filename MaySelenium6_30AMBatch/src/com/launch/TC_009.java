package com.launch;

import com.relevantcodes.extentreports.LogStatus;

public class TC_009 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_009");
		test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to url : " + childEnv.getProperty("amazonurl"));
		
		String expectedLink = "customer service";
		if(!isLinkPresent(expectedLink))
			reportFailure("Both Links are not equal....");
		else
			reportSuccess("Both Links are equal....");
		
		
		report.endTest(test);
		report.flush();


	}

	

}
