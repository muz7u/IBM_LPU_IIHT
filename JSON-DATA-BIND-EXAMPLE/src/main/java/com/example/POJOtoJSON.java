package com.example;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class POJOtoJSON 
{
	Address objAddress=new Address("3","Ranchi","Jharkhand","834001","India");
	String arr[]= {"C++","JAVA"};
	
	
Jsonb jsonb = JsonbBuilder.create();
Customer customer =new Customer(1,"Ghulam", "Mozammil", true, objAddress, arr);
String result=jsonb.toJson(customer);



}
