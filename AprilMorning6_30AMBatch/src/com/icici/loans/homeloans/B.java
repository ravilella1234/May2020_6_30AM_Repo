package com.icici.loans.homeloans;

public  class B extends A // ISA Relationship
{
	public void m2()
	{
		System.out.println("iam m2 from class B");
		System.out.println(x);
		x=1000;
	}
	
	public  final strictfp void m1()
	{	
		x=200;
		System.out.println("iam m1 from class A");
		System.out.println(x);
	}
	
	public void m1()
	{
		System.out.println("iam overriden m1 from class B");
	}
	
	public static void main(String[] args) 
	{
		A a=new A(); // HasA RelationShip
		a.m1();
		System.out.println(a.x);
		
		B b= new B();
		b.m1();
		b.m2();
		System.out.println(b.x);
	}
	
}


