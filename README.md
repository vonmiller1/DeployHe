# DeployHe

DeployHe is a Kotlin-based Spring Boot application designed as a clean and deployable backend template for Heroku. It includes a basic REST API with health checks and greeting endpoints, making it an ideal starting point for lightweight services or learning deployments in a production-like environment.

## Overview

This project demonstrates how to:

- build a Spring Boot application with Kotlin
- run the app locally with Maven Wrapper
- configure the project for Heroku deployment
- expose simple API endpoints for testing and verification

## Tech Stack

- Kotlin
- Java 11
- Spring Boot 2.6.2
- Maven
- Heroku-ready deployment setup

## Project Structure

```text
DeployHe/
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   └── com/backend/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── kotlin/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── system.properties
├── .gitignore
├── README.md
└── LICENSE
```

## Prerequisites

Before running or deploying the project, ensure you have:

- Java 11 or newer
- Maven 3.8+ (or use the included Maven Wrapper)
- Git
- Heroku CLI
- A Heroku account

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/DeployHe.git
cd DeployHe
```

### 2. Run the application locally

```bash
./mvnw clean spring-boot:run
```

Then open the app in your browser or run a curl command:

```bash
curl http://localhost:8080/services/hello
```

## API Endpoints

The application uses `/services` as the servlet context path.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/services/hello` | Returns `Hello World` |
| `GET` | `/services/hello/{name}` | Returns a personalized greeting |
| `GET` | `/services/health` | Returns the application health status |

### Example requests

```bash
curl http://localhost:8080/services/hello
curl http://localhost:8080/services/hello/Jane
curl http://localhost:8080/services/health
```

### Example responses

```json
"Hello World"
```

```json
"Hello Jane"
```

```json
{"status":"UP"}
```

## Testing

Run the test suite with:

```bash
./mvnw test
```

## Deployment to Heroku

### 1. Log in to Heroku

```bash
heroku login
```

### 2. Create a Heroku app

```bash
heroku create your-app-name
```

### 3. Deploy the application

```bash
git add .
git commit -m "Prepare deployment"
git push heroku main
```

If your default branch is `master`, use:

```bash
git push heroku master
```

### 4. Verify the deployed app

```bash
heroku open
```

## Configuration Notes

The project includes a `system.properties` file configured for Java 11 and a `server.servlet.context-path=/services` setting in `application.properties`, which makes the API available under the `/services` path.

For Heroku, the platform injects the required `PORT` automatically, so the app can run correctly in the deployed environment without additional manual configuration.

## Troubleshooting

Common issues during local development or deployment include:

- incorrect Java version in `system.properties`
- branch mismatch during deployment (`main` vs `master`)
- missing Heroku login or app creation step
- dependency resolution problems during Maven build

To inspect runtime logs:

```bash
heroku logs --tail -a your-app-name
```

## Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Heroku Java Support](https://devcenter.heroku.com/articles/java-support)
- [Heroku Dev Center](https://devcenter.heroku.com/)

## License

This project is intended for learning, experimentation, and deployment prototyping. Use it as a foundation for your own Spring Boot or Heroku-based services.
