package com.masai.WholeClasses;
import java.util.*;
public class Stock {
       String Stockname;
       int price;
       int quantity;
	public Stock(String stockname, int price, int quantity) {
		super();
		Stockname = stockname;
		this.price = price;
		this.quantity = quantity;
	}

	public String getStockname() {
		return Stockname;
	}
	public void setStockname(String stockname) {
		Stockname = stockname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stock [Stockname=" + Stockname + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
