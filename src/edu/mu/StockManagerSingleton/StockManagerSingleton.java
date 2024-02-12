package edu.mu.StockManagerSingleton;
import java.util.ArrayList;
import edu.mu.MediaProduct.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class StockManagerSingleton {

	
	private static StockManagerSingleton instance = null;
	// Define paths as final so that they cannot be modified later.
	private static String inventoryFilePath = "inventory.csv";
	private ArrayList<MediaProduct> inventory = new ArrayList<MediaProduct>();
	
	
	public StockManagerSingleton() 
	{
		
	}
	    
	public static synchronized StockManagerSingleton getInstance() 
	{
        if (instance == null) 
        {
            instance = new StockManagerSingleton();
        }
        return instance;
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
				String title = parts[1];
				double price = Double.parseDouble(parts[2]);
				int year = Integer.parseInt(parts[3]); //using parseInt to parse it from String to int and then storing it in id.
				Genre genre = Genre.valueOf(parts[4]);
				inventory.add(new MediaProduct(title, price, year, genre));
			}
			fileIn.close();//closes file
			
			/* testing purposes
			 *  for(int i = 0; i < inventory.size(); i++) {
			 * System.out.println(inventory.get(i)); }
			 */
			return true;
		} catch (FileNotFoundException e) //if file not found then return no file found and return false.
		{
			System.out.println("No File Found");
			e.printStackTrace();
			return false;
		}
	}
	
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
