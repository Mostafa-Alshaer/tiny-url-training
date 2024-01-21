# Tiny URL Training

Welcome to the Tiny URL Training repository! This project is a simple URL shortening service implemented as part of a training exercise using Java and Spring Boot. The repository consists of a service that generates tiny URLs for given long URLs.

## Table of Contents

- [Introduction](#introduction)
- [Sequencer Service](#sequencer-service)
- [How It Works](#how-it-works)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Scalability](#Scalability)
- [Contributing](#contributing)

## Introduction

Tiny URL Training is a Java-based URL shortening service that leverages the Spring Boot framework. The service generates compact URLs for long ones, making it convenient to share links. The implementation involves the use of a Sequencer Service to obtain auto-incremented IDs.

## Sequencer Service

The [Sequencer Service](https://github.com/Mostafa-Alshaer/tiny-url-sequencer-service) is utilized to obtain auto-incremented IDs, a crucial component for creating unique and sequential tiny URLs. As MongoDB, used in the main service, lacks built-in auto-increment functionality, the Sequencer Service fills this gap by providing incrementing IDs.

## How It Works

1. **Long URL Submission:**
   - Users submit long URLs to the service.

2. **Sequencer Service Interaction:**
   - The service interacts with the [Sequencer Service](https://github.com/Mostafa-Alshaer/tiny-url-sequencer-service) to obtain an auto-incremented ID.

3. **Conversion to BASE36:**
   - The obtained ID is converted to BASE36 to create a shorter representation. This conversion allows for shorter and more user-friendly tiny URLs.

4. **Tiny URL Generation:**
   - Using the converted ID, the service creates a short, unique tiny URL for the submitted long URL.

5. **Accessing the Tiny URL:**
   - Users can now use the generated tiny URL to access the original long URL.

## Getting Started

To set up the Tiny URL Training service, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Mostafa-Alshaer/tiny-url-training.git
   ```

2. Install dependencies:
   ```bash
   cd tiny-url-training
   ./mvnw clean install
   ```

3. Configure environment variables (if needed).

4. Run the service:
   ```bash
   ./mvnw spring-boot:run
   ```

## Usage

Once the service is running, you can use it to shorten long URLs. The service exposes endpoints for URL submission and retrieval of tiny URLs.

Example API Endpoints:

- **Submit Long URL:**
  ```http
  POST /url
  ```

- **Retrieve Tiny URL:**
  ```http
  GET /url/:id
  ```
...

## Scalability

The Tiny URL Training service is built for scalability, allowing easy deployment of multiple nodes to handle increased loads. Key considerations include:

1. **Load Balancing:** Deploy behind a load balancer for even traffic distribution.

2. **Statelessness:** Designed to be stateless, enabling seamless horizontal scaling.

3. **Database Scaling:** Consider horizontal scaling for the database, especially if using MongoDB.

4. **Cloud Deployment:** Cloud environments (e.g., AWS) offer scalable solutions like Elastic Beanstalk or Kubernetes.

By adhering to these principles, the Tiny URL Training service can efficiently scale horizontally to meet varying levels of demand.

## Contributing

Contributions are welcome! If you have ideas for improvements, encounter issues, or want to add new features, please open an issue or submit a pull request.
