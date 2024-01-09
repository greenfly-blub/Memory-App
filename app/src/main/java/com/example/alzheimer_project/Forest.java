package com.example.alzheimer_project;

import java.util.ArrayList;
import java.util.Random;

public class Forest {

    ArrayList<Integer> randomNumbers = new ArrayList<>();

    public Forest() {
        generateRandomNumbers(randomNumbers);

        // Print the generated numbers
        System.out.println("Generated Numbers: " + randomNumbers);
    }

    public static void main(String[] args) {
        new Forest();
    }

    public void generateRandomNumbers(ArrayList<Integer> randomNumbers) {
        // Determine a random position (excluding the first)
        int randomPosition = new Random().nextInt(5) + 1;

        for (int i = 0; i < 5; i++) {
            if (i == randomPosition) {
                // Generate a negative number
                randomNumbers.add(generateRndNumFive() * -1);
            } else {
                // Generate a positive number
                randomNumbers.add(generateRndNumFive());
            }
        }
    }

    public int generateRndNumFive() {
        Random random = new Random();
        return random.nextInt(5) + 1; // Number between 1 and 5
    }
}
