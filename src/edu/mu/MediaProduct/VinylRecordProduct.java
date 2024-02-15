package edu.mu.MediaProduct;

public class VinylRecordProduct extends MediaProduct {

	//made by nitin to test getMediaProductBelowPrice
	@Override
	public String toString() {
		return "VinylRecordProduct [title= " + title + ", price= " + price + ", year= " + year + ", genre= " + genre + "]";
	}

	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	
	public VinylRecordProduct(VinylRecordProduct copyVRP) {
		super(copyVRP);
	}

}
