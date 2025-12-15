package org.justinT;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;

    /**
     * constructor
     */
    public Course(String courseName, double credits, Department department){
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();

        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
    }

    /**
     * checks if the sum of all assignment weights equals 100
     * @return true if total assignment weight is 100%, false if not
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment ass : assignments) {
            sum += ass.getWeight();
        }
        return Math.abs(sum - 100.0) < 0.0001;
    }

    /**
     * adds a student to the student list of the course
     * also add a new null element to each assignment
     * @param student the student to be registered
     * @return true if the student is successfully registered, false if the student is already registered
     */
    public boolean registerStudent(Student student){
        if (student == null || registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);

        for (Assignment ass : assignments) {
            ass.getScores().add(null);
        }

        return true;
    }

    /**
     * Calculates the weighted final average score for each student.
     * @return final weighted scores
     */
    public int[] calcStudentsAverage(){
        int[] finalScores = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;

                for (Assignment ass : assignments) {
                    Integer score = ass.getScores().get(i);
                    if (score != null) {
                        total += score * ass.getWeight() / 100.0;
                    }
                }
            finalScores[i] = (int) Math.round(total);
        }
        return finalScores;
    }

    /**
     * Adds a new assignment to the course.
     * @return true if the assignment is added successfully, false if not
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment ass = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            ass.getScores().add(null);
        }

        assignments.add(ass);
        return true;
    }

    /**
     * Generates random scores for each assignment and student.
     */
    public void generateScores(){
            for (Assignment ass : assignments) {
                ass.generateRandomScore();
            }
    }

    /**
     * displays the scores of a course in a table
     * displays with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");

        System.out.print(String.format("%-20s", ""));
        for (Assignment ass : assignments) {
            System.out.print(String.format("%-15s", ass.getAssignmentName()));
        }
        System.out.println("Final");

        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student stud = registeredStudents.get(i);

            System.out.print(String.format("%-20s", stud.getStudentName()));

            for (Assignment ass : assignments) {
                Integer score = ass.getScores().get(i);
                if (score == null) {
                    System.out.print(String.format("%-15s", "-"));
                } else {
                    System.out.print(String.format("%-15d", score));
                }
            }

            System.out.println(finalScores[i]);

        }
        System.out.print(String.format("%-20s", "Average"));
        for (Assignment ass : assignments) {
            System.out.print(String.format("%-15.0f", ass.calcAssignmentAvg()));
        }
        System.out.println();
    }

    /**
     * converts a course to a simple string
     * with only the courseId, courseName, credits, and departmentName
     * @return a simplified string representation of the course
     */
    public String toSimplifiedString(){
        return courseId + " - " + courseName + " - " + credits + " - " + (department != null ? department.getDepartmentName() : " * unavailable * ");

    }

    /**
     * converts a course to a string that contains everything we need
     * @return string representation of the course
     */
    @Override
    public String toString(){
        String result = "   Course;\n" +
                "courseId: " + courseId + "\n" +
                "courseName: " + courseName + "\n" +
                "credits: " + credits + "\n" +
                "department: " + (department != null ? department.getDepartmentName() : "unavailable") + "\n";

        result += "Assignments:\n";
        if (assignments.isEmpty()) {
            result += "none\n";
        } else {
            for (Assignment ass : assignments) {
                result += ass.getAssignmentId() + " - " +
                        ass.getAssignmentName() + " (" +
                        ass.getWeight() + "%)\n";
            }
        }
        result += "Registered Students:\n";
        if (registeredStudents.isEmpty()) {
            result += "none\n";
        } else {
            for (Student stud : registeredStudents) {
                result += stud.getStudentId() + " - " +
                        stud.getStudentName() + " - " +
                        (stud.getDepartment() != null
                                ? stud.getDepartment().getDepartmentName()
                                : "unavailable") + "\n";
            }
        }
        result += "Assignment weight valid: " + isAssignmentWeightValid();

        return result;
    }
}
