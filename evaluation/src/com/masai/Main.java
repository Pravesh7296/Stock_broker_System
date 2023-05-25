package com.masai;
import java.util.*;

import com.masai.filecheck.*;
import com.masai.WholeClasses.*;
import com.masai.Services.*;
public class Main {
	
	private static void adminFunction(Scanner sc,Map<String,Customer> Cfile,Map<String,Stock> Sfile,Map<String,Transaction> Tfile ) {
		int prefrence =0;
		do {
			try {
			System.out.println("1.View All Customer,2.Add New Stocks,3.Delete Customer,4.Delete Stocks,5.ViewallAllStocks,0.Exit");
	        prefrence=sc.nextInt();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	        switch(prefrence) {
	        case 1: 
	        	CustomerService.viewAllCustomer(Cfile);
	        	break;
	        case 2: 
	        	StockService.AddStocks(Sfile);
	        	break;
	        
	        case 3:
	        	try {
	        	System.out.println("enter customer Email");
	        	String demail=sc.next();
	        	CustomerService.deleteCustomer(demail,Cfile);
	        	}catch(Exception e) {
	        		System.out.println(e.getMessage());
	        	}
	        	break;
	        case 4:
	        	System.out.println("enter Stock Name");
	        	String stockName=sc.next();
	        	StockService.deleteStock(stockName,Sfile);
	        	break;
	        case 5:
	        	StockService.viewAllStock(Sfile);
	        	break;
	        case 0:
	        	System.out.println("Thank you");
	        	break;
	        	default:
	        		System.out.println("Invaild Selection");
	        }	
		}while(prefrence!=0);  		
	        
		
	}

	private static void customerLogin(Scanner sc,Map<String,Customer> Cfile,Map<String,Stock>Sfile) {
		  System.out.println("enter your email");
   	   String cusEmail=sc.next();
   	   System.out.println("enter your password");
   	   String cusPassword= sc.next();
   	   if(CustomerService.customerLogIn(cusEmail, cusPassword, Cfile)) {
   		System.out.println("LogIn SuccessFully"); 
   int pre=0;
   		do {
   		
  System.out.println("1.ViewAllStocks ,2.Buy and sell Stocks,3.Add and Withdrow Money,4.view Balance 0.Exit");	
  pre=sc.nextInt();
  switch(pre) {
  case 1:
	  StockService.viewAllStock(Sfile);
	  break;
  case 2:
	  System.out.println("1. For Buy ,2.Sell");
	   int buy=sc.nextInt();
	   if(buy==1) {
		   System.out.println("please Select Name of Stock");
		   StockService.viewAllStock(Sfile);  
		   String stName=sc.next();
		   System.out.println("Quantity of Stocks");
		   int stockqunt=sc.nextInt();
		   double wallet= Cfile.get(cusEmail).getWallet();
		  StockService.buyStocks(stockqunt,cusEmail,cusPassword,wallet,stName, Sfile,Cfile); 
	   }
	   else if(buy==2) {
		   System.out.println("please Select Name of Stock");
		   double wallet= Cfile.get(cusEmail).getWallet();
		   Customer cus= new Customer(cusEmail,cusPassword,wallet,Cfile);
		   cus.viewStockList();
		   String sell= sc.next();
		   cus.sellStockList(sell,cusEmail,cusPassword,wallet,Cfile);
		   System.out.println("your new Stock gallery");
		   cus.viewStockList();
			 
	   }else {
		   System.out.println("input right details");
	   }
	   break;
  case 3:
	  System.out.println("1.Withdrow, 2.Add Money");
	  int money= sc.nextInt();
	  if(money==1) {
		  System.out.println("enter amount");
		  int w = sc.nextInt();
		   double wallet= Cfile.get(cusEmail).getWallet();
		   if(wallet-w<0) {
			 System.out.println("Low Balance");
		   }else {
		   Customer cus= new Customer(cusEmail,cusPassword,wallet-w,Cfile); 
		   Cfile.put(cusEmail, cus);
		   System.out.println("your new amount is  "+Cfile.get(cusEmail).getWallet());
	  }
	  }
	  else if(money==2) {
		  System.out.println("enter amount");
		  int ad = sc.nextInt();
		   double wallet= Cfile.get(cusEmail).getWallet();
		   Customer cus= new Customer(cusEmail,cusPassword,wallet+ad,Cfile); 
		   Cfile.put(cusEmail, cus);
		   System.out.println("your new amount is  "+Cfile.get(cusEmail).getWallet());
	  }else {
		  System.out.println("enter vaild Details");
		  
	  }
	  break;
  case 4:
	  double wallet= Cfile.get(cusEmail).getWallet();
	  Customer cus= new Customer(cusEmail,cusPassword,wallet,Cfile); 
	  System.out.println(cus.getWallet());
  case 0:
	  System.out.println("ThankYou");
	  break;
	  default : 
		  System.out.println("Invaild Input");	  
		  break;
  }
   		}while(pre!=0);
   		
   	   }else {
   		   System.out.println("Wrong Details");
   	   }
		
		
	}
	
	
	
	
	
       public static void main(String[] args) {
		Map<String,Customer> Cfile = FileExists.customerFileCheck();
		Map<String,Stock> Sfile = FileExists.stockFileCheck();
		Map<String,Transaction> Tfile = FileExists.transFileCheck();
		Customer cu1=new Customer("ps@gmail.com","1234",4000.0,Cfile);
		Customer cu2=new Customer("pp@gmail.com","1234",4000.0,Cfile);
		Cfile.put("ps@gmail.com",cu1 );
		Cfile.put("pp@gmail.com", cu2);
		
		Stock st1= new Stock("Aritel",200,10);
		Stock st2= new Stock("Jio",500,30);
		Sfile.put("Aritel",st1);
		Sfile.put("Jio",st2);
		Scanner sc = new Scanner(System.in);
		int prefrence=0;
		
		do {
			System.out.println("Welcome to Stock Broker System");
			System.out.println("2 customer and 2 stocks already added by default email=ps@gmail.com pass=1234");
System.out.println("1.Admin login ,2. Customer login ,3. Customer singup,0.Exit");
prefrence=sc.nextInt();  
       switch(prefrence) {
       case 1 : 
    	   System.out.println("enter user name");
    	   String user= sc.next();
    	   System.out.println("enter user password");
    	   String pass= sc.next();
    	  if(AdminLogin.checkAdmin(user,pass)) {
           System.out.println( "logIn Succesfully");
            adminFunction(sc,Cfile,Sfile,Tfile);
    	  }
    	  else {
    		  System.out.println("wrong Details of Admin");
    	  }
    	  break;
       case 2: 
    	   customerLogin(sc,Cfile,Sfile);
    	   break;
       case 3:
    	   System.out.println("enter your email");
    	   String email= sc.next(); 
    	   System.out.println("enter your password");
    	   String password= sc.next();
    	   System.out.println("Add your wallet");
    	   double  wallet= sc.nextInt();
    	   
    	   CustomerService.customerSignUp(email, password, wallet,Cfile);
    		break; 
     default:
    	 System.out.println("Inseret vaild input");
    	   break;
    	   
       }
       
		}while(prefrence!=0);
		
	}







}
