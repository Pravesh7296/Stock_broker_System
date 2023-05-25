package com.masai.Services;
import com.masai.WholeClasses.*;
import java.util.*;
public class CustomerService {
     public static void viewAllCustomer(Map<String,Customer>Cfile) {
    	 if(Cfile.size()==0) {
    		 System.out.println("First Add Customer");

    	 }else {
    		 Set<Map.Entry<String,Customer>> entry= Cfile.entrySet();
        	 for(Map.Entry en : entry) {
        		 System.out.println(en.getValue());
        	 }
    	 }
    	
     }
     public static void customerSignUp(String email,String password,double wallet,Map<String,Customer>CFile) {
        Customer customer = new Customer(email,password,wallet,CFile);
        CFile.put(email, customer);
        
     }
     public static void deleteCustomer(String email,Map<String,Customer>Cfile) {
    	 Set<Map.Entry<String,Customer>> entry= Cfile.entrySet();
    	 int count=0;
    	 for(Map.Entry en : entry) {
    		 if(en.getKey().equals(email)) {
    			 Cfile.remove(en.getKey());
    			 count++;
    		 }
    	 }
    	 if(count==1) {
    		System.out.println("Custmor deleted Successfully"); 
    	 }
    	 else {
    		 System.out.println("Custmor NOt found");
    	 }
     }
     public static boolean customerLogIn(String Email,String Password,Map<String,Customer>Cfile) {
    	 if(Cfile.size()==0) {
    		 System.out.println("First SignUP");
    		 return false;

    	 }else {
    		 int count=0;
    		 Set<Map.Entry<String,Customer>> entry= Cfile.entrySet();
        	 for(Map.Entry en : entry) {
        		if(en.getKey().equals(Email) && en.getValue().toString().contains(Password)) {
        		  System.out.println("LogIn Successfully");
        		  count++;
        		}
        	 }
        	if(count==1) {
        		return true;
        	}
        	else {
        		return false;
        	}
    	 }
    	
     }
}
