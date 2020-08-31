package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDemoStepDefinition
{
	WebDriver driver = null;
	public String projectPath = System.getProperty("user.dir");
	
	@Given("Open the browser by user")
	public void open_the_browser_by_user() 
	{
		 System.out.println("google : open the browser");
		 System.setProperty("webdriver.chrome.driver", projectPath+"//drivers//chromedriver.exe");
		 driver = new ChromeDriver();
		    
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}

	@And("User is on login page")
	public void user_is_on_login_page() 
	{
	    driver.get("https://example.testproject.io/web/");
	}
	
	@When("^enter (.*) and (.*)$")
	public void enter_username_and_password(String username,String password) throws Exception
	{
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		Thread.sleep(3000);
	}
	
	@And("user should click on login")
	public void user_should_click_on_login()
	{
		driver.findElement(By.id("login")).click();
	}

	@Then("User should navigated to home page")
	public void user_should_navigated_to_home_page() 
	{
	    driver.findElement(By.xpath("//div[@id='pageProfile']/h1[text()='TestProject Example page']")).isDisplayed();
	    
	    driver.quit();
	}
}
