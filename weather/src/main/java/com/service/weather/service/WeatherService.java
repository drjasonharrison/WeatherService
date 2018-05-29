package com.service.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.service.weather.domain.WeatherResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService {

    private RestTemplate restTemplate;
    
    private final String url = "http://api.openweathermap.org/data/2.5/weather";

    public WeatherService() {
        restTemplate = new RestTemplate();
    }

    public WeatherResponse retrieveCurrentWeather(String city) {
    	String url = buildUrl(city);
        log.info("buildUrl for: " + city + "; url: " + url);       
    	String jsonWeather = restTemplate.getForObject(url, String.class);
        log.info("JSON object retrieved: " + jsonWeather);
        WeatherResponse response = new WeatherResponse(jsonWeather);
        return response;
    }
    
    private String buildUrl(String city) {
    	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
    	        .queryParam("id", city)
    	        .queryParam("mode", "json")
    	        .queryParam("APPID", "c8f638bd81f2b411844c3982b70fde00");
    	return builder.toUriString();
    }
}
