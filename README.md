# Student Enrollment Spring Boot Application

## Overview
This Spring Boot application manages student enrollment in courses. It provides functionalities to create, update, delete, and retrieve information about students and their enrollments in courses.

## Student Model

### Student Entity Class

The Student class represents a student entity in the enrollment system. It contains information such as the student's name, email, date of birth, and major.

### Attributes
- **id**: Unique identifier for the student. Auto-generated Sequence with Annotation `@GeneratedValue`.
- **name**: Name of the student.
- **email**: Email address of the student.
- **dob**: Date of birth of the student.
- **major**: Major or field of study of the student.

As well as Getters and setter of a attributes as well as NoArgument Construcotr and Constructore with all arguments.


## Student Controller

The StudentController class handles HTTP requests related to student management in the enrollment system.

### Endpoints

- **GET /student/getAll**: Retrieves all students.
- **GET /student/{id}**: Retrieves a specific student by ID.
- **POST /student**: Adds a new student.
- **PUT /student/{id}**: Updates an existing student by ID.
- **DELETE /student/{id}**: Deletes a student by ID.

### Request/Response Formats

- **GET /student/getAll**
    - Request: None
    - Response: List of Student objects

- **GET /student/{id}**
    - Request: Student ID
    - Response: Student object

- **POST /student**
    - Request: Student object
    - Response: None

- **PUT /student/{id}**
    - Request: Student ID, Updated Student object
    - Response: None

- **DELETE /student/{id}**
    - Request: Student ID
    - Response: None

### Dependencies
- **Autowired**: Used to inject StudentServices dependency into the controller.

### Methods
- **getAllStudents()**: give me all the Students information.
- **getStudent(Integer id)**: Retrieves a specific student by ID.
- **addStudent(Student student)**: Adds a new student.
- **updateStudent(Student student, Integer id)**: Updates an existing student by ID.
- **delete(Integer id)**: Deletes a student by ID.

## Student Services

### Overview
The StudentServices class provides methods to perform CRUD (Create, Read, Update, Delete) operations on student entities in the enrollment system.

### Dependencies
- **Autowired**: Used to inject the StudentRepository dependency into the service.
  
It Includes all the methods to perform when certain Mapping is fired.




## Course Model

### Course Entity Class

## Overview
The Course class represents a course entity in the enrollment system. It contains information such as the course's name, semester, and description.

## Attributes
- **id**: Unique identifier for the course. Auto-generated Sequence with Annotation `@GeneratedValue`.
- **course_name**: Name of the course.
- **course_semester**: Semester in which the course is offered.
- **description**: Description of the course.

As well as Getters and setter of a attributes as well as NoArgument Construcotr and Constructore with all arguments.




