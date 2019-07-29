package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder builder;
	
	@Autowired
	private MovieInfoService movieInfoService;
	
	@Autowired
	private RatingDataService ratingDataService;

	@RequestMapping("/{userId}")	
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userid) {
		UserRating ratings = ratingDataService.getUserRating(userid);
		return ratings.getUserRating().stream().map(rating -> 
			movieInfoService.getCatalogItem(rating)
			// Movie movie = builder.build().get().uri("http://localhost:8081/movie/" +
			// r.getMovieId()).retrieve()
			// .bodyToMono(Movie.class).block();			
		).collect(Collectors.toList());
	}
	
}
