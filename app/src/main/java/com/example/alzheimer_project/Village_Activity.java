package com.example.alzheimer_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Village_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);

        // Verwende die generateRandomNumber-Methode aus der Village-Klasse
        int randomNumber = Village.generateRandomNumber();

        // Zeige die zufällige Zahl in der TextView an
        TextView randomNumberTextView = findViewById(R.id.tv_random_number);
        randomNumberTextView.setText(String.valueOf(randomNumber));
    }
}

