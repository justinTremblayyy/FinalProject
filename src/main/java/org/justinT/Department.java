package org.justinT;

public class Department {

    private String departmentId;
    private String departmentName;
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


    public static boolean isDepartmentNameValid(String departmentName) {

    }


    }
