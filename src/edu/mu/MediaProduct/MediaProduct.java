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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}


