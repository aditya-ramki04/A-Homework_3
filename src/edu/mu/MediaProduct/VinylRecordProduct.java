package edu.mu.MediaProduct;

public class VinylRecordProduct extends MediaProduct {

	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	
	public VinylRecordProduct(VinylRecordProduct copyVRP) {
		super(copyVRP);
	}

}
