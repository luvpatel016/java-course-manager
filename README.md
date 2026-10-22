# Java Course Manager

A console-based Java application for managing college courses, assignments, and grades.

## Features

- Add courses
- View all courses
- Prevent duplicate course codes
- Search for courses by course code
- Edit course names
- Remove courses
- Add assignments to specific courses
- View assignments for a course
- Store assignment grades
- Calculate course averages
- Exit through the menu

## Language Used

- Java

## Project Structure

### Main.java
Handles:
- User input
- Main menu
- Course management
- Assignment management
- Course average calculations

### Course.java
Represents a course and stores:
- Course code
- Course name
- List of assignments

### Assignment.java
Represents an assignment and stores:
- Assignment name
- Grade

## How to Run

Compile the Java files:

```bash
javac Main.java Course.java Assignment.java
```
Then do: 

```bash
java Main
```
