package com.project.CRM.utilities;

import java.util.Hashtable;

public class DataUtils 
{
	
	public static Object[][] getTestData(ExcelAPI e, String sheetName, String testcaseName)
	{
		
		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testcaseName))
		{
			testStartRowNum++;
		}
		System.out.println("test Starts from row :- " + testStartRowNum);
		
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		
		//calculate the row of data
		int rows=0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are :- " + rows);

		
		//calculate the total Columns
		int cols =0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total cols are :- " + cols);
		
		
		//read the data
		int dataRow=0;
		Object[][] data=new Object[rows][1];
		Hashtable<String, String> table = null;
		
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table = new Hashtable<String, String>();
			
			for(int cNum=0;cNum<cols;cNum++)
			{
				String key = e.getCellData(sheetName, cNum, colStartRowNum);
				String value = e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}
	  
	  
	return data;
		
	}
	
	
	public static boolean isSkip(String testName, ExcelAPI xls)
	{
		int rows = xls.getRowCount(Constants.TESTCASES_SHEET);
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.TESTCASES_SHEET, Constants.TCID_COL, rNum);
			if(tcid.equals(testName))
			{
				String runmode = xls.getCellData(Constants.TESTCASES_SHEET, Constants.RUNMODE_COL, rNum);
				if(runmode.equals(Constants.RUNMODE_NO))
					return true;
				else
					return false;
			}
		}
		
		return false;
		
	}

}
