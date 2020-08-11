package com.project.CRM.keywordClasses;

import java.lang.reflect.Method;

public class ReflectionDemo 
{

	public static void sampleTest()
	{
		System.out.println("Iam a sampleTest");
	}
	
	public static void sampleTest1()
	{
		System.out.println("Iam a sampleTest1");
	}
	
	public static void main(String[] args) throws Exception, Exception 
	{
		String str = "sampleTest1";
		
		/*
		 * if(str.equals("sampleTest")) sampleTest(); else if(str.equals("sampleTest1"))
		 * sampleTest1();
		 */
		ReflectionDemo obj = new ReflectionDemo();
		 Method m = obj.getClass().getMethod(str);
		 m.invoke(m);
		
	}

}
