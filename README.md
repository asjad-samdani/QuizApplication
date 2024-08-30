# Quiz Application

This project is a comprehensive quiz application built using Spring Boot and a microservices architecture. The application allows users to take quizzes on various topics, including Java, HTML, CSS, JavaScript, and more.

## Features

- **Microservices Architecture**: Designed with a microservices approach, ensuring modularity and scalability. Each service handles a specific aspect of the application, such as question management, user management, and quiz administration.
- **CRUD Operations**: Implemented Create, Read, Update, and Delete (CRUD) operations for managing quiz questions, users, and categories.
- **Question Management**: Services to add, update, delete, and retrieve quiz questions based on different categories and difficulty levels.
- **User Management**: Includes functionality for user registration, authentication, and role-based access control.
- **Scalability**: Designed to easily scale services independently to handle increased load and ensure high availability.
- **Security**: Implemented security measures to protect sensitive data and ensure secure access to the application.

## Technologies Used

- **Spring Boot**: For building the microservices and managing application configurations.
- **Hibernate**: For Object-Relational Mapping (ORM) to manage database interactions.
- **JPA**: For creating repositories and performing CRUD operations.
- **Microservices**: Architectural style used to develop independent services that communicate over HTTP or messaging queues.

## Architecture

- **Service Layers**: Each microservice encapsulates a specific domain functionality and communicates with other services as needed.
- **Database**: Managed through Hibernate and JPA with repositories for data persistence.
- **Security**: Manual security configurations ensure that access control is enforced and sensitive operations are protected.

## Getting Started

### Prerequisites

- Java 11 or later
- Maven
- MySQL (or another preferred database)

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/yourusername/quiz-application.git
   ```

2. Navigate to the project directory:

```sh
  git clone https://github.com/yourusername/quiz-application.git
```

### 3. Configure the database connection in application.properties or application.yml.

4.Build the project:

```sh
  mvn clean install
```

5.Run the application:

```sh
mvn spring-boot:run
```

### API Endpoints

I.Retrieve all quiz questions.

```sh
GET localhost:9090/question/allQuestions
```

II.Retrieve questions by category. Replace {category} with the desired category name.

```sh
GET /question/category/{category}
```

III. Add new quiz questions. The request body should contain a list of questions in JSON format.

```sh
POST /question/addQuestions
```

IV.Update a specific question. Replace {id} with the ID of the question to be updated. The request body should contain the updated question details.

```sh
PUT /question/update/{id}
```

V. Delete a specific question. Replace {id} with the ID of the question to be deleted.

```sh
DELETE /question/delete/{id}
```
