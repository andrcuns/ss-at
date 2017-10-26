# ss-at
Sample UI testing project using selenide, guice, gradle, cucumber-jvm and allure or cucumber reporting.

## Running tests from command line
Tests can be executed with following command:
```bash
./gradlew clean runCukeTests -Preport=cucumber|allure|junit
```
where _report_ generates either [allure](https://github.com/allure-framework/allure2) or [cucumber](https://github.com/damianszczepanik/cucumber-reporting) reports.