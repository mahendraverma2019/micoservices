package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		System.out.println("Request for movie id: " + movieId);
		MovieSummary summary =  restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
		System.out.println("Trying API :"+ "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey);
		/*
		 * Map<String,Movie> movies = new HashMap<>(); movies.put("0001", new
		 * Movie("0001","Titanic")); movies.put("0002", new Movie("0002",
		 * "Lord of the Rings")); movies.put("0003", new Movie("0003","Avengers"));
		 * return movies.get(movieId);
		 */
		
		return new Movie(movieId,summary.getTitile(),summary.getOverview());
	}
}
