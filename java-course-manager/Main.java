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

        input.close();
    }
}