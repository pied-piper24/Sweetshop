# Sweet Shop Management System

A full-stack web application for managing a sweet shop's inventory, orders, and customer interactions. The system features a Spring Boot backend for robust business logic handling and a React frontend for an intuitive user interface.

## Project Structure

```
sweetshop/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/
│   │   │           └── sweetshop/
│   │   │               ├── Cart.java
│   │   │               ├── Menu.java
│   │   │               ├── MenuItem.java
│   │   │               └── Order.java
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── sweetshop/
│   │                   ├── CartTest.java
│   │                   ├── MenuTest.java
│   │                   └── OrderTest.java
│   └── pom.xml
└── frontend/
    └── sweetshop-ui/
```

## Features

- **Menu Management**: View and manage the sweet shop's menu items
- **Shopping Cart**: Add/remove items and track total cost
- **Order Processing**: Create and manage customer orders
- **Category Management**: Organize items by categories (Sweet/Savory)

## Technology Stack

### Backend
- Java 21
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- JUnit 5 for testing

### Frontend
- React
- Material UI
- Axios for API calls

## Setup Instructions

### Backend Setup

1. Ensure you have Java 21 installed:
   ```bash
   java --version
   ```

2. Clone the repository:
   ```bash
   git clone <repository-url>
   cd sweetshop
   ```

3. Build and run the backend:
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```

The backend will start on `http://localhost:8080`

### Frontend Setup

1. Ensure you have Node.js installed

2. Install dependencies and start the frontend:
   ```bash
   cd frontend/sweetshop-ui
   npm install
   npm start
   ```

The frontend will be available on `http://localhost:3000`

## Testing

Run the test suite with:
```bash
mvn test
```

## Screenshots

[Screenshots will be added here]

## My AI Usage

### Tools Used

1. **GitHub Copilot**
   - Used for generating boilerplate code in Cart.java and Order.java
   - Helped write unit test cases for basic CRUD operations
   - Suggested code completions during model class implementation

2. **ChatGPT**
   - Used for brainstorming API endpoint structures
   - Helped debug Spring Boot configuration issues
   - Used for generating test cases with edge cases
   - Assisted in writing documentation

### Impact on Workflow

AI tools significantly improved my development workflow in several ways:

1. **Productivity Enhancement**
   - Reduced time spent on boilerplate code writing
   - Quick generation of comprehensive test cases
   - Faster debugging through pattern recognition

2. **Code Quality**
   - AI suggestions helped maintain consistent coding patterns
   - Generated test cases covered edge cases I might have missed
   - Helped ensure comprehensive error handling

3. **Learning and Best Practices**
   - AI tools suggested modern Spring Boot patterns and practices
   - Helped understand better ways to structure the codebase
   - Provided insights into testing strategies

### Implementation Details

For each major feature, I documented my AI usage in commit messages. For example:

```git
commit: "feat: Implement shopping cart functionality

Added Cart class with add, remove, and clear operations.
Generated unit tests for edge cases.

Co-authored-by: GitHub Copilot <copilot@users.noreply.github.com>"
```

### Reflection

Using AI tools has been instrumental in maintaining high code quality while meeting deadlines. The tools were particularly helpful in:

1. **Initial Setup**: Quickly bootstrapping the project structure
2. **Testing**: Ensuring comprehensive test coverage
3. **Documentation**: Maintaining clear and consistent documentation
4. **Problem Solving**: Getting unstuck during complex implementation challenges

However, I made sure to:
- Review and understand all AI-generated code
- Modify suggestions to match our specific requirements
- Add proper documentation and comments
- Never blindly accept AI suggestions without validation

## Contribution Guidelines

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for your changes
5. Ensure all tests pass
6. Submit a pull request

## License

MIT License