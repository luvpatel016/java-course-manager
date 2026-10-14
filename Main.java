import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        String choice = "yes";

        while (choice.equalsIgnoreCase("yes")) {

            System.out.print("\nEnter course code: ");
            String courseCode = input.nextLine();

            System.out.print("Enter course name: ");
            String courseName = input.nextLine();

            Course course = new Course(courseCode, courseName);

            courses.add(course);

            System.out.print("\nDo you want to add another course? (yes/no): ");
            choice = input.nextLine();
        }

        System.out.println("\nYour courses: ");

        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName());
        }

        int menuChoice = 0;

        while (menuChoice != 9) {
            System.out.println("\n1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Remove Course");
            System.out.println("4. Search Course");
            System.out.println("5. Edit Course");
            System.out.println("6. Add Assignments");
            System.out.println("7. View Assignments");
            System.out.println("8. Course Average");
            System.out.println("9. Exit");

            System.out.print("Choose an option: ");
            menuChoice = input.nextInt();
            input.nextLine();

            if (menuChoice == 1) {

                System.out.print("Enter course code: ");
                String courseCode = input.nextLine();

                System.out.print("Enter course name: ");
                String courseName = input.nextLine();

                boolean duplicate = false;

                for (Course currentCourse : courses) {
                    if (currentCourse.getCourseCode().equalsIgnoreCase(courseCode)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("Course already exists!");
                } else {
                    Course course = new Course(courseCode, courseName);
                    courses.add(course);

                    System.out.println("Course added!");
                }
            }

            else if (menuChoice == 2) {

                System.out.println("\nYour Courses:");

                for (Course currentCourse : courses) {
                    System.out.println(currentCourse.getCourseCode() + " - " + currentCourse.getCourseName());
                }
            }

            else if (menuChoice == 3) {

                String removeChoice = "";

                while (!removeChoice.equalsIgnoreCase("done")) {

                    System.out.println("\nCourses: ");

                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println((i + 1) + ". " + courses.get(i).getCourseCode() + " - " +
                                courses.get(i).getCourseName());
                    }

                    System.out.print("Enter course number to remove, or type 'done' to finish: ");
                    removeChoice = input.nextLine();

                    if (!removeChoice.equalsIgnoreCase("done")) {

                        int index = Integer.parseInt(removeChoice) - 1;

                        courses.remove(index);

                        System.out.println("Course removed!");
                    }
                }
            }

            else if (menuChoice == 4) {

                System.out.print("Enter course code to search: ");
                String searchCode = input.nextLine();

                boolean found = false;

                for (Course currentCourse : courses) {

                    if (currentCourse.getCourseCode().equalsIgnoreCase(searchCode)) {

                        System.out.println(currentCourse.getCourseCode() + " - " + currentCourse.getCourseName());

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Course not found.");
                }
            }

            else if (menuChoice == 5) {

                System.out.print("Enter course code to edit: ");
                String editCode = input.nextLine();

                boolean found = false;

                for (Course currentCourse : courses) {

                    if (currentCourse.getCourseCode().equalsIgnoreCase(editCode)) {

                        System.out.print("Current course name: " + currentCourse.getCourseName());
                        System.out.println(); // new line
                        System.out.print("\nEnter new course name: ");
                        String newCourseName = input.nextLine();

                        currentCourse.setCourseName(newCourseName);

                        System.out.println("Course updated!");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Course not found!");
                }
            }

            else if (menuChoice == 6) {
                System.out.print("Enter course code: ");
                String courseCode = input.nextLine();

                boolean found = false;

                for (Course currentCourse : courses) {

                    if (currentCourse.getCourseCode().equalsIgnoreCase(courseCode)) {

                        System.out.print("Enter assignment name: ");
                        String assignmentName = input.nextLine();

                        System.out.print("Enter grade: ");
                        double grade = input.nextDouble();
                        input.nextLine();

                        Assignment assignment = new Assignment(assignmentName, grade);

                        currentCourse.addAssignment(assignment);
                        System.out.println("Assignment added!");

                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Course not found!");
                }
            }

            else if (menuChoice == 7) {

                System.out.print("Enter course code: ");
                String courseCode = input.nextLine();

                boolean found = false;

                for (Course currentCourse : courses) {

                    if (currentCourse.getCourseCode().equalsIgnoreCase(courseCode)) {

                        found = true;
                        System.out.println("\nAssignments for " + currentCourse.getCourseCode() + ":");

                        if (currentCourse.getAssignments().isEmpty()) {
                            System.out.println("No assignments found!");
                        } else {

                            for (Assignment assignment : currentCourse.getAssignments()) {
                                System.out.println(assignment.getAssignmentName() + " - " + assignment.getGrade());
                            }
                        }
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Course not found!");
                }
            }

            else if (menuChoice == 8) {

                System.out.println("Enter course code: ");
                String courseCode = input.nextLine();

                boolean found = false;

                for (Course currentCourse : courses) {

                    if (currentCourse.getCourseCode().equalsIgnoreCase(courseCode)) {

                        found = true;

                        if (currentCourse.getAssignments().isEmpty()) {
                            System.out.println("No assignments found");
                        } else {

                            double total = 0;

                            for (Assignment assignment : currentCourse.getAssignments()) {
                                total += assignment.getGrade();
                            }

                            double average = total / currentCourse.getAssignments().size();

                            System.out.println("Course average: " + average);
                        }

                        break;
                    }
                }
                if (!found) {
                    System.out.println("Course not found!");
                }
            }

            else if (menuChoice == 9) {
                System.out.println("Exiting program. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again!");
            }
        }
        input.close();
    }
}