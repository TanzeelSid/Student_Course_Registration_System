# Student Course Registration System

A comprehensive Java-based Student Course Registration System that demonstrates the four pillars of Object-Oriented Programming: **Encapsulation**, **Inheritance**, **Polymorphism**, and **Abstraction**.

## Project Structure

```
Assignment_1/
├── src/
│   ├── Main.java
│   └── com/
│       └── registration/
│           ├── model/
│           │   ├── Person.java
│           │   ├── Student.java
│           │   ├── Instructor.java
│           │   └── Course.java
│           └── system/
│               └── RegistrationSystem.java
└── README.md
```

## Classes Overview

### 1. Person (Abstract Base Class)
- **Location**: `com.registration.model.Person`
- **Purpose**: Abstract base class for all people in the system
- **Key Features**:
  - Private fields: `name`, `email`, `id`
  - Input validation in setters (email format, non-empty values)
  - Abstract method `displayDetails()` for polymorphism

### 2. Student (Inherits from Person)
- **Location**: `com.registration.model.Student`
- **Purpose**: Represents students in the registration system
- **Key Features**:
  - Private list of enrolled courses
  - Methods: `enrollInCourse()`, `dropCourse()`
  - Overridden `displayDetails()` method

### 3. Instructor (Inherits from Person)
- **Location**: `com.registration.model.Instructor`
- **Purpose**: Represents instructors in the registration system
- **Key Features**:
  - Private list of assigned courses
  - Method: `assignCourse()`
  - Overridden `displayDetails()` method

### 4. Course
- **Location**: `com.registration.model.Course`
- **Purpose**: Represents courses in the system
- **Key Features**:
  - Private fields: `courseCode`, `courseName`, `maxStudents`
  - Student enrollment management
  - Input validation (course code format, capacity limits)
  - Methods: `registerStudent()`, `removeStudent()`, `displayCourseInfo()`

### 5. RegistrationSystem
- **Location**: `com.registration.system.RegistrationSystem`
- **Purpose**: Orchestrates the entire registration process
- **Key Features**:
  - Private lists of students, instructors, and courses
  - High-level abstracted operations
  - Methods: `registerStudentToCourse()`, `assignInstructorToCourse()`

## OOP Concepts Demonstrated

### 1. Encapsulation
- **Private fields** in all classes with controlled access through getters/setters
- **Input validation** in setters (email format, course code format, non-empty values)
- **Data protection** by returning copies of internal lists
- **Example**: Email validation in Person class, course capacity checking in Course class

### 2. Inheritance
- **Student** and **Instructor** classes extend the **Person** base class
- **Code reuse** through inherited fields and methods
- **Specialized behavior** in subclasses while maintaining common structure
- **Example**: Both Student and Instructor inherit name, email, id from Person

### 3. Polymorphism
- **Method overriding**: `displayDetails()` method implemented differently in Student and Instructor
- **Runtime polymorphism**: Same method call produces different behavior based on object type
- **Example**: Person array containing Student and Instructor objects, calling displayDetails()

### 4. Abstraction
- **Abstract Person class** with abstract `displayDetails()` method
- **RegistrationSystem** provides high-level operations hiding internal complexity
- **Interface simplification**: Complex operations exposed through simple method calls
- **Example**: `registerStudentToCourse(studentId, courseCode)` hides internal lookup and validation logic

## How to Run

1. **Compile the project**:
   ```bash
   javac -d . src/Main.java src/com/registration/model/*.java src/com/registration/system/*.java
   ```

2. **Run the main class**:
   ```bash
   java Main
   ```

## Sample Output

The program demonstrates:
- Creating students, instructors, and courses
- Student enrollment and course dropping
- Instructor assignments
- Polymorphic method calls
- Input validation and error handling
- Complete system state display

## Key Features

### Input Validation
- Email format validation using regex patterns
- Course code format validation (e.g., CS101, MATH200)
- Non-empty field validation
- Course capacity enforcement

### Error Handling
- Comprehensive exception handling for invalid inputs
- Graceful handling of duplicate registrations
- Clear error messages for debugging

### Design Patterns
- **Encapsulation**: Private fields with controlled access
- **Composition**: Course contains list of Students
- **Aggregation**: Student has list of Courses
- **Factory-like pattern**: RegistrationSystem manages object creation and relationships

## Educational Value

This project serves as an excellent example for learning:
- Object-oriented design principles
- Java programming best practices
- Input validation and error handling
- Code organization and package structure
- Documentation and code readability

## Future Enhancements

- Database integration for persistent storage
- GUI interface using JavaFX or Swing
- Advanced search and filtering capabilities
- Grade management system
- Course prerequisites handling
- Waitlist functionality for full courses