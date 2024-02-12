package edu.mu.MediaProduct;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	public MediaProduct(String title, double price, int year, Genre genre) {
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}
	
	//copy constructor
	public MediaProduct(MediaProduct copy) {
        this.title = copy.title;
        this.price = copy.price;
        this.year = copy.year;
        this.genre = copy.genre;
    }

}


