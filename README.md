# Weather website 

## Description
* A website which will return current weather data from [OpenWeatherMap.org](OpenWeatherMap.org), based on a city chosen by the user, which should support:
  * London
  * Hong Kong
* the user is able to input their choice of city via a standard HTML <form> & receive results showing:
  * today’s date
  * the city name
  * overall description of the weather (e.g. "Light rain", "Clear sky", etc.) o temperature in Fahrenheit and Celsius
	* sunrise and sunset times in 12 hour format (e.g. 9:35am; 11:47pm)
* the styling / layout of the website itself is not a priority — please feel free to use plain HTML with no styling

## Implementation details

* the backend of the application uses core Java SE, EE and any 3rd party libraries that you deem relevant
* the project uses Maven 3.3 and Java SE8. Full instructions for set-up on macOS 10.11 are included below.
* the website should able to be run on a port of ‘localhost’, via some embedded application server (e.g. Jetty or similar)
* Production quality code is much more important than feature completion.
  *  If you run out of time, please err on the side of ensuring the code you have
implemented is ‘production-ready’, even if it means completing less features.

### Setup (Mac OSX 10.11)

1. Download and install Java SE 8, and Java EE 8 from Oracle.com. 
  * Since these are older versions of Java, you may need to use google to find links to the installers.
  * You may also need to create an account on oracle.com to download the older versions.  
  * [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html)
  * [Java EE 8)(http://www.oracle.com/technetwork/java/javaee/downloads/java-ee-sdk-downloads-3908423.html)
1. Install homebrew using instructions at [https://brew.sh/](https://brew.sh/)
1. At the command line, install maven using:
```
brew install maven
```

### Additional setup 

1. You may want to use [jenv](https://www.jenv.be/) to manage your Java environment. Use `brew install jenv` to install it.
1. If you are seeing errors regarding getters and setters in your IDE. 
  1. Exit the IDE
  2. Then follow the installation steps at [Lombok](http://codeomitted.com/setup-lombok-with-stseclipse-based-ide/)
  3. Launch your IDE. 
  4. Right click on the project, select Maven > Update Project

  Note: if you have built the project then Lombok is probably installed in ~/.m2/repository/org/projectlombok/lombok/1.16.20

## To Do

* use city names, rather than id's
* create default root page with form to select city and submit request
  * "q=London,uk" or id=2643743
  * "q=Hong%20Kong" or id=1819729
* create service that responds to submitted requests
* send request to OpenWeatherMap.org and receive response
  * eg [example](http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=c8f638bd81f2b411844c3982b70fde00)
* parse JSON response extracting:
  * name: city name
  * weather.main: overall description of the weather
  * main.temp: temperature in Kelvin
  * sys.sunrise: sunrise time (UTC seconds)
  * sys.sunset: sunset time (UTC seconds)
* add local system date
  
* convert temperature from Kelvin to Celsius and Fahrenheit
* convert sunset and sunrise from UTC to local time in 12-hour clock

* handle error responses from OpenWeatherMap
* define an error handler for internal errors
* unit tests: WeatherResponse
* move OpenWeatherMap API key into server configuration file
* load list of cities and ID's from OpenWeatherMap city.list.json
* use city IDs rather than string names
* add database, or memory cache, of recent weather requests. Use cached value for requests within ten minutes, or even up to an hour
* localization: strings, dates and temperature formats
* error checking of json response (schema) or individual json paths

