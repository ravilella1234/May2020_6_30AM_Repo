package com.project.CRM.keywordClasses;

public class AppKeywords extends GenericKeywords
{
	
	public void validatLogin()
	{
		System.out.println("Validating login.....");
	}
	
	public void verifyTitle()
	{
		System.out.println("Verify Title..." +orProp.getProperty(objectKey));
		String expectedTitle = orProp.getProperty(objectKey);
		String actualTitle = driver.getTitle();
		if(!expectedTitle.equals(actualTitle))
		{
			//Report Failure
		}
	}

}
