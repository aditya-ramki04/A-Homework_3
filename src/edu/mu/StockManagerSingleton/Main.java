package edu.mu.StockManagerSingleton;

import java.util.ArrayList;

import edu.mu.MediaProduct.CDRecordProduct;
import edu.mu.MediaProduct.Genre;
import edu.mu.MediaProduct.MediaProduct;
import edu.mu.MediaProduct.TapeRecordProduct;
import edu.mu.MediaProduct.VinylRecordProduct;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockManagerSingleton stockManager = new StockManagerSingleton();
		stockManager.initializeStock();

		boolean updateSuccessful = stockManager.updateItemPrice(stockManager.getInventory().get(0), 30.0);
		System.out.println(stockManager.getInventory().get(0).getPrice());
		if (updateSuccessful) {
			System.out.println("Price update was successful.");
		} else {
			System.out.println("Price update has failed.");
		}
		
		MediaProduct mediaProduct = new MediaProduct("CD-test", 101.3, 1999, Genre.CHILDREN);
		boolean addItemSuccessful = stockManager.addItem(mediaProduct);

		if (addItemSuccessful){
			System.out.println("Product was added successfully.");
		} else {
			System.out.println("Failed to add product.");
		}
		
		boolean removeSuccessful = stockManager.removeItem(mediaProduct);
		System.out.println("\nInventory after attempting to remove the product:");
		stockManager.printListOfMediaProduct(stockManager.getInventory());
		
		ArrayList<MediaProduct> BelowmaxPrice = stockManager.getMediaProductBelowPrice((int) 40.0);
		System.out.println("\nProducts below price: ");
		for(MediaProduct product : BelowmaxPrice) 
		{
			System.out.println(product);
		}
		
		if (removeSuccessful){
			System.out.println("\nProduct was removed successfully.");
		} else {
			System.out.println("\nFailed to remove product, not found in inventory.");
		}
	
		StockManagerSingleton sManager = new StockManagerSingleton();
        ArrayList<MediaProduct> productList = new ArrayList<>();
        
        VinylRecordProduct vinylProduct = new VinylRecordProduct("Vinyl 1", 12.99, 2024, Genre.ELECTRONIC);
        VinylRecordProduct vinylProduct2 = new VinylRecordProduct("Vinyl 2", 12.99, 2024, Genre.ELECTRONIC);
        productList.add(vinylProduct);
        productList.add(vinylProduct2);

        CDRecordProduct cdProduct = new CDRecordProduct("CD 1", 9.99, 2023, Genre.CLASSICAL);
        CDRecordProduct cdProduct2 = new CDRecordProduct("CD 2", 9.99, 2023, Genre.CLASSICAL);
        productList.add(cdProduct);
        productList.add(cdProduct2);

        TapeRecordProduct tapeProduct = new TapeRecordProduct("Tape 1", 7.99, 2022, Genre.CHILDREN);
        TapeRecordProduct tapeProduct2 = new TapeRecordProduct("Tape 2", 7.99, 2022, Genre.CHILDREN);
        productList.add(tapeProduct);
        productList.add(tapeProduct2);

        ArrayList<VinylRecordProduct> vinylList = sManager.getVinylRecordList(productList);
        System.out.println("Vinyl Record List:");
        for (VinylRecordProduct vinyl : vinylList) {
            System.out.println(vinyl); 
        }

        ArrayList<CDRecordProduct> cdList = sManager.getCDRecordsList(productList);
        System.out.println("\nCD Record List:");
        for (CDRecordProduct cd : cdList) {
            System.out.println(cd); 
        }

        
        ArrayList<TapeRecordProduct> tapeList = sManager.getTapeRecordList(productList);
        System.out.println("\nTape Record List:");
        for (TapeRecordProduct tape : tapeList) {
            System.out.println(tape); 
        }
        
        stockManager.saveStock();
	}
        
}

