import java.util.ArrayList;

public class Assigment { 

    private String assignmentName; 
    private double grade; 
    private ArrayList<Assignment> assignments;

    public Assignment(String assignmentName, double grade) { 
        this.assignmentName = assignmentName; 
        this.grade = grade; 
        assignments = new ArrayList<>();
    }

        public String getAssignmentName() { 
            return assignmentName; 
        }

        public double getGrade() { 
            return grade; 
        }

        public void setCourseName(String courseName) { 
            this.courseName = courseName; 
        }
}