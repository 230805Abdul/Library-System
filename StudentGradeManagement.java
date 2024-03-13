import java.util.ArrayList;

class Student {
    private String name;
    private int rollNumber;
    private ArrayList<Double> grades;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    // Method to add a grade
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // Method to calculate average grade
    public double calculateAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverageGrade());
    }
}

public class StudentGradeManagement {
    public static void main(String[] args) {
        // Create student objects
        Student student1 = new Student("Hafiz", 1);
        Student student2 = new Student("Abdul basit", 2);

        // Add grades for each student
        student1.addGrade(85);
        student1.addGrade(90);
        student1.addGrade(78);

        student2.addGrade(92);
        student2.addGrade(88);
        student2.addGrade(95);

        // Display student details
        System.out.println("Student 1 Details:");
        student1.displayStudentInfo();

        System.out.println();

        System.out.println("Student 2 Details:");
        student2.displayStudentInfo();
    }
}
