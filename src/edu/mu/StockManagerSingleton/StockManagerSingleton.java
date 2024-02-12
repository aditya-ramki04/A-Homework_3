package edu.mu.StockManagerSingleton;

import edu.mu.MediaProduct.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockManagerSingleton {

	
	private static StockManagerSingleton instance = null;
	// Define paths as final so that they cannot be modified later.
	private static String inventoryFilePath;
	private List<MediaProduct> inventory;
	
	
	private StockManagerSingleton() 
	{
		this.inventoryFilePath = "inventory.csv";
	}
	    
	public static synchronized StockManagerSingleton getInstance() 
	{
        if (instance == null) 
        {
            instance = new StockManagerSingleton();
        }
        return instance;
    }

//	public boolean initializeStock()
//	{
//		return true;
//	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		for (MediaProduct item : inventory) 
		{
            if (item.equals(product)) 
            {
                // Update the price
                item.setPrice(newPrice);
                return true; // Update successful
            }
            
		}
		System.out.println("Updating the Item Price failed. Try again!");
		return false;
            
	}
	
//	public boolean addItem(MediaProduct product)
//	{
//		return true;
//	}
//	public boolean removeItem(MediaProduct product)
//	{
//		return true;
//	}
//	public boolean saveStock()
//	{
//		return true;
//	}
//	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice)
//	{
//		return 0;
//	}
//	public void printListOfMediaProduct(ArrayList<MediaProduct> productList)
//	{
//		
//	}
//	public ArrayList<VinylRecordProduct>getVinylRecordList(ArrayList<MediaProduct> productList)
//	{
//		return true;
//	}
//	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList)
//	{
//		return true;
//	}
//	public ArrayList<TapeRecordProduct>getTapeRecordList(ArrayList<MediaProduct> productList)
//	{
//		return true;
//	}
}
