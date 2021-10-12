# Math API Web Server
A simple java web server for math api. it supports the following endpoint:
* /min: given list of numbers and a quantifier (how many) provides min number(s)
* /max: given list of numbers and a quantifier (how many) provides max number(s)
* /avg: given list of numbers calculates their average
* /median: given list of numbers calculates their median
* /percentile: given list of numbers and quantifier 'q', compute the qth percentile of the list elements

Note that all numbers are assumed to be integer for ease of display, we can easily
extend it to include float/double numbers.

## Run the web server locally
The project is compiled successfully with java 1.8. You can run the `main` method of the `WebServer` class, and it should start up the web server on your local machine.

You can then run the GET request in your browser or cURL or postman, etc:
* min: 
  * it takes 2 query parameters: "quantifier" for how many minimum numbers to return, "numbers" for the list of numbers
  * example: http://localhost:5000/min?quantifier=2&numbers=1,2,3,4,5
     * it returns the minimum 2 numbers among the list of numbers 
* max:
  * it takes 2 query parameters: "quantifier" for how many maximum numbers to return, "numbers" for the list of numbers
  * example: http://localhost:5000/max?quantifier=2&numbers=1,2,3,4,5
     * it returns the maximum 2 numbers among the list of numbers 
* avg:
  * it takes 1 query parameters: "numbers" for the list of numbers
  * example: http://localhost:5000/avg?numbers=1,2,3,4,5
     * it returns the avg of the list of numbers 
* median:
  * it takes 1 query parameters: "numbers" for the list of numbers
  * example: http://localhost:5000/median?numbers=1,2,3,4,5
     * it returns the median of the list of numbers 
* percentile: 
  * it takes 2 query parameters: "q" for percentile, "numbers" for the list of numbers
  * example: http://localhost:5000/percentile?q=40&numbers=1,2,3,4,5
     * it returns the qth percentile among the list of numbers 


## Run the unit test
We have some unit test in src/test/java folder.
```
mvn test
```
