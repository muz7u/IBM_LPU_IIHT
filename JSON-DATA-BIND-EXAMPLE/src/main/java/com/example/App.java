package com.example;

import java.io.File;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
public class App 
{
    public static void main( String[] args )
    {
        
    	try {
    		
    		ObjectMapper mapper=new ObjectMapper();
    		Customer customer=mapper.readValue(new File("data/sample.json"), Customer.class);
    		
    		System.out.println(customer.getFirstName());
    		System.out.println(customer.getLastName());
    		System.out.println(customer.getId());
    		System.out.println(customer.getAddress().getCity());
    		System.out.println(customer.getAddress().getCountry());
    		System.out.println(customer.getAddress().getStreet());
    		System.out.println(customer.getAddress().getZip());
    		System.out.println(customer.getLanguages());
    	}
    	catch(Exception e )
    	{
    		e.printStackTrace();
    	}
    
    	
    
    	
    	
    
    }
}
