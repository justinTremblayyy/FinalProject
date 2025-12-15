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

    public Course(){

    }

    public boolean isAssignmentWeightValid() {

    }

    public boolean registerStudent(Student student){

    }

    public int[] calcStudentsAverage(){

    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {

    }

    public void generateScores(){

    }

    public void displayScores(){

    }

    public String toSimplifiedString(){

    }

    public String toString(){

    }



}
