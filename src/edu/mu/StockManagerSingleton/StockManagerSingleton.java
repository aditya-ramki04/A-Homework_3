package edu.mu.StockManagerSingleton;

public class StockManagerSingleton {

	
	private static StockManagerSingleton instance = null;
	// Define paths as final so that they cannot be modified later.
	private static String inventoryFilePath;
	
	
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
//	public boolean updateItemPrice(MediaProduct product, double newPrice)
//	{
//		return true;
//	}
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
