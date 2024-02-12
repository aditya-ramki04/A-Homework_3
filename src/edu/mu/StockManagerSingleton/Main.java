package edu.mu.StockManagerSingleton;

import edu.mu.MediaProduct.Genre;
import edu.mu.MediaProduct.MediaProduct;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockManagerSingleton stockManager = new StockManagerSingleton();
		stockManager.initializeStock();
		

	    // Update the price of a product
	    boolean updateSuccessful = stockManager.updateItemPrice(stockManager.inventory.get(0), 30.0);
	    //System.out.println(stockManager.inventory.get(0).price);
	    // Check if the update was successful
	    if (updateSuccessful) {
	        System.out.println("Price update successful.");
	    } else {
	        System.out.println("Price update failed. Product not found.");
	    }
	}
}
