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

    public void displayScores(){

    }

    public String toSimplifiedString(){

    }

    public String toString(){

    }



}
