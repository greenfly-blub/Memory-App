package com.example.alzheimer_project;

import java.util.Random;

public class Village {

    public static int generateRndNumFive() {
        Random random = new Random();
        return random.nextInt(5) + 1; // Zufällige Zahl zwischen 1 und 5
    }    public static int generateRndNumTen() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Zufällige Zahl zwischen 1 und 10
    }
}

