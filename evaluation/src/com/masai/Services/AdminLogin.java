package com.masai.Services;
import java.util.*;
import com.masai.*;
public class AdminLogin {
     public static boolean checkAdmin(String user, String pass) {
    	 if(user.equals("admin")&& pass.equals("1234")) {
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
     }
}
