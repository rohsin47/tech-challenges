# Problem Statement 

Traders want a system to show the real-time value of her portfolio which consist of three types of products:  

  Common stocks. 
  European Call options on common stocks.  
  European Put options on common stocks.  

 

## Requirements 

Your task is to design and implement a system in Java that: 

```
1. Get the positions from a mock CSV position file (consisting of tickers and number of  shares/contracts of tickers in the portfolio)  
```

```
2. Get the security definitions from an embedded database. 
3. Design a schema with small embedded database (H2 or SQLite) to store the security definitions (three supported types: Stock, Call, Put). Each security in this database will have a ticker (identifier) and will have some static (e.g. strike, maturity) 
```
```
4. Implement a mock market data provider that publishes stock prices.  The stock prices move according to either 

Random pricing 
or Preferable a discrete time geometric Brownian motion (see appendix) randomly between 0.5 � 2 seconds. 
```

```
5.Calculate the real time option price with the underlying price 
```

```
6. Publishes following details in real-time:  
	Each position�s market value.  
	Total portfolio�s NAV. 
```

```
7. Implement a portfolio result subscriber.  
	Listener the above result  
	print it into console (pretty print) 
```
 

## Build

To build the executable jar, unzip the project and the run the following maven command in the project root directory:

```
$ mvn clean install
```

This will create a jar ** portfolio-manager.jar ** in <project root>/target/ directory.


## Run

To run the program:

```
$ java -jar portfolio-manager.jar

This will start publishing portfolio positions in real time.
```


 

 