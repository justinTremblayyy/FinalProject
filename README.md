# FinalProject

## Project description
#### By Justin Tremblay 2582154

This final project of Introduction to Programming is a java program made to operate basic tasks for schools. It is a system that teachers and administration workers can use to create students, assign them to departments, register them for courses, add assignments to courses, and generates student and average scores.

### 1. Address

- Represents a geographic address with fields as street number, street name, city, province and postal code.
- It validates if the postal code given respects the Canadian postal code format (A1B2C3).
- The constructor makes sure that only valid postal codes are accepted, fields are set to null if it is not.
- ex: K2P1L4

### 2. Department

- Represents a department with an Id and a Name.
- It Validates if department names contain only letters and spaces.
- ex: Electrical Engineering

### 3. Student

- Represents a student with an Id, name, gender, address, department, and registered courses.
- It validates if a student successfully registers or drop a course
- ex: Bob

### 4. Assignment

- Represents an assignment with an Id, name, weight, scores and average scores.
- It provides methods to calculate average scores and generate random scores.
- ex: Midterm project

### 5. Course

- Represents a course with an ID, name, credits, department, assignments, and registered students.
- Includes methods to add assignments, register students, validate assignment weights, generate scores, and display results in a table.
- ex: Introduction to programming
6. Util
7. UnitTesting