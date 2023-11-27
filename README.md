# medMateBackend2

### Project Title
medMate

### Project Overview
The MedMate Backend System is designed to support healthcare professionals in efficiently accessing patient 
data and adherence reports. The primary goal is to enhance communication between healthcare providers and patients, 
providing a secure and reliable platform for monitoring medication adherence.

### Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- 
### Getting Started
To get started with the MedMate Backend System, follow the steps below:

#### Prerequisites

#### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/medmate-backend.git
   ```

2. Navigate to the project directory:
   ```bash
   cd medmate-backend
   ```

3. Build and run the project:
   ```bash
   ./mvnw spring-boot:run
   ```

### Project Structure

The project follows a modular structure with distinct packages serving different purposes:

```
medmate-backend
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.medmate
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── MedmateApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
│       └── java
│           └── com.example.medmate
│               ├── controller
│               ├── model
│               ├── repository
│               └── service
└── ...
```

### API Documentation

Detailed API documentation can be found in the [https://medmatebackend2-production.up.railway.app/swagger-ui/index.html#/](Api.md) file.
The documentation provides comprehensive information about each endpoint, including request and response formats, authentication mechanisms, and usage examples.

### License

This project is licensed under the [MIT License](LICENSE.md). See the [LICENSE.md](LICENSE.md) file for details.

