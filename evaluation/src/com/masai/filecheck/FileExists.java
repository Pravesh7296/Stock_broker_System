package com.masai.filecheck;
import java.util.*;
import com.masai.WholeClasses.*;
import java.io.*;
public class FileExists {
   public static Map<String,Customer> customerFileCheck(){
	   File c = new File("Customer.ser");
	   boolean flag=false;
	   Map<String,Customer> cFile=null;
	   
	   try {
	   if(!c.exists()) {
		   c.createNewFile();
		   flag=true;
		   
	   }
           if(flag) {
        	  cFile=new LinkedHashMap<String,Customer>() ;
        	  FileOutputStream fos = new FileOutputStream(c);
        	  ObjectOutputStream oos= new ObjectOutputStream(fos);
        	  oos.writeObject(cFile);
        	  FileInputStream fis = new FileInputStream(c);
        	  ObjectInputStream ois= new ObjectInputStream(fis); 
        	  Map<String,Customer>rFile = (Map<String,Customer>)ois.readObject();
        	  return rFile;
           }else {
        	   FileInputStream fis = new FileInputStream(c);
         	  ObjectInputStream ois= new ObjectInputStream(fis); 
         	  Map<String,Customer>rFile = (Map<String,Customer>)ois.readObject();
         	  return rFile;
           }
        
	   }catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return cFile;
   }
   
   public static Map<String,Stock> stockFileCheck(){
	   File s = new File("Stock.ser");
	   boolean flag=false;
	   Map<String,Stock> sFile=null;
	   
	   try {
	   if(!s.exists()) {
		   s.createNewFile();
		   flag=true;
		   
	   }
           if(flag) {
        	  sFile=new LinkedHashMap<String,Stock>() ;
        	  FileOutputStream fos = new FileOutputStream(s);
        	  ObjectOutputStream oos= new ObjectOutputStream(fos);
        	  oos.writeObject(sFile);
        	  FileInputStream fis = new FileInputStream(s);
        	  ObjectInputStream ois= new ObjectInputStream(fis); 
        	  Map<String,Stock>rFile = (Map<String,Stock>)ois.readObject();
        	  return rFile;
           }else {
        	   FileInputStream fis = new FileInputStream(s);
         	  ObjectInputStream ois= new ObjectInputStream(fis); 
         	  Map<String,Stock>rFile = (Map<String,Stock>)ois.readObject();
         	  return rFile;
           }
        
	   }catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return sFile;
   }
   public static Map<String,Transaction> transFileCheck(){
	   File t = new File("Transaction.ser");
	   boolean flag=false;
	   Map<String,Transaction> tFile=null;
	   
	   try {
	   if(!t.exists()) {
		   t.createNewFile();
		   flag=true;
		   
	   }
           if(flag) {
        	  tFile=new LinkedHashMap<String,Transaction>() ;
        	  FileOutputStream fos = new FileOutputStream(t);
        	  ObjectOutputStream oos= new ObjectOutputStream(fos);
        	  oos.writeObject(tFile);
        	  FileInputStream fis = new FileInputStream(t);
        	  ObjectInputStream ois= new ObjectInputStream(fis); 
        	  Map<String,Transaction>rFile = (Map<String,Transaction>)ois.readObject();
        	  return rFile;
           }else {
        	   FileInputStream fis = new FileInputStream(t);
         	  ObjectInputStream ois= new ObjectInputStream(fis); 
         	  Map<String,Transaction>rFile = (Map<String,Transaction>)ois.readObject();
         	  return rFile;
           }
        
	   }catch(Exception e){
		   System.out.println(e.getMessage());
	   }
	   return tFile;
   }
}
