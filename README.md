# Spring Boot MongoDB REST API

This is a Spring Boot REST API application with a MongoDB database. The application is designed around a `Client` model, which includes fields for `id`, `ip`, `email`, and `name`.

# Security
I used simple username/password authentication, with user and admin users(mainly to practice the new lambda dsl for spring security). </br>
## Model

The `Client` model includes the following fields:

- `id`: This is an identifier for the client. It should comply with Israeli ID standards.
- `ip`: This is the IP address for the client. It should be a valid IPv4 address.
- `email`: This is the email address for the client.
- `name`: This is the name of the client. It should be in the format "first last", where "first" is the first name and "last" is the last name.

## Initialization

The application can initialize the database from a CSV file with 30,000 records. </br>
This initialization is controlled by the `init.database` property. If this property is set to `true`, the application will load the records from the CSV file into the database.
I used the ip-api API to get the IP address location, 100 at a time, carefully using spring-retry with exponential back-off strategy to avoid overloading the API.
The entire init process should take about 10 minutes. after the first run, please set the `init.database` property to `false` to avoid re-initializing the database.

## Exception Handling

The application includes exception handling using `@RestControllerAdvice`. This ensures that exceptions are handled in a consistent manner across the application.

## Validation

The application includes custom validation annotations.</br>
These are implemented using the Spring Boot Starter Validation, and spring AOP.

## Running the Application(server+database)
1. extract the zip file
2. use the maven wrapper to build the project: `./mvnw clean package`
3. run `docker compose up`
4. don't forget to update the relevant properties in the `application.properties` file, or the env variables if you use docker-compose.

## Testing the API
- The API is documented using Swagger. You can access the Swagger UI at `http://localhost:8080/swagger-ui.html`.