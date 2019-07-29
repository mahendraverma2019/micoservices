package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfoService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalog",
			threadPoolKey = "movieInfoPool",
			threadPoolProperties = {
					@HystrixProperty(name="coreSize", value = "20"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			})
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getMovieId(), movie.getName(), rating.getRating());
	}
	
	public CatalogItem getFallbackCatalog(Rating rating) {
		return new CatalogItem("Movie name not found", "", rating.getRating());
	}
}
