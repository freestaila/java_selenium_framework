# java_selenium_framework

Simple framework for Web apps automation using Selenium, Maven, TestNG.
POM with Page Factory Pattern

## Modules

1. Applications - each app in separated package, contains page objects
2. Config - load driver with options
3. Utilities - contains base page object class to share driver and possible actions on pages
4. Test - contains tests and test suites for pages

## Structure

```
├───src
│   └───main
│       └───java
│           ├───applications
│           │   └───github
│           ├───config
│           └───utilities
│               ├───common
│               └───PageObject
└───test
    ├───java
    │   └───applications
    │       └───github
    │           ├───e2e_test
    │           ├───login_page
    │           └───main_page
    └───resources
    └───github
```

## Run test

Run .xml file for suite that should be executed. 