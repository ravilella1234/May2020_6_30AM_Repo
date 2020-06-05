package com.project.MavenSeleniumBuild_6_30AMBatch456;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.MavenSeleniumBuild_6_30AMBatch.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class RadioButton1 extends BaseTest
{

	@BeforeMethod
	  public void beforeMethod() throws Exception 
	  {
		
		init();
		test=report.startTest("RadioButton1");
		test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		
		launchBrowser("chromebrowser");
		test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("radiourl");
		test.log(LogStatus.PASS, "Navigated to url : " + childEnv.getProperty("radiourl"));
		
	  }
	
	
	@Test
	public void checkboxTest()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
	  
	  report.endTest(test);
	  report.flush();
  }
	
}
