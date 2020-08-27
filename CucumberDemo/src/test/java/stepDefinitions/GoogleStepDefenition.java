package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleStepDefenition 
{
	WebDriver driver = null;
	public String projectPath = System.getProperty("user.dir");
	
	@Given("open the browser")
	public void open_the_browser() 
	{
		
	    System.out.println("google : open the browser");
	    System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}

	@And("user should be on google search page")
	public void user_should_be_on_google_search_page() 
	{
	   System.out.println("google : user should be on google search page");
	   driver.get("https://ww.google.com");
	}

	@When("user enters a test in search box")
	public void user_enters_a_test_in_search_box()
	{
		System.out.println("google :user enters a test in search box");
		driver.findElement(By.name("q")).sendKeys("hadoop");
	}
	
	@And("hit Enter")
	public void hit_Enter() 
	{
	   System.out.println("google : hit Enter");
	   driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results page")
	public void user_is_navigated_to_search_results_page() 
	{
		System.out.println("google :user is navigated to search results page");
		driver.getPageSource().contains("Apache Hadoop");
		
		driver.quit();
	}


	
}
