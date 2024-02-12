package edu.mu.MediaProduct;

public class VinalRecordProduct extends MediaProduct {

	public VinalRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	
	public VinalRecordProduct(VinalRecordProduct copyVRP) {
		super(copyVRP);
	}

}
