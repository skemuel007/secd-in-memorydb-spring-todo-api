# Spring Boot Todo API
A simple and robust RESTful API for managing a "Todo" list, 
built with Java and the Spring Boot framework. This project provides 
complete CRUD (Create, Read, Update, Delete) functionality for todo items using a
H2 Database (In-Memory)

This guide provides setup and usage instructions for developers using either IntelliJ IDEA or Visual Studio Code.

## Features
- Create a new todo item. 
- Retrieve a list of all todo items. 
- Retrieve a single todo item by its ID. 
- Update an existing todo item's title or completion status. 
- Delete a todo item by its ID.

## Technology Stack
- Java 17 
- Spring Boot 3.x 
- Spring Web: For building RESTful APIs. 
- Spring Data JPA: For database persistence. 
- H2 Database: An in-memory database for simple development and testing. 
- Maven: For project build and dependency management. 
- Lombok: To reduce boilerplate code (getters, setters, constructors).

## Prerequisites
Before you begin, ensure you have the following installed on your system:
- Java Development Kit (JDK) 17 or later.
- Apache Maven.
- Git for cloning the repository.
- An IDE of your choice: IntelliJ IDEA or Visual Studio Code.
- An API client like Postman or curl for testing the endpoints.

## Project Setup on Local Machine
1.Clone the Repository
   
First, clone the project repository to your local machine.
```bash
 git clone <your-repository-url>
 cd todo-api
```
2. IDE Setup
   
Follow the instructions specific to your IDE to ensure the project is configured correctly, especially for Lombok.

### For IntelliJ IDEA
1. Open the Project:
    - Launch IntelliJ IDEA. 
    - Select File -> Open... and navigate to the cloned todo-api directory. 
    - Select the pom.xml file and open it as a project. IntelliJ will automatically detect it's a Maven project and sync the dependencies.
2. Install Lombok Plugin (Crucial Step):
   - Go to File -> Settings (or IntelliJ IDEA -> Preferences on macOS).
   - Navigate to the Plugins section.
   - Search for "Lombok" in the Marketplace and click Install.
   - Restart the IDE when prompted.
3. Enable Annotation Processing:
   - After restarting, go back to Settings/Preferences.
   - Navigate to Build, Execution, Deployment -> Compiler -> Annotation Processors.
   - Check the box for "Enable annotation processing".
   - Click Apply and OK.
   
### For Visual Studio Code
1. Open the Project:
   - Launch VS Code.
   - Select File -> Open Folder... and choose the cloned todo-api directory.
   
2. Install Recommended Extensions (Important Step):
   - VS Code will likely prompt you to install recommended extensions for Java. If not, go to the Extensions view (Ctrl+Shift+X).
   - Install the "Extension Pack for Java" from Microsoft. This provides core Java language support.
   - Install the "Lombok Annotations Support for Java" extension.
   - Reload the VS Code window when prompted to activate the extensions.

## Running the Application
You can run the application either directly from your IDE or via the command line.

### From Your IDE
- **IntelliJ IDEA:** Open the TodoApiApplication.java file. You will see a green play button next to the main method. Click it and select Run 'TodoApiApplication'.
- **VS Code:** Open the TodoApiApplication.java file. Click the Run link that appears above the main method.
### From the Command Line (CLI)
Navigate to the root directory of the project in your terminal and use the Maven wrapper to run the application.

- On macOS / Linux:
```bash
./mvnw spring-boot:run
```
- On Windows:
```bash
mvnw.cmd spring-boot:run
```

The application will start on *http://localhost:8080.*

## API Endpoints
The base URL for all endpoints is /api/v1/todos.

| Method | Endpoint | Description                   | Request Body (Example)                            | Success Response (Example)                               |
|--------|----------|-------------------------------|---------------------------------------------------|----------------------------------------------------------|
| GET    | /        | Get all todo items.           | (None)                                            | [{"id":1,"title":"Learn Spring Boot","completed":false}] |
| GET    | /{id}    | Get a single todo by its ID.  | (None)                                            | {"id":1,"title":"Learn Spring Boot","completed":false}   |
| POST   | /        | Create a new todo item.       | {"title": "Deploy to AWS"}                        | {"id":2,"title":"Deploy to AWS","completed":false}       |    
| PUT    | /{id}    | Update an existing todo.      | {"title": "Deploy to AWS EC2", "completed": true} | {"id":2,"title":"Deploy to AWS EC2","completed":true}    |
| DELETE | /{id}    | Delete a todo item by its ID. | (None)                                            | 204 No Content                                           |

## Building for Production
To package the application into an executable JAR file for deployment, run the following command from the project root:

- On macOS / Linux:
```shell
./mvnw clean package
```
- On Windows:
```shell
mvnw.cmd clean package
```

The command will create a JAR file in the target/ directory, named something like todo-api-0.0.1-SNAPSHOT.jar.

## Deployment

This application is ready to be deployed. A simple deployment can be achieved by:
- Launching a virtual machine (e.g., an AWS EC2 instance). 
- Installing Java 17 on the machine. 
- Ensuring port 8080 is open in the firewall/security group. 
- Copying the packaged .jar file to the machine. 
- Running the application with java -jar todo-api-0.0.1-SNAPSHOT.jar.