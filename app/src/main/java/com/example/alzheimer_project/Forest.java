package com.example.alzheimer_project;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Forest {

    public static int generateRndNumFive() {
        Random random = new Random();
        return random.nextInt(5) + 1; // No between 1 and 5
    }

    public static int generateRndNumTen() {
        Random random = new Random();
        return random.nextInt(10) + 1; // No between 1 and 10
    }

    public static void setButtonText(Button button, String text) {
        button.setText(text);
    }

    // Hier als Beispiel: Wenn Button choice1 ist, dann TEN - kann man anders randomisieren
    public static void setRandomNumberAndButtonText(Button btnChoice, TextView randomNumberTextView, ArrayList<Integer> randomNumbers) {
        int randomNumber;
        if (btnChoice.getId() == R.id.btn_choice1) {
            randomNumber = generateRndNumTen();
        } else {
            randomNumber = generateRndNumFive();
        }
        randomNumbers.add(randomNumber); // Add number to ArrayList
        randomNumberTextView.setText(String.valueOf(randomNumber));
    }
}
