package edu.mu.StockManagerSingleton;
import java.util.ArrayList;
import edu.mu.MediaProduct.*;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class StockManagerSingleton {

	
	private static StockManagerSingleton instance = null;
	// Define paths as final so that they cannot be modified later.
	private static String inventoryFilePath = "inventory.csv";
	private ArrayList<MediaProduct> inventory = new ArrayList<MediaProduct>();
	
	
	public StockManagerSingleton() 
	{	
	}

	public boolean initializeStock()
	{
		try {
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath)); //scans the file.
			
			fileIn = new Scanner(new FileInputStream(inventoryFilePath)); // reopens the file to start from the beginning again.
			
			int index = 0; // index variable to go through each student
			
			if (fileIn.hasNextLine()) {
	            fileIn.nextLine(); // Skip the header line
	        }
			while(fileIn.hasNextLine()) 
			{
				String line = fileIn.nextLine(); //gets the next line to hold the whole line 
				String parts[] = line.split(","); //splits the line at each " " so now the parts array has the id, Name, grade
				String type = parts[0];
				String title = parts[1];
				double price = Double.parseDouble(parts[2]);
				int year = Integer.parseInt(parts[3]); //using parseInt to parse it from String to int and then storing it in id.
				Genre genre = Genre.valueOf(parts[4]);
				
				//System.out.println(type);
				if(type.equals("CD")) {
					inventory.add(new CDRecordProduct(title, price, year, genre));	
				}
				if(type.equals("Vinyl")) {
					inventory.add(new VinylRecordProduct(title, price, year, genre));
				}
				if(type.equals("Tape")) {
					inventory.add(new TapeRecordProduct(title, price, year, genre));
				}
				//inventory.add(new MediaProduct(title, price, year, genre));
			}
			fileIn.close();//closes file
			
			/* testing piurposes
			 *  for(int i = 0; i < inventory.size(); i++) {
			 * System.out.println(inventory.get(i)); }
			 */
			
			for(int i = 0; i < inventory.size(); i++) {
				System.out.println(inventory.get(i));
			}
			
			return true;
		} catch (FileNotFoundException e) //if file not found then return no file found and return false.
		{
			System.out.println("No File Found");
			e.printStackTrace();
			return false;
		}
	}
	
	//Matthew wrote this code
	//Loops through the inventory array list and creates MediaProduct item through the
	//inventory at the designated spot and determines if the item equals the product with a boolean (True or false)
	//If true updates the item price through getters and setters and returns true. Otherwise prints error message and returns false
	public boolean updateItemPrice(MediaProduct product, double newPrice)
	{
		for(int i = 0; i < inventory.size(); i++ )
		{
			MediaProduct item = inventory.get(i);
	        if (item.equals(product)) 
	        {
	        	item.setPrice(newPrice);
	            return true; 
	        }
	            
		}
		System.out.println("Updating the Item Price failed. Try again!");
		return false;
	}
	
	//Matthew wrote this code
	//Determines if the product is null or not, if it is not null, adds a product to the MediaProducts and returns true. 
	//If product is null it returns false
	public boolean addItem(MediaProduct product)
	{
		if(product != null) {
			MediaProduct.add(product);
			return true;
		}
		return false;
		
	}
	//Matthew wrote this code
	//Determines if product is null, and if it isn't it loops through size of the inventory 
	//array list. at the selected spot where item equals the product, it removes the value at 
	//the designated inventory spot.
	public boolean removeItem(MediaProduct product)
	{
		if (product != null) 
		{
	        for (int i = 0; i < inventory.size(); i++) 
	        {
	            MediaProduct item = inventory.get(i);
	            if (item.equals(product)) 
	            {
	                inventory.remove(i); 
	                return true; 
	            }
	        }
	    }
	    return false;
	}
	
	public boolean saveStock()
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryFilePath))){	
			
			if (inventory.isEmpty()) {
				System.out.println("Cannot save empty stock.");
				return false;
			}
			writer.write("Title,Price,Year,Genre");
			writer.newLine();

			// Writing all the stock data to the CSV file
			for (MediaProduct item : inventory) {
				writer.write(item.toString());
				writer.newLine();
			}

			System.out.println("Stock saved successfully.");
			return true;

		} catch (IOException e) {
			System.out.println("Error saving stock: " + e.getMessage());
			return false;
		}
		
	}
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
