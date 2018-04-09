# ss-at
[![Build Status](https://travis-ci.org/andrcuns/ss-at.svg?branch=master)](https://travis-ci.org/andrcuns/ss-at)
A sample UI testing project using following tech stack:
* [Selenide](https://github.com/codeborne/selenide) - selenium wrapper
* [Guice](https://github.com/google/guice) - dependency injection
* [Cucumber](https://cucumber.io/) - BDD test specification
* [Gradle](https://github.com/gradle/gradle) - build tool
* [Courgette-JVM](https://github.com/prashant-ramcharan/courgette-jvm) - parallel execution for cucumber

## Running tests from command line
Tests can be executed with following commands.
In sequence:
```bash
./gradlew clean runCukeTests
```
In parallel:
```bash
./gradlew clean runCukeTestsInParallel
```

## Reporting
* [Cucumber](https://github.com/damianszczepanik/cucumber-reporting) - prettified native cucumber report
* [Allure](https://github.com/allure-framework/allure2) - allure reports
* [Courgette-JVM](https://github.com/prashant-ramcharan/courgette-jvm) - courgette-jvm report for parallel execution

Cucumber and allure report path will be visible in console output after test task execution

Current allure report published by travis is available through [Github Pages](https://andrcuns.github.io/)