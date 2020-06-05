package com.project.MavenSeleniumBuild_6_30AMBatch456;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.MavenSeleniumBuild_6_30AMBatch.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class CheckBox1 extends BaseTest
{
  


	  @BeforeMethod
	  public void beforeMethod() throws Exception 
	  {
		
		  init();
			test=report.startTest("CheckBox1");
			test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
			
			launchBrowser("chromebrowser");
			test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
			
			navigateUrl("checkboxurl");
			test.log(LogStatus.PASS, "Navigated to url : " + childEnv.getProperty("checkboxurl"));
		
	
	  }
	  
	  
	@Test
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
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
