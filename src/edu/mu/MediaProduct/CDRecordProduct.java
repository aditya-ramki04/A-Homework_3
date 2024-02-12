package edu.mu.MediaProduct;

public class CDRecordProduct extends MediaProduct{

	public CDRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	
	public CDRecordProduct(CDRecordProduct copyCDRP) {
		super(copyCDRP);
		// TODO Auto-generated constructor stub
	}

}
