package edu.mu.MediaProduct;

public class TapeRecordProduct extends MediaProduct {

	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	
	public TapeRecordProduct(TapeRecordProduct copyTRP) {
		super(copyTRP);
	}

}
