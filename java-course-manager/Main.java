import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) { 

        Scanner input = new Scanner(System.in); 

        ArrayList<Course> courses = new ArrayList<>();

        System.out.print("Enter course code: "); 
        String courseCode = input.nextLine(); 

        System.out.print("Enter course name: "); 
        String courseName = input.nextLine(); 

        Course course = new Course(courseCode, courseName); 

        System.out.println(course.getCourseCode()); 
        System.out.println(course.getCourseName()); 

        courses.add(course); 

        input.close(); 
    }
}