package com.project.CRM.keywordClasses;

import java.util.Hashtable;
import java.util.Properties;

public class GenericKeywords 
{
	public  Properties orProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	

	public void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public void setTestData(Hashtable<String, String> testData) {
		this.data = testData;
	}

	public void openBrowser()
	{
		System.out.println("Opening the Browser....." + data.get(dataKey));
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigating to website....." + data.get(dataKey));
	}
	
	public void click()
	{
		System.out.println("Clicking on the element...." + orProp.getProperty(objectKey));
	}
	
	public void type()
	{
		System.out.println("Typing the text....." + orProp.getProperty(objectKey) +"-------" + data.get(dataKey));
	}
	
	public void verifyTitle()
	{
		System.out.println("Title verified...");
	}
}
