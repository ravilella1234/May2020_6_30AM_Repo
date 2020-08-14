package com.project.CRM.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.project.CRM.dirverClass.DriverScript;
import com.project.CRM.utilities.ExcelAPI;

public class BaseTest 
{
	public static FileInputStream fis;
	public static String projectPath= System.getProperty("user.dir");
	public  Properties parentEnv;
	public  Properties childEnv;
	public  Properties orProp;
	public static ExcelAPI xls;
	public String testName;
	public DriverScript ds;
	
	public  void load() throws Exception
	{
		fis = new FileInputStream(projectPath + "//src//test//resources//environment.properties");
		parentEnv = new Properties();
		parentEnv.load(fis);
		String e = parentEnv.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath + "//src//test//resources//" + e + ".properties");
		childEnv = new Properties();
		childEnv.load(fis);
		String url = childEnv.getProperty("zohourl");
		System.out.println(url);
		
		fis = new FileInputStream(projectPath + "//src//test//resources//" + "or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		//init the TestName
		testName = this.getClass().getSimpleName();
		System.out.println(testName);
		
		//How do i know which suite Excel file to load
		String[] pack = this.getClass().getPackage().getName().split("\\.");
		String suiteName = pack[pack.length-1];
		System.out.println(suiteName);
		
		//init the xls file
		xls = new ExcelAPI(childEnv.getProperty(suiteName+"_xls"));
		
		//init th driverscript object
		ds = new DriverScript();
		ds.setOrProp(orProp);
	}
	
	@BeforeTest
	public void init() throws Exception
    {
		 System.out.println("iam beforetest from BaseTest Class");
		  load();
	}
	
	@AfterTest
	public void killInstance()
	{
		if(ds!=null)
			ds.quit();
	}

}
