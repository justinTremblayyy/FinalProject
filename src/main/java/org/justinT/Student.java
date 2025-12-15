package org.justinT;

import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@EqualsAndHashCode
@Getter
@Setter

public class Student {

    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = String.format("S%06d", nextId++);
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * registers a course
     * adds the course to the student's registeredCourses list
     * adds the student` to the course's registeredStudents list
     * appends a null for the scores of each assignment of the course
     * If the course is already registered, directly returns false without adding anything
     * @param course is the course to register
     * @return true if it is now registered, false if already registered
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course) || course == null) {
            return false;
        }

        if (course.registerStudent(this)) {
            registeredCourses.add(course);
            return true;
        }
       return false;

    }

    /**
     * drops a course
     * removes the course from the student's registeredCourses list
     * removes the student from the course's registeredStudents list
     * @param course is the course to drop
     * @return true if it is now dropped, false if not registered
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        int indx = course.getRegisteredStudents().indexOf(this);
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        for (Assignment assignment : course.getAssignments()) {
            if (indx >= 0 && indx < assignment.getScores().size()) {
                assignment.getScores().remove(indx);
            }
        }

        return true;
    }

    /**
     * converts a student to a simple string with only the studentId, the studentName, and departmentName
     * @return the simplified String
     */
    public String toSimplifiedString() {
        if (department == null) {
            return studentId + " - " + studentName + "unavailable";
        }
        return studentId + " - " + studentName + " - " + department.getDepartmentName();

    }


    @Override
    public String toString() {
        return  "Student; \n " +
                "studentId: " + studentId + "\n" +
                "studentName: " + studentName + "\n" +
                "department: " + (department != null ? department : "unavailable") + "\n" +
                "gender: " + gender + "\n" +
                "address: " + address + "\n" +
                "registeredCourses: " + registeredCourses.size();
    }
}
