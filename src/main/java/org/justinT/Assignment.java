package org.justinT;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.assignmentId = "A" + String.format("%03d", nextId++);
    }

    public double calcAssignmentAvg(){

    }

    public void generateRandomScore() {

    }

    @Override
    public String toString() {

    }

}
