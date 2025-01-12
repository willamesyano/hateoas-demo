# Spring Boot Project

This project is a Spring Boot application designed to demonstrate the functionality of HATEOAS. Follow the instructions below to set up and run the application.

---

## Prerequisites

Ensure you have the following installed on your machine:

- **Java Development Kit (JDK)**: Version 11 or higher
- **Maven**: Version 3.6 or higher
- **Postman** (optional, for API testing)

---

## Running the Application

1. **Clone the Repository**:
   ```bash
   git clone git@github.com:willamesyano/hateoas-demo.git
   cd hateoas-demo
   ```

2. **Build the Project**:
   Run the following command to download dependencies and build the project:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   Start the application with:
   ```bash
   mvn spring-boot:run
   ```
   The application will be accessible at `http://localhost:8080`.

---

## Testing the API

### Using Postman

A Postman collection is available to facilitate API testing. You can find it at:

```
/hateoas-demo/src/main/resources/postman/HateoasDemo.postman_collection.json
```

1. Open Postman.
2. Import the collection using the file above.
3. Use the provided requests to test the API endpoints.

---

## Troubleshooting

If you encounter issues, ensure that:

1. The required ports (e.g., 8080) are not in use.
2. All dependencies have been successfully installed.
3. You are using the correct JDK and Maven versions.

---

## Contributing

Feel free to fork this repository and contribute by submitting pull requests. Contributions are always welcome!

---

## License

This project is licensed under the [MIT License](LICENSE).

