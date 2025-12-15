import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.justinT.*;
import util.Util;


public class UnitTesting {

// Address Class
    @Test
    @DisplayName(
            "Valid postal code: K2P1L4")
    void testValidPostalCode() {
        String postalCode = "K2P1L4";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid postal code: AB12CD")
    void testInvalidPostalCode() {
        String postalCode = "AB12CD";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);

    }

// Department Class
    @Test
    @DisplayName("Valid department name: Electrical Engineering")
    void testValidDepartmentName() {
        String name = "Electrical Engineering";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(name);

        Assertions.assertEquals(expected, actual);
    }

        @Test
        @DisplayName("Invalid department name: BioChem_101")
        void testInvalidDepartmentName() {
            String name = "BioChem_101";
            boolean expected = false;
            boolean actual = Department.isDepartmentNameValid(name);

            Assertions.assertEquals(expected, actual);
    }

// Assignment Class
    @Test
    @DisplayName("Average calculation on assignment")
    void testAssignmentAverage() {
        Assignment assignment = new Assignment("Lab Work", 40);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(70);
        scores.add(95);
        assignment.setScores(scores);

        double expected = 82.5;
        double actual = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, actual);
    }

// Course Class
    @Test
    @DisplayName("Weights sum to 90")
    void testWeightsSum() {
        Department d = new Department("Electrical Engineering");
        Course c = new Course("Circuits", 3.0, d);

        c.addAssignment("Labs", 30, 100);
        c.addAssignment("Midterm", 20, 100);
        c.addAssignment("Final", 40, 100); // total = 90

        boolean expected = false;
        boolean actual = c.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Register student twice")
    void testStudentRegister() {
        Department d = new Department("Physics");
        Course c = new Course("Thermodynamics", 3.0, d);

        Address a = new Address(221, "Bob", "Ottawa",
                Address.Province.ON, "K1A0B1");

        Student s = new Student("Ben", Student.Gender.MALE, a, d);

        boolean first = c.registerStudent(s);
        boolean second = c.registerStudent(s);

        Assertions.assertTrue(first);
        Assertions.assertFalse(second);
    }

// Unit Class
    @Test
    @DisplayName("Convert string to Title Case")
    void testToTitleCase() {
        String input = "pure AND applied science";
        String expected = "Pure And Applied Science";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }
}
