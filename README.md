# Cloud Foundry Demo

## Objective

The purpose of this demo is to investigate scalability of CPU intencive application in Cloud Foundry environment.

## Description

fib-java is a simple Java Servlet that calculates N-th [Fibonacci number](http://en.wikipedia.org/wiki/Fibonacci_number). The calculation uses CPU intencive algorythm.

The Git repository includes

* source code;
* Maven build script;
* precompiled war file; and
* Cloud Foundry deployment manifest

## Usage

### Deployment to Cloud Foundry

1. Update manifest.yml. Replace fib-java with a unique application name to avoid URL naming collisions.
2. Use cf tool to deploy the app.
   ```
   cf push
   ```

### Servlet usage

Without any additional parameters the servlet returns 40-th Fibonacci number in HTML page. Open [application url](http://fib-java.poc.platform.comcast.net/) in a browser to see the result:

  ```
  Fibonacci number 40 is 102334155
  ```

The application accepts one parameter "n" for N-th Fibonacci number. THe default value is 40. Example: to get 30-th number use http://fib-java.poc.platform.comcast.net/?n=30

### Apache HTTP benchmarking

Run basic Apache benchmarking test

  ```
  ab -n 40 -c 8 http://fib-java.poc.platform.comcast.net/?n=40
  ```

Scale up the application and repeat the same test. Compare mean time per request between tests with different scaling factors.

  ```
  cf scale fib-java -i 8
  ```

## Building application from the source

Run Maven package

```
mvn package
```
