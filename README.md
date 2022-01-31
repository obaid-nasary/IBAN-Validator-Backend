# IBAN-Validator-Backend

This validator endpoint is for the validation of [International Bank Account Numbers](https://en.wikipedia.org/wiki/International_Bank_Account_Number) the frong for this is Built in [Angular](https://angular.io/) the link to the repository is [obaidnasary/IBAN-Validation-Frontend](https://github.com/obaidnasary/IBAN-Validation-Frontend/blob/master/README.md)

## Features

- Insert new IBAN numbers to the database and check if the IBAN number is valid or invalid
- Print the history and log of all the IBAN numbers inserted
- Filter IBAN numbers by valid and invalid 
- Delete an IBAN number by ID

## Requirements and Used Libraries

For building and running you will need:

- [JDK 17.0.2](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 4](http://maven.apache.org/POM)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Spring Boot Test](https://spring.io/projects/spring-boot)
- For Testing [H2 Database](https://www.h2database.com/html/main.html)

## Running locally

To run a Spring Boot application on your local machine you can either run by executing `main` method in your IDE [IntelliJ IDEA Recommended](https://www.jetbrains.com/idea/) from `src.main.java.com.example.IBAN.IbanApplication` or alternatively using the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) as the command below:

```shell
mvn sprint-boot run
```

