package pageObjectmodel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.MavenSeleniumBuild_6_30AMBatch.BaseTest;

public class Login extends BaseTest
{
	
	LoginPage page;
	
	  @BeforeMethod
	  @Parameters("browser")
	  public void beforeMethod(String bType) throws Exception 
	  {
		  init();
		  launchBrowser(bType);
		  navigateUrl("automationurl");
	  }	
	
	
	  @Test
	  public void login() throws Exception 
	  {
		  
		  page  = new LoginPage(driver);
		  page.customerLogin();
		  
		  Assert.assertEquals(page.verifyLogin(), "Authentication failed.");
		  
		/*
		 * driver.findElement(By.linkText("Sign in")).click(); Thread.sleep(3000);
		 * driver.findElement(By.id("email")).sendKeys("qatest874878@gmail.com");
		 * driver.findElement(By.id("passwd")).sendKeys("password");
		 * driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		 * 
		 * String actualValue =
		 * driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]"
		 * )).getText(); String expectedValue = "Authentication failed.";
		 * 
		 * Assert.assertEquals(actualValue, expectedValue);
		 */
	  }
  
  

	  @AfterMethod
	  public void afterMethod() 
	  {
		  
	  }

}
