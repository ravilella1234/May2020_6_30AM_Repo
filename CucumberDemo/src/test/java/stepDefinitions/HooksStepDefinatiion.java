package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksStepDefinatiion 
{
	
	@Before(order = 0)
	public void startProcess()
	{
		System.out.println("Open Chrome Browser....");
		System.out.println("Navigate to the amazon url...");
		System.out.println("Initiallize the Excel data files...");
		System.out.println("Initialize the reports....");
	}
	
	@After(order = 0)
	public void endProcess()
	{
		System.out.println("kill the excel files");
		System.out.println("End the reports  instances");
		System.out.println("Close the browsers");
	}
	
	@Before("@S1")
	public void beforeS1()
	{
		System.out.println("Before S1");
	}
	
	@After("@S1")
	public void avterS1()
	{
		System.out.println("After S1");
	}
	
	@Before("@S2")
	public void beforeS2()
	{
		System.out.println("before S2");
	}
	
	@After("@S2")
	public void afterS2() 
	{
		System.out.println("After S2");
	}
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() 
	{
	    System.out.println("Given : user should be on login page");
	}

	@When("user fills username and password")
	public void user_fills_username_and_password() 
	{
	    System.out.println("When :  user fills username and password");
	}
	
	@And("Clicks on signIn button")
	public void Clicks_on_signIn_button()
	{
		System.out.println("And  : Clicks on signIn button");
	}
	
	@Then("User is navigated to the main page")
	public void user_is_navigated_to_the_main_page() 
	{
	  System.out.println("Then : User is navigated to the main page");
	}
	

	@Given("user is on products page")
	public void user_is_on_products_page()
	{
	    System.out.println("Given :  user is on products page");
	}

	@When("user should selects the product")
	public void user_should_selects_the_product() 
	{
	    System.out.println("When :  user should selects the product");
	}

	@Then("product should add to cartpage")
	public void product_should_add_to_cartpage() 
	{
	    System.out.println("Then :  product should add to cartpage");
	}

}
