package com.launch;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) 
	{
		launchBrowser("firefox");
		
		navigateUrl("https://www.amazon.in");

	}

}
