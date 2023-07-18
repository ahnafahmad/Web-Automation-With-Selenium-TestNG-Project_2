# Web Automation With Selenium-Java TestNG


## Tool used in this Project
 - Selenium


## Framework used in this Project
 - TestNG


 ## Project Scenarios
 - User can sign up to the System.
 - User can Enter all the neccessary Information 
 - User can Login to the System.
 - User can logout from the system
 - User can Delete the Account from the System.
   

 ## How to run this project:
 - Clone this project [Web-Automation-with-Selenium_TestNG](https://github.com/ahnafahmad/Web-Automation-With-Selenium-TestNG-Project_2.git)
 - Hit the following command:
  ```
 gradle clean test
 ```
 
  ## How to Generate an Allure Report: 
 Automated Automation Exercise website using Selenium and TestNG, where test cases are added for User Signup ,User Login, Account Delete by the User from the System.
 Steps to generate the report:
 - Give the following commands by opening the terminal in the project folder to create the Allure Report:
```
allure generate allure-results --clean -o allure-report
 ```
 ```
 allure serve allure-results
```

 ## Prerequisite
  - Some gradle dependencies are a must for running this project
  These are: 
 ```
// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.9.1'
 ```
 ```
// https://mvnrepository.com/artifact/org.testng/testng
    testImplementation group: 'org.testng', name: 'testng', version: '7.7.1'
```
```
// https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
    implementation group: 'io.github.bonigarcia', name: 'webdrivermanager', version: '5.3.2'
```
```
// https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    implementation group: 'com.github.javafaker', name: 'javafaker', version: '1.0.2'
```
```
// https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'
```
```
// https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation group: 'io.qameta.allure', name: 'allure-testng', version: '2.17.3'
```
```
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly group: 'org.projectlombok', name: 'lombok', version: '1.18.24'
```
```     
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    testImplementation group: 'org.projectlombok', name: 'lombok', version: '1.18.24'
```
```     
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    testAnnotationProcessor group: 'org.projectlombok', name: 'lombok', version: '1.18.24'
```
