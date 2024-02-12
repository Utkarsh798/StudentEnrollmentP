# Student Enrollment Spring Boot Application

## Overview
This Spring Boot application manages student enrollment in courses. It provides functionalities to create, update, delete, and retrieve information about students and their enrollments in courses.
**Used Postgres SQL Database to store information and perform Query.**

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

## Course Controller

### Overview
The CourseController class handles HTTP requests related to course management in the enrollment system.

### Dependencies
- **Autowired**: Used to inject dependencies into the controller.

### Endpoints

- **GET /course/getAll**: Retrieves all courses.
- **GET /course/{courseId}**: Retrieves a specific course by ID.
- **POST /course**: Adds a new course.
- **PUT /course/{courseId}**: Updates an existing course by ID.
- **DELETE /course/{courseId}**: Deletes a course by ID.

### Request/Response Formats

- **GET /course/getAll**
    - Request: None
    - Response: List of Course objects

- **GET /course/{courseId}**
    - Request: Course ID
    - Response: Course object

- **POST /course**
    - Request: Course object
    - Response: None

- **PUT /course/{courseId}**
    - Request: Course ID, Updated Course object
    - Response: None

- **DELETE /course/{courseId}**
    - Request: Course ID
    - Response: None

### Methods

- **getAllCourse()**: Retrieves all courses.
- **getCourse(Integer courseId)*: Retrieves a specific course by ID.
- **addCourse(Course course)**: Adds a new course.
- **updateCourse(Course course, Integer courseId)**: Updates an existing course by ID.
- **deleteCourse(Integer courseId)**: Deletes a course by ID.

## Course Services

### Overview
The CourseServices class provides methods to perform CRUD (Create, Read, Update, Delete) operations on course entities in the enrollment system.

### Dependencies
- **Autowired**: Used to inject dependencies into the service.

It Includes all the methods to perform when certain Mapping is fired.

## Enroll Entity Class

### Overview
The Enroll class represents an enrollment entity in the enrollment system. It establishes a many-to-one relationship between students and courses, allowing students to enroll in multiple courses.

### Attributes
- **id**: Unique identifier for the enrollment. Auto-generated Sequence with Annotation `@GeneratedValue`.
- **student**: Student entity representing the student enrolled in the course.
- **course**: Course entity representing the course in which the student is enrolled.

As well as Getters and setter of a attributes as well as NoArgument Construcotr and Constructore with all arguments.

## Enroll Controller

### Overview
The EnrollController class handles HTTP requests related to student-course enrollments in the enrollment system.

### Dependencies
- **Autowired**: Used to inject dependencies into the controller.

## Endpoints

### Student Enrollment

- **POST /student/enroll/{studentId}/{courseId}**
  - Description: Enrolls a student in a specific course.
  - Parameters: 
    - Integer studentId: ID of the student to enroll.
    - Integer courseId: ID of the course in which the student will be enrolled.

- **DELETE /student/drop/{studentId}/{courseId}**
  - Description: Drops a course from a student's enrollment.
  - Parameters: 
    - Integer studentId: ID of the student from whom the course will be dropped.
    - Integer courseId: ID of the course to be dropped from the student's enrollment.

- **GET /student/{studentId}/courses**
  - Description: Retrieves all courses in which a specific student is enrolled.
  - Parameters: Integer studentId: ID of the student.
  - Response: List of Course objects.

### Course Enrollment

- **GET /List/students/course/{courseId}**
  - Description: Retrieves all students enrolled in a specific course.
  - Parameters: Integer courseId: ID of the course.
  - Response: List of Student objects.

- **GET /enrollIn/course/{courseId}/NoOfStudents**
  - Description: Retrieves the total number of students enrolled in a specific course.
  - Parameters: Integer courseId: ID of the course.
  - Response: Integer representing the total number of students enrolled in the course.

- **DELETE /drop/student/{studentId}/from/course/{courseId}**
  - Description: Drops a student from a specific course.
  - Parameters: 
    - Integer studentId: ID of the student to be dropped from the course.
    - Integer courseId: ID of the course from which the student will be dropped.

