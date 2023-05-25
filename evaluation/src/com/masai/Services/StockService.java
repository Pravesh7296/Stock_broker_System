package com.masai.Services;
import java.util.*;
import com.masai.WholeClasses.*;
public class StockService {
         public static void AddStocks(Map<String,Stock> Sfile) {
        	 Scanner sc =new Scanner(System.in);
        	 System.out.println("enter Stock name");
        	 String name= sc.next();
        	 System.out.println("enter Stock price");
        	 int price= sc.nextInt();
        	 System.out.println("enter Stock quantity");
        	 int qunt = sc.nextInt();
        	 
        	 Stock st = new Stock(name,price,qunt);
        	 Sfile.put(name, st);
        	 System.out.println(name+"  Stock added Successfully");
        	 
         }
         public static void deleteStock(String StockName,Map<String,Stock>Sfile) {
        	 if(Sfile.size()==0) {
        		 System.out.println("First ADD Customer");
        	 }else {
        	 Set<Map.Entry<String,Stock>> entry= Sfile.entrySet();
        	 int count=0;
        	 for(Map.Entry en : entry) {
        		 if(en.getKey().equals(StockName)) {
        			 Sfile.remove(en.getKey());
        			 count++;
        		 }
        	 }
        	 if(count==1) {
        		System.out.println("Stock deleted Successfully"); 
        	 }
        	 else {
        		 System.out.println("Stock NOt found");
        	 }
        	 }
}
         public static void viewAllStock(Map<String,Stock>Sfile) {
        	 if(Sfile.size()==0) {
        		 System.out.println("First ADD Stocks");
        	 }else {
        	 Set<Map.Entry<String,Stock>> entry= Sfile.entrySet();
        	 for(Map.Entry en : entry) {
        		 System.out.println(en.getValue());
        	 }
        	 }
        	
         }
         public static void buyStocks(int stockqunt,String cusEmail,String cusPassword,double wallet,String name, Map<String,Stock>Sfile,Map<String,Customer>Cfile) {
        	 if(Sfile.size()==0) {
        		 System.out.println("First ADD Stocks");
        	 }
        	 else {
        		 
        	 Set<Map.Entry<String,Stock>> entry= Sfile.entrySet();
        	 for(Map.Entry en : entry) {
        		 if(en.getKey().equals(name)) {
        			 
        			if(wallet-stockqunt*Sfile.get(name).getPrice()>0) {
        				Customer cus= new Customer(cusEmail,cusPassword,wallet-stockqunt*Sfile.get(name).getPrice(),Cfile);
           			 cus.stockList(Sfile.get(name),stockqunt);
           			 
           			 Cfile.put(cusEmail, cus);
           			 System.out.println("your new amount balance");
           			System.out.println(cus.getWallet());
        			}else {
        				System.out.println("your Low Account Balance");
        			}
        			 
        		 }
        		 
        	 }
        	 } 
         }
       
}
