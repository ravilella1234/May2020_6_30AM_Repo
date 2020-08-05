package com.project.CRM.dirverClass;

import java.util.Hashtable;
import java.util.Properties;

import com.project.CRM.keywordClasses.AppKeywords;
import com.project.CRM.utilities.ExcelAPI;

public class DriverScript 
{
	public  Properties orProp;
	AppKeywords app;
	
	public  Properties getOrProp() {
		return orProp;
	}

	public  void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}

	public void executeKeywords(ExcelAPI xls,String testName,Hashtable<String, String> testData)
	{
		System.out.println("iam driverscript class....");
		int rows = xls.getRowCount("Keyword");
		System.out.println("Rows : " + rows);
		app = new AppKeywords();
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData("Keyword", "TCID", rNum);
			
			if(tcid.equals(testName))
			{
				String kWord = xls.getCellData("Keyword", "Keywords", rNum);
				String objectKey = xls.getCellData("Keyword", "Object", rNum);
				String dataKey = xls.getCellData("Keyword", "Data", rNum);
				String data = testData.get(dataKey);
				
				System.out.println(tcid +"----" + kWord + "----" + orProp.getProperty(objectKey) +"----" + data);
				
				if(kWord.equals("openBrowser"))
					app.openBrowser();
				else if(kWord.equals("navigateUrl"))
					app.navigateUrl();
				else if(kWord.equals("click"))
					app.click();
				else if(kWord.equals("type"))
					app.type();
				else if(kWord.equals("validatLogin"))
					app.validatLogin();
					
			}
		}
		
	}
}
