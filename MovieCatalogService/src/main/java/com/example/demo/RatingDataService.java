package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingDataService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String userid) {
		return restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/" + userid, UserRating.class);
	}
	
	public UserRating getFallbackUserRating(String userid)  {
		UserRating rating = new UserRating();
		rating.setUserRating(Arrays.asList(new Rating("0",0)));
		return rating;
	}
}
