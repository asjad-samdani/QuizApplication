# QuizApplication

Programming QuizApplication using SpringBoot, Microsevices
Quiz Application

## This project is a comprehensive quiz application built using Spring Boot and microservices architecture. The application allows users to interact with a wide range of quizzes and questions, providing a robust platform for testing knowledge across various subjects.

### Features:

Microservices Architecture: The application is designed with a microservices architecture to ensure scalability and maintainability. Key services include user management, quiz management, and question management, each handled by separate microservices.
Question Management: Users can add, update, and delete quiz questions. Questions are categorized by difficulty level and subject.
Quiz Management: Quizzes are composed of multiple questions. Users can attempt quizzes and receive scores based on their performance.
User Management: Provides functionality for user registration, login, and role-based access control. Administrators have the capability to access and manage all data, including adding new quizzes and questions.
Security: Implemented manual security to restrict access based on user roles. Administrators have elevated permissions for managing quiz content and user data.
Data Storage: Utilizes Hibernate for ORM and JPA for CRUD repository operations to manage data persistence efficiently.
API Endpoints: Exposes RESTful APIs for interacting with the quiz application, including endpoints for managing quizzes, questions, and user data.

### Technologies Used:

Spring Boot: For creating and managing microservices.
Hibernate: For ORM to handle database interactions.
JPA: For defining repository interfaces and performing CRUD operations.
Microservices: For modular and scalable architecture.
Manual Security: For role-based access control and data management.

## Use Cases:

For Students: Attempt quizzes, view scores, and track progress.
For Administrators: Manage quiz content, user data, and overall application settings.
This application provides a flexible and scalable solution for creating and managing quizzes, leveraging microservices to handle various aspects of the system efficiently.
