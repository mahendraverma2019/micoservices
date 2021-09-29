package com.example.demo;

public class MovieSummary {
private String movieId;
private String titile;
private String overview;
public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
}
public String getTitile() {
	return titile;
}
public void setTitile(String titile) {
	this.titile = titile;
}
public String getOverview() {
	return overview;
}
public void setOverview(String overview) {
	this.overview = overview;
}

	@Override
	public String toString() {
		return "MovieSummary{" +
				"movieId='" + movieId + '\'' +
				", titile='" + titile + '\'' +
				", overview='" + overview + '\'' +
				'}';
	}
}
