package com.project.CRM.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	public static FileInputStream fis;
	public static String projectPath= System.getProperty("user.dir");
	public static Properties parentEnv;
	public static Properties childEnv;
	
	public static void load() throws Exception
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
	}
	
	@BeforeTest
	public void init() throws Exception
    {
		 System.out.println("iam beforetest from BaseTest Class");
		  load();
	}

}
