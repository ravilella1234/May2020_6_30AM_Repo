package com.project.CRM.suitea;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.CRM.BaseClass.BaseTest;
import com.project.CRM.utilities.DataUtils;

public class TC_001 extends BaseTest
{

 
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> data) 
  {
	  System.out.println("iam f test from TC_001 Class");
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
