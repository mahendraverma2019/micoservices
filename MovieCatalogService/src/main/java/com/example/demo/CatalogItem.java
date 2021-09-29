package com.example.demo;

public class CatalogItem {
private String title;
private String description;
private int rating;
private String overview;
private double imdbRating;

public CatalogItem(String title, String name, int rating){
	super();
	this.title = title;
	this.description = description;
	this.rating = rating;
}

public CatalogItem(String title, String description, int rating, String overview, double imdbRating) {
	super();
	this.title = title;
	this.description = description;
	this.rating = rating;
	this.overview = overview;
	this.imdbRating = imdbRating;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
}
