package com.project.CRM.dirverClass;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.project.CRM.keywordClasses.AppKeywords;
import com.project.CRM.utilities.Constants;
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

	public void executeKeywords(ExcelAPI xls,String testName,Hashtable<String, String> testData) throws Exception, SecurityException
	{
		System.out.println("iam driverscript class....");
		int rows = xls.getRowCount(Constants.KEYWORD_SHEET);
		System.out.println("Rows : " + rows);
		app = new AppKeywords();
		app.setOrProp(orProp);
		app.setTestData(testData);
		
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.KEYWORD_SHEET, Constants.TCID_COL, rNum);
			
			if(tcid.equals(testName))
			{
				String kWord = xls.getCellData(Constants.KEYWORD_SHEET, Constants.KEYWORD_COL, rNum);
				String objectKey = xls.getCellData(Constants.KEYWORD_SHEET, Constants.OBJECT_COL, rNum);
				String dataKey = xls.getCellData(Constants.KEYWORD_SHEET, Constants.DATA_COL, rNum);
				String data = testData.get(dataKey);
				
				//System.out.println(tcid +"----" + kWord + "----" + orProp.getProperty(objectKey) +"----" + data);
				app.setObjectKey(objectKey);
				app.setDataKey(dataKey);
				
				/*
				 * if(kWord.equals("openBrowser")) app.openBrowser(); else
				 * if(kWord.equals("navigateUrl")) app.navigateUrl(); else
				 * if(kWord.equals("click")) app.click(); else if(kWord.equals("type"))
				 * app.type(); else if(kWord.equals("validatLogin")) app.validatLogin(); else
				 * if(kWord.equals("verifyTitle")) app.verifyTitle();
				 */
				
				//Reflection API
				Method method;
				
				method = app.getClass().getMethod(kWord);
				method.invoke(app);
			}
		}
		
	}
}
