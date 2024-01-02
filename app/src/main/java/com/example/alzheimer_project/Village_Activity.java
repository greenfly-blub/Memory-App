package com.example.alzheimer_project;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class Village_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);

        // Generiere eine zufällige Zahl zwischen 1 und 10
        int randomNumber = generateRandomNumber();

        // Zeige die zufällige Zahl in der TextView an
        TextView randomNumberTextView = findViewById(R.id.tv_random_number);
        randomNumberTextView.setText(String.valueOf(randomNumber));
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Zufällige Zahl zwischen 1 und 10
    }
}
