package org.justinT;

import lombok.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter

public class Department {

    private String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;


    /**
    * Constructor with departmentName
     * @param departmentName If departmentName is valid, all fields will be set to null.
     */
    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
            this.departmentId = String.format("D%02d", nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    /**
     * checks if department name is valid or not
     * @param departmentName name to be verified
     * @return true if valid, false if not
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            return false;
            }

        for (int i = 0; i < departmentName.length(); i++) {
            char ch = departmentName.charAt(i);
                if (!Character.isLetter(ch) && ch != ' ') {
                    return false;
                }
        }

            return true;
    }
}