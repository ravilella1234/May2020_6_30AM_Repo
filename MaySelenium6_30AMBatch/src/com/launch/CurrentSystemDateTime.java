package com.launch;

import java.util.Date;

public class CurrentSystemDateTime 
{

	public static void main(String[] args)
	{
		Date dt = new Date();
		System.out.println(dt);
		String str = dt.toString();
		String dt_str = str.replace(' ', '_').replace(':', '_');
		System.out.println(dt_str);
	}

}
