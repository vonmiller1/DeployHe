# DeployHe

A simple Spring Boot project configured for deployment to Heroku.

This repository includes the basic setup needed to package a Java application for a Heroku deployment, including Java version configuration and a deployment-ready project structure.

## Overview

DeployHe is intended to help you:

- build a Spring Boot application with Java 11
- configure the project for Heroku hosting
- deploy an application using Git and the Heroku CLI

## Prerequisites

Before deploying, make sure you have:

- Java 11
- Maven (the Maven Wrapper is included)
- Git
- Heroku CLI
- A Heroku account

## Project Setup

### 1. Create a Heroku app

```bash
heroku login
heroku create your-app-name
```

### 2. Configure the Java runtime

Create a `system.properties` file in the project root:

```properties
java.runtime.version=11
```

### 3. Configure the app port

In `application.properties` or `application.yml`, set the server port to use Heroku's dynamic port:

```properties
server.port=${PORT:8080}
```

### 4. Deploy

```bash
git add .
git commit -m "Prepare deployment"
git push heroku main
```

If your branch is `master`, use:

```bash
git push heroku master
```

## Recommended Project Structure

```text
my-project/
├── src/
│   └── main/
│       ├── kotlin/
│       └── resources/
│           └── application.properties
├── src/test/kotlin/
├── pom.xml
├── system.properties
├── .gitignore
└── README.md
```

## API Endpoints

The application uses `/services` as its context path:

| Method | Endpoint | Response |
| --- | --- | --- |
| `GET` | `/services/hello` | `Hello World` |
| `GET` | `/services/hello/{name}` | A greeting for the requested name |
| `GET` | `/services/health` | `{"status":"UP"}` |

Run the test suite with the included Maven Wrapper:

```bash
./mvnw test
```

## Troubleshooting

Common issues include:

- wrong Java version in `system.properties`
- missing `PORT` configuration
- branch mismatch during deployment
- Heroku build failing due to missing dependencies

To view logs:

```bash
heroku logs --tail -a your-app-name
```

## Resources

- [Heroku Documentation](https://devcenter.heroku.com/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Heroku Java Support](https://devcenter.heroku.com/articles/java-support)

## License

This project is provided as-is for educational and deployment purposes.
