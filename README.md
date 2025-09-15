# QA Automation Framework - Selenium & Java

![Allure Report](https://img.shields.io/badge/Report-Allure-brightgreen.svg) ![Java](https://img.shields.io/badge/Java-17-blue.svg) ![Selenium](https://img.shields.io/badge/Selenium-4-green.svg) ![TestNG](https://img.shields.io/badge/TestNG-7.11-yellow.svg) ![Maven](https://img.shields.io/badge/Build-Maven-red.svg)

This project is a comprehensive UI test automation framework designed to validate the functionality of a real estate web application. It was built from the ground up as a portfolio piece to showcase best practices in modern software testing, including Page Object Model, BDD with Cucumber, and advanced reporting with Allure.

The framework is architected to be **robust, scalable, and easily maintainable**, making it suitable for real-world enterprise applications.

---

## 🚀 Features

* **Page Object Model (POM)**: Cleanly separates test logic from UI interaction, making tests easier to read and maintain. * **Layered Architecture**: Clear separation between test layers (UI, business logic) for better organization.
* **Advanced Reporting**: Integrated with **Allure Report** to generate beautiful, detailed, and interactive test execution reports.
* **Automatic Screenshots on Failure**: Automatically captures a screenshot the moment a test fails and attaches it to the Allure report for quick debugging.
* **Behavior-Driven Development (BDD)**: Utilizes **Cucumber** and Gherkin syntax (`.feature` files) to write tests in a human-readable format, covering happy paths, empty fields, and invalid data scenarios.
* **Data-Driven Testing**: Employs TestNG's `DataProvider` for traditional tests and Cucumber `Examples` tables for BDD scenarios to run the same test logic with multiple datasets.
* **Cross-Browser Compatibility**: Designed to be easily configured for running tests on different browsers like Chrome, Firefox, etc.

---

## 🛠️ Tech Stack

* **Language**: Java 17
* **Browser Automation**: Selenium 4
* **Test Runner**: TestNG
* **Build Tool**: Maven
* **Reporting**: Allure Report
* **BDD Framework**: Cucumber
* **WebDriver Management**: WebDriverManager

---

## ⚙️ Getting Started

### Prerequisites

* Java JDK 17 or higher installed.
* Apache Maven installed.
* A compatible web browser (e.g., Google Chrome).


---

## ⚡ Running the Tests

You can run the entire test suite using the following Maven command. The tests will execute as defined in the `testng.xml` file.

```sh
mvn clean test
```

---

## 📊 Viewing the Allure Report

After running the tests, Allure results will be generated in the `allure-results` directory. To view the HTML report, run the following command:

```sh
allure serve
```

This will generate the report and open it in your default web browser.



---

## 👤 Author

* **[Luca Vinelli]**
* **LinkedIn**: `https://www.linkedin.com/in/luca-vinelli-723291351/`
* **GitHub**: `https://github.com/vinelis`
