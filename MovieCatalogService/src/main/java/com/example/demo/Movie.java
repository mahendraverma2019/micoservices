package com.example.demo;

public class Movie {
private String movieId;
private String name;
private String overview;
private double rating;

public Movie() {}
public Movie(String movieId, String name, String overview, double rating) {
	super();
	this.movieId = movieId;
	this.name = name;
	this.overview = overview;
	this.rating = rating;
}
public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
