package com.example.alzheimer_project;

import java.util.Random;

public class Village {

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Zufällige Zahl zwischen 1 und 10 generieren
    }
}

