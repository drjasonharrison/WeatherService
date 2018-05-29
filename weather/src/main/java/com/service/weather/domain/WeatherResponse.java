package com.service.weather.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.restassured.path.json.JsonPath;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class WeatherResponse {
    private String date;
    private String cityName;
    private String description;
    private String fahrenheit;
    private String celsius;
    private String sunriseTime;
    private String sunsetTime;
    
	/** 
     * Construct a WeatherResponse from the JSON returned from OpenWeatherMap
     * @param json response from OpenWeathermap
     * @return WeatherResponse with the values we are concerned with
     */
	public WeatherResponse(String jsonWeather) {
        this.date = java.time.LocalDate.now().toString();
        JsonPath jsonPath = JsonPath.from(jsonWeather);

        cityName = jsonPath.getString("name");
        description= jsonPath.getString("weather[0].description");

        Double kelvin = jsonPath.getDouble("main.temp");
        fahrenheit = kelvinToFahrenheit(kelvin);
        celsius = kelvinToCelsius(kelvin);
        
        sunriseTime = getSunRiseTime(jsonPath);
        sunsetTime = getSunSetTime(jsonPath);
    }

	/** 
	 * Used by getSunRiseTime and getSunSetTime to format the time
	 * @param date Date object to extract time from
	 * @return formated 12 hour time (eg, 8:03 am)
	 */
    private String getTimeFromDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        return sdf.format(date);
    }

    private String getSunSetTime(JsonPath jsonPath) {
    	// sunrise/sunset time is in epoch seconds, convert to milliseconds
        return getTimeFromDate(new Date(jsonPath.getLong("sys.sunset") * 1000));
    }

    private String getSunRiseTime(JsonPath jsonPath) {
    	// sunrise/sunset time is in epoch seconds, convert to milliseconds
        return getTimeFromDate(new Date(jsonPath.getLong("sys.sunrise") * 1000));
    }

    private String kelvinToFahrenheit(Double kelvin) {
        return formatTemp(9.0 / 5.0 * (kelvin - 273.0) + 32.0);
    }
    
    private String kelvinToCelsius(Double kelvin) {
        return formatTemp(kelvin - 273.15);
    }
    
    private String formatTemp(double temp) {
    	return String.format("%.1f", temp);
    }
}
