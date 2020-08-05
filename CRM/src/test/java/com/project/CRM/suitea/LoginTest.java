package com.project.CRM.suitea;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.CRM.BaseClass.BaseTest;
import com.project.CRM.utilities.DataUtils;

public class LoginTest extends BaseTest
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> data) 
  {
	  System.out.println("iam f test...");
	  
	  if(data.get("Runmode").equals("N"))
		  throw new SkipException("Runmode is set to no ......");
		  
	  //ds = new DriverScript();
	  ds.executeKeywords(xls, testName, data);
  }
  
  @DataProvider
  public Object[][] getData()
  {
	  System.out.println("iam dataprovider....");
	  //String testName="LoginTest";
	  String sheetName="Data";
	 
	  return DataUtils.getTestData(xls, sheetName, testName);
  }
}
