package edu.mu.StockManagerSingleton;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.MediaProduct.CDRecordProduct;
import edu.mu.MediaProduct.Genre;
import edu.mu.MediaProduct.MediaProduct;
import edu.mu.MediaProduct.TapeRecordProduct;
import edu.mu.MediaProduct.VinylRecordProduct;



public class StockManagerSingleton {

	
	private static StockManagerSingleton instance = null;
	// Define paths as final so that they cannot be modified later.
	private final static String inventoryFilePath = "inventory.csv";
	private ArrayList<MediaProduct> inventory = new ArrayList<MediaProduct>();
	
	/**
	 * If the StockManagerSingleton has never been created before 
	 * it will instantiate the object. After it is created it will
	 * not be created again return the first one that has been created.
	 * 
	 * The Singleton Design pattern is for allowing developers to have
	 * one single instance to prevent synchronization issues. You can 
	 * consider the Singleton design pattern as a controlled global variable.
	 * @return the instance of StockManagerSingleton.
	 */
	
	public StockManagerSingleton() 
	{	
	}
	
	public static StockManagerSingleton getInstance()
	{
		if(instance == null)
		{
			instance = new StockManagerSingleton();
		}
		return instance;
	}
	//matthew added these to correctly instantiate objects
	public ArrayList<MediaProduct> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<MediaProduct> inventory) {
		this.inventory = inventory;
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
			
			/* testing purposes
			 *  for(int i = 0; i < inventory.size(); i++) {
			 * System.out.println(inventory.get(i)); }
			 */
			
//			for(int i = 0; i < inventory.size(); i++) {
//				System.out.println(inventory.get(i));
//			}
			
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
			getInventory().add(product);
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
	
	//by nitin
	public boolean saveStock() {	
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(inventoryFilePath, false));
			bw.write("Type,Title,Price,Year,Genre");
			bw.newLine();
			
		
			String type = null;
			
			for(MediaProduct product : inventory) {
				
				
				if(product instanceof CDRecordProduct) {
					type = "CD";
				}
				if(product instanceof VinylRecordProduct) {
					type = "Vinyl";
				}
				if(product instanceof TapeRecordProduct) {
					type = "Tape";
				}
				
				bw.write(type + "," + product.getTitle() + "," + product.getPrice() + "," + product.getYear() + "," + product.getGenre());
				bw.newLine();
			}
			bw.close();
			
			if (inventory.isEmpty()) {
				System.out.println("Cannot save empty stock.");
				return false;
			}
			
			System.out.println("Stock saved successfully.");
			return true;
				

			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
		
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice)
	{
		ArrayList<MediaProduct> BelowmaxPrice = new ArrayList<>();
		
		for(MediaProduct product : inventory) {
			if(product.getPrice() < maxPrice) {
				BelowmaxPrice.add(product);
			}
		}
		return BelowmaxPrice;
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList)
	{
		for(MediaProduct product : inventory) {
			System.out.println(product);
	}
	}
	//by nitin
	
	
	//Abhi Wrote this code
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList)
	{
		ArrayList<VinylRecordProduct> vinylRecordList = new ArrayList<VinylRecordProduct>(); //makes
		///VinylRecordProduct ArrayList to hold all the objects that are vinyl
		
		for (MediaProduct type : productList) 
		{ //used a for each loop here to loop through the objects
            if (type instanceof VinylRecordProduct) 
            { //if it is an instance of VinylRecordProduct then add
            	//to the vinylRecordList
            	vinylRecordList.add((VinylRecordProduct)type);
            }
        }
		return vinylRecordList; //then return the ArrayList

	}
	
	//Abhi Wrote this code
		public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList)
		{
			ArrayList<CDRecordProduct> cdRecordList = new ArrayList<CDRecordProduct>(); //makes
			///CDRecordProduct ArrayList to hold all the objects that are CDs
			
			for (MediaProduct type : productList) { //used a for each loop here to loop through the objects
	            if (type instanceof CDRecordProduct) { //if it is an instance of CDRecordProduct then add
	            	//to the cdRecordList
	                cdRecordList.add((CDRecordProduct)type);
	            }
	        }

			return cdRecordList; //then return the ArrayList
		}
		
		//Abhi Wrote this code
		public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList)
		{
			ArrayList<TapeRecordProduct> tapeRecordList = new ArrayList<TapeRecordProduct>(); //makes
			///TapeRecordProduct ArrayList to hold all the objects that are Tapes
			
			for (MediaProduct type : productList) { //used a for each loop here to loop through the objects
	            if (type instanceof TapeRecordProduct) { //if it is an instance of TapeRecordProduct then add
	            	//to the tapeRecordList
	            	tapeRecordList.add((TapeRecordProduct)type);
	            }
	        }

			return tapeRecordList; //then return the ArrayList
		}
}
	
	