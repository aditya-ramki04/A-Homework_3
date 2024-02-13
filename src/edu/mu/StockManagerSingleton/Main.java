package edu.mu.StockManagerSingleton;

import java.util.ArrayList;

import edu.mu.MediaProduct.Genre;
import edu.mu.MediaProduct.MediaProduct;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockManagerSingleton stockManager = new StockManagerSingleton();
		stockManager.initializeStock();
		
		//made by nitin to test getMediaProductBelowPrice
//		ArrayList<MediaProduct> BelowmaxPrice = stockManager.getMediaProductBelowPrice((int) 10.0); 
//		for(MediaProduct product : BelowmaxPrice) {
//			System.out.println(product);
//		}

		// Do something with the belowMaxPriceProducts list


//	    // Update the price of a product
//	    boolean updateSuccessful = stockManager.updateItemPrice(stockManager.inventory.get(0), 30.0);
//	    //System.out.println(stockManager.inventory.get(0).price);
//	    // Check if the update was successful
//	    if (updateSuccessful) {
//	        System.out.println("Price update successful.");
//	    } else {
//	        System.out.println("Price update failed. Product not found.");
//	    }
	}
}
