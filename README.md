# Weather Service 

## Description
* A website which will return current weather data from [OpenWeatherMap.org](OpenWeatherMap.org), based on a city chosen by the user, which should support:
  * London
  * Hong Kong
* the user is able to input their choice of city via a standard HTML <form> & receive results showing:
  * today’s date
  * the city name
  * overall description of the weather (e.g. "Light rain", "Clear sky", etc.) o temperature in Fahrenheit and Celsius
	* sunrise and sunset times in 12 hour format (e.g. 9:35am; 11:47pm)
* the styling / layout of the website itself is not a priority 

## Implementation details

* the backend of the application uses core Java SE, EE and some 3rd party libraries that I deemed relevant
* the project uses Maven 3.3 and Java SE8. Full instructions for set-up on macOS 10.11 are included below
* the website can be run on a port of ‘localhost’, using tomcat launched from Maven

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


## Running it

At the terminal, execute in the same directory as the pom.xml file:
```
mvn spring-boot:run
```

Then in your browser open [http://localhost:8090](http://localhost:8090).

## To Do

* handle error responses from OpenWeatherMap
* define an error handler for internal errors
* unit tests: WeatherResponse
* move OpenWeatherMap API key into server configuration file
* load list of cities and ID's from OpenWeatherMap city.list.json
* add database, or memory cache, of recent weather requests. Use cached value for requests within ten minutes, or even up to an hour
* localization: strings, dates and temperature formats
* error checking of json response (schema) or individual json paths
