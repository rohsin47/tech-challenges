## EUR FX Rate Service

### Requirements

Your task is to create a foreign exchange rate service as SpringBoot-based microservice.

The exchange rates can be received from [2]([2] https://www.bundesbank.de/dynamic/action/en/statistics/time-series-databases/time-series-databases/759784/759784?listId=www_s331_b01012_3). This is a public service provided by the German central bank.

As we are using user story format to specify our requirements, here are the user stories to implement:


> * As a client, I want to get a list of all available currencies.
> * As a client, I want to get all EUR-FX exchange rates at all available dates as a collection
> * As a client, I want to get the EUR-FX exchange rate at particular day
> * As a client, I want to get a foreign exchange amount for a given currency converted to EUR on a particular day.


### How to Run

1. Export the project as java maven project type and build. 
	* Make sure lombok plugin is set correctly in IDE as the project is using the same for POJOs.
	* Application is primarily built on Java 8 and Spring boot 2.4.4.
	* Application has been compiled and tested on JDK 11 too.
2. Run the main class _FxRateServiceApplication_
3. The app will load latest fx rates using German bank API service and insert into in-memory db.
   * [H2 Console](http://localhost:8080/h2-console)
   * Application is loading live fx rates for 10 currencies including historical data. More currencies with keys can be added in _FxRateProviderKeys_ class. It should load auto all of them.
4. The below APIs provide the user stories

	* http://localhost:8080/api/v1/currencies
	* http://localhost:8080/api/v1/fxrate/all
	* http://localhost:8080/api/v1/fxrate/query?asOfDate=2021-05-04
	* http://localhost:8080/api/v1/fxrate/query?asOfDate=2021-05-04&currency=AUD
	



