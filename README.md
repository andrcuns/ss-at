# ss-at
Sample UI testing project using selenide, guice, gradle, cucumber-jvm and allure or cucumber reporting.

## Running tests from command line
Tests can be executed with following command:
```bash
./gradlew clean test -Preport=cucumber|allure
```
where _report_ generates either [allure](https://github.com/allure-framework/allure2) or [cucumber](https://github.com/damianszczepanik/cucumber-reporting) reports, default report is `cucumber`.   
To generate and open allure report after running test with allure report type following command can be used:
```bash
./gradlew downloadAllure allureServe
```
To generate cucumber html report after running tests with cucumber report type following command can be used:
```bash
./gradlew generateCucumberReport
```