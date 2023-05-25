package com.masai.WholeClasses;

import java.util.*;
import java.util.Map;

public class Customer {
	
	String email;
	String password; 
	double wallet;
	Map<String, Customer>ccfile;
	static List<Stock>stockList=new ArrayList();
	
	 public Customer(String email, String password, double wallet, Map<String, Customer> ccfile) {
		super();
		this.email = email;
		this.password = password;
		this.wallet = wallet;
		
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public static void stockList(Stock obj,int quant){
	  int  count=0;
		for(Stock s : stockList) {
			if(s.getStockname().equals(obj.getStockname())) {
				s.quantity=s.quantity+quant;
				count++;
			}
		}
		if(count==1) {
			System.out.println("Stock bougth");
		}else {
			obj.quantity=quant;
			stockList.add(obj);
			System.out.println("Stock bougth");
		}
			
		
	}
	public static void viewStockList(){
		for(Stock s : stockList) {
			System.out.println(s);
		}
	}	
	public static void sellStockList(String sell,String cusEmail,String cusPassword,double wallet,Map<String,Customer>Cfile){
		
		
		int count=0;
		for(Stock s : stockList) {
			if(s.getStockname().equals(sell)) {
				if(s.quantity>0) {
				s.quantity--;
				double price= s.getPrice();
      Customer cus = new Customer(cusEmail,cusPassword,wallet+price,Cfile);
      Cfile.put(cusEmail, cus);
				count++;
				}else {
				   stockList.remove(sell);
				}
			}
		}
	
		if(count==1) {
			System.out.println("stock Sold");
		}else {
			System.out.println("stock not found");
		}
	}	
	

	public Map<String, Customer> getCcfile() {
		return ccfile;
	}

	public void setCcfile(Map<String, Customer> ccfile) {
		this.ccfile = ccfile;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", password=" + password + ", wallet=" + wallet + " "
				+ "]";
	}
	
           
}
