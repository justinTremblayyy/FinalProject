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

    /**
     * calculates the average score for the assignment
     * @return the average score
     */
    public double calcAssignmentAvg(){
        if ( scores.isEmpty() || scores == null) {
            return 0;
        }
        int sum = 0;
        for (Integer score : scores) {
            if (score != null) {
                sum += score;
            }
        }
        return (double) sum / scores.size();
    }

    /**
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        if (scores == null) return;

        Random random = new Random();


    }

    @Override
    public String toString() {

    }

}
