import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        String choice = "yes";

        while (choice.equalsIgnoreCase("yes")) {

            System.out.print("Enter course code: ");
            String courseCode = input.nextLine();

            System.out.print("Enter course name: ");
            String courseName = input.nextLine();

            Course course = new Course(courseCode, courseName);

            courses.add(course);

            System.out.print("Do you want to add another course? (yes/no): ");
            choice = input.nextLine();
        }

        System.out.println("\nYour courses: ");

        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName());
        }

        int menuChoice = 0;

        while (menuChoice != 5) {
            System.out.println("\n1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Remove Course");
            System.out.println("4. Search Course");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            menuChoice = input.nextInt();
            input.nextLine();

            if (menuChoice == 1) {

                System.out.print("Enter course code: ");
                String courseCode = input.nextLine();

                System.out.print("Enter course name: ");
                String courseName = input.nextLine();

                Course course = new Course(courseCode, courseName);
                courses.add(course);

                System.out.println("Course added!");
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

                for (Course currentCourse : courses) { 

                    if (currentCourse.getCourseCode().equalsIgnoreCase(searchCode)) { 

                        System.out.println(currentCourse.getCourseCode() + " - " + currentCourse.getCourseName()); 
                    }
                }
            }

            else if (menuChoice == 5) { 
                System.out.println("Exiting program. Goodbye!"); 
            } else if (menuChoice < 1 || menuChoice > 5) { 
                System.out.println("Invalid choice. Please try again."); 
            }

            input.close();
        }
    }
}