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
		ArrayList<MediaProduct> BelowmaxPrice = stockManager.getMediaProductBelowPrice((int) 10.0);
		for(MediaProduct product : BelowmaxPrice) {
		System.out.println(product);
		}
		// // Update the price of a product
		boolean updateSuccessful = stockManager.updateItemPrice(stockManager.getInventory().get(0), 30.0);
		//System.out.println(stockManager.inventory.get(0).price);
		// Check if the update was successful
		if (updateSuccessful) {
		System.out.println("Price update successful.");
		} else {
		System.out.println("Price update failed. Product not found.");
		}
		MediaProduct mediaProduct = new MediaProduct("CD-test", 101.3, 1999, Genre.CHILDREN);
		boolean addItemSuccessful = stockManager.addItem(mediaProduct);

		// Check if the addition was successful
		if (addItemSuccessful) {
		System.out.println("Product added successfully.");
		} else {
		System.out.println("Failed to add product. Product may be null.");
		}
		boolean removeSuccessful = stockManager.removeItem(mediaProduct);
		// Display the inventory after removing the product
		System.out.println("\nInventory after attempting to remove the product:");
		stockManager.printListOfMediaProduct(stockManager.getInventory());
		// Check if the removal was successful
		if (removeSuccessful) {
		System.out.println("\nProduct removed successfully.");
		} else {
		System.out.println("\nFailed to remove product. Product not found in the inventory.");
		}
	}
}
