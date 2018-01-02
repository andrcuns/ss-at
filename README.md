# ss-at
[![Build Status](https://travis-ci.org/andrcuns/ss-at.svg?branch=master)](https://travis-ci.org/andrcuns/ss-at)
A sample UI testing project using following tech stack:
* [Selenide](https://github.com/codeborne/selenide) - selenium wrapper
* [Guice](https://github.com/google/guice) - dependency injection
* [Cucumber](https://cucumber.io/) - BDD test specification
* [Gradle](https://github.com/gradle/gradle) - build tool

## Running tests from command line
Tests can be executed with following command:
```bash
./gradlew clean test -Preport=cucumber|allure
```
Default report is `cucumber`.

## Reporting
* [Cucumber](https://github.com/damianszczepanik/cucumber-reporting) - prettified native cucumber report
* [Allure](https://github.com/allure-framework/allure2) - allure reports

Current allure report published by travis is available through [Github Pages](https://andrcuns.github.io/)

### Generating and opening reports   
To generate and open allure report after running test with allure report type following command can be used:
```bash
./gradlew downloadAllure allureServe
```
To generate cucumber html report after running tests with cucumber report type following command can be used:
```bash
./gradlew generateCucumberReport
```