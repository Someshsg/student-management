# Student Management System (Maven)

A beginner-friendly Java console application for practicing Apache Maven.

## Requirements
- JDK 17 or newer
- Apache Maven 3.6.3 or newer

## Features
- Add, list, search, and delete students
- Prevent duplicate student IDs
- Includes a JUnit 5 unit test

Student records are stored in an ArrayList and are cleared when the application exits.

## Build and test
Run these commands from the folder containing pom.xml:

```bash
mvn clean test
mvn package
```

## Run
After a successful build:

```bash
java -cp target/classes com.practice.App
```

## Useful Maven commands
```bash
mvn validate
mvn compile
mvn test
mvn package
mvn install
mvn clean
mvn clean install
```

## Structure
```text
student-management/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/practice/
    │   ├── App.java
    │   └── Student.java
    └── test/java/com/practice/
        └── StudentTest.java
```

Maven downloads dependencies and build plugins on the first build, so an internet connection may be required.
