package com.example.alzheimer_project;

import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.ArrayList;

public class Village {

    public static int generateRndNumFive() {
        Random random = new Random();
        return random.nextInt(5) + 1; // Zufällige Zahl zwischen 1 und 5
    }

    public static int generateRndNumTen() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Zufällige Zahl zwischen 1 und 10
    }

    public static void setButtonText(Button button, String text) {
        button.setText(text);
    }

    //Hier als Beispiel: Wenn Button choice1 ist, dann TEN - kann man anders randomisieren
    public static void setRandomNumberAndButtonText(Button btnChoice, TextView randomNumberTextView, ArrayList<Integer> randomNumbers) {
        int randomNumber;
        if (btnChoice.getId() == R.id.btn_choice1) {
            randomNumber = generateRndNumTen();
        } else {
            randomNumber = generateRndNumFive();
        }
        randomNumbers.add(randomNumber); // add number to ArrayList
        randomNumberTextView.setText(String.valueOf(randomNumber));
    }


}


