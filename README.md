# DATA PROJECT MANAGEMENT SERVICE

This repository will handle all service (CRUD) request to Project Management database scheme. 
### When creating new code repository for new microservice developer should :
1. Next you can start this task on seperate branch : `task/<dev_name>`
   - You can initiate new code on your working branch (seperate branch for each developer).
   - After finish the task then push all source code to this branch
2. Project must have unit test.
3. Project should implement clean code and no finding (critical & blocker) for code smelling.  
  
### Scope Requirements
|Task|Detail|
|------------------|------------------|
|Epic|![plot](/doc/slide_1.jpg)|
|Class Diagram|![plot](/doc/slide_2.jpg)|
|Entity Relationship Diagram|![plot](/doc/slide_3.jpg)|

## Features
   - can add/edit/delete/view for project data
   - can add/edit/delete/view for employee data
   - can assign project to employee
   - can assign choose employee and assign as project lead

## Endpoint Naming Convention

- All endpoint should using method `POST` 
- URL path should be in lowercase 

Acceptable pattern for endpoint are below : 

| Pattern  | Example |Description|
|-----------|-------------|-------------|
|/`${version_controller}`/`${object}`/`${operation}` | /v1/cat/create | save/create object cat |

Below are example endpoint convention standard for operation CRUD described by example object `cat`:

| Endpoint  | Operation |Result|
|-----------|-------------|-------------|
|/v1/cat/|get all cat |List of object cat|
|/v1/cat/create|insert cat  |Status of create object cat|
|/v1/cat/update|update cat |Status of update object cat|
|/v1/cat/delete|delete cat |Status of delete object cat|
|/v1/cat/detail|get detail cat| Detail of object cat|

## Project Structure Description
 ```
src
├── main
│   └── java
│   │  └── id.co.ist.java.test
│   │      ├── component                                               # Package containing class that can be used as parent class for service class
│   │      ├── config                                                  # Package containing class with annotation @Config or any class for configuration 
│   │      ├── constant                                                # Package containing constant class
│   │      ├── controller                                              # Package containing controller class
│   │      ├── domain                                                  
│   │      │   ├── dao                                                 # Package containing dao/entity class class
│   │      │   └── dto
│   │      │       ├── common                                          # Package containing pojo / dto class that commonly used within this project (can be created if needed)
│   │      │       ├── external                                        # Package containing dto class that is used for messaging to/from surrounding & other microservices
│   │      │       └── internal                                        # Package containing dto class that is used for messaging to/from front end
│   │      ├── exception                                               # Package containing exception class & exception handler
│   │      ├── repository                                              # Package containing jpa interface & class
│   │      ├── service                                                 # Package containing class to handle business logic
│   │      └── util                                                    # Package containing custom utility & helper class with static method
│   └── resources
└── test
    └── java
    │  └── id.co.ist.java.test
    │      ├── component                                               # Package containing unit test class for component class
    │      ├── controller                                              # Package containing integration test & unit test for controller class
    │      ├── domain                                                  # Package containing dto & pojo class for testing purpose
    │      ├── repository                                              # Package containing unit test class for jpa interface & class
    │      ├── service                                                 # Package containing unit test class for class that handle business logic
    │      └── util                                                    # Package containing unit test class for utility & helper class
    └── resources

```


## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)
- [ORM JPA Hibernate]

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

## References
- [Versioning in REST API](https://javahotfix.blogspot.com/2019/03/versioning-in-rest-api.html)
- [Git Tutorials](https://www.atlassian.com/git/tutorials)
- [Spring Tutorials](https://spring.io/guides#tutorials)
