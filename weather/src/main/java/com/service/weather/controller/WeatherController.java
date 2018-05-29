package com.service.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriUtils;

import com.service.weather.domain.WeatherResponse;
import com.service.weather.domain.WeatherRequest;
import com.service.weather.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WeatherController {

	private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("CityWeatherRequest", new WeatherRequest());
        return "index";
    }

    @PostMapping("/weather")
    public String postWeatherForm(Model model, @ModelAttribute WeatherRequest request) {
    	String cityName = request.getCityName();
    	cityName = UriUtils.decode(cityName, "UTF-8"); // TODO: shouldn't need this
    	log.info("getting weather for " + cityName);
    	WeatherResponse weather = weatherService.retrieveCurrentWeather(cityName);
    	
        model.addAttribute("weather", weather);
        return "weather";	
    }

}