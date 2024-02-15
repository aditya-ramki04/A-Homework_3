package edu.mu.MediaProduct;

public class TapeRecordProduct extends MediaProduct {

	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "TapeRecordProduct [title= " + title + ", price= " + price + ", year= " + year + ", genre= " + genre + "]";
	}

	public TapeRecordProduct(TapeRecordProduct copyTRP) {
		super(copyTRP);
	}

}
