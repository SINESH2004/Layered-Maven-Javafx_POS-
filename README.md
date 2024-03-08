**JavaFX Application with Layered Architecture**

This repository contains a JavaFX application that follows a layered architecture pattern, incorporating various design patterns and best practices for robust and maintainable code. The application is built using a modular structure with distinct layers such as Business Objects (BO), Data Access Objects (DAO), and a user interface (UI) controller.

Architecture Overview:
1. Layered Architecture:
The application is structured based on a layered architecture, promoting a clear separation of concerns. This design allows for easy maintenance, scalability, and code reusability.

2. Design Patterns:
Several design patterns have been applied to enhance the code quality and maintainability:

Singleton Pattern:
**Utilized for the DBConnection class, ensuring a single instance of the database connection throughout the application.**

Factory Pattern:
**Implemented in the BoFactory and DaoFactory classes to provide a centralized and flexible way of creating Business Objects (BO) and Data Access Objects (DAO) instances.**

Project Components:

1. Database Connection (DBConnection):
The DBConnection class establishes a connection to a MySQL database using JDBC. It follows the singleton pattern to ensure efficient resource usage and consistency.

2. Data Access Objects (DAO):
The DaoFactory class provides a factory method to obtain instances of various DAOs, such as CustomerDaoImpl and ProductsDaoImpl. This layer is responsible for interacting with the database and handling CRUD (Create, Read, Update, Delete) operations.

3. Business Objects (BO):
The BoFactory class similarly provides a factory method to obtain instances of BOs, such as CustomerBoImpl and ProductBoImpl. This layer contains the business logic and acts as an intermediary between the UI and the DAO layer.

![Dashboard](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/b629ae97-758e-42e7-8eb4-1f2a00734681)
![Invoice Page](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/e1e1e981-685d-455d-af00-737430c278ac)
![Invoice Page - 2](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/5a55496d-603f-4ed2-b392-9c5fea8f54b4)
![Reports View](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/41fee90a-34b2-41dc-9997-3169c603ef06)
![Products Report](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/d0aedff3-5995-47a7-9405-f9e8f7906a38)
![Add Customers](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/8b4bc5c3-1438-476c-a7d0-1c7c029c5269)
![Add Products](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/5a1c6c87-a184-4836-a8c0-51c7c94c99d6)
![File Structure](https://github.com/SINESH2004/Layered-JavaFx-POS/assets/138645911/7a1b64f1-ef8d-4274-b44a-8c0ea53493eb)

