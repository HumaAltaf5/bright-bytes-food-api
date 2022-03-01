# Healthy Food API

## Introduction
This is a Repository for a Healthy Food API called Bright Bytes. This API allows users to specify calories and the type of meals they are interested in and returns 3 healthy meals amounting to the total number of calories input by the user.

## Description
The Healthy Food API displays meals according to users requirements. Users can input the numbers of calories and choose the meal type they are interested in eg. Veg or Non Veg meal and send a 'Get Request' to the endpoints below to see 3 meals amounting to the calories specified.  
End Points :
1. Get /meals - Returns json response of 3 veg/non veg meals with no calorie limit 
2. Get /meals/calories?type=veg&cal=2000 - Returns json response of 3 veg meals summing upto 2000 calories
3. Get /meals/calories?type=nonveg - Returns json response of 3 non veg meals with no calorie limit
4. Get /meals/calories?cal=1800 - Returns json response of 3 veg/nonveg meals summing upto 1800 calories 
5. Get /actuator/info - Returns json response with API info
6Get /actuator/health - Returns json response with API health


## Pre-Requisites
- Java SE Development Kit 11
- Maven

## Technologies and Dependencies
- Spring Boot
- Spring Web
- MySQL Database
- mysql-connector-java
- Spring Data JPA
- Spring Actuator
- Spring Test

### How to get Started
- Fork and clone the repository from GitHub

### Main Entry Point
- The main entry point for the application is: [FoodapiApplication.java](/src/main/java/com/brightbytes/foodapi/FoodapiApplication.java)

### Running Unit Tests
- Tests can be run from IntelliJ from the test folder or from the terminal inside the root directory using: mvn test

### Externalising Configurations - application.properties
- The application.properties consists of all the required settings for the database connection and the /info and /health end points for the api

### Database scripts
- The database scripts required to interact with the database can be viewed in the [dbscripts](/src/main/resources/dbscripts) folder


