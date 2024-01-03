package com.example.alzheimer_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Village_Activity extends AppCompatActivity {
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);

        // Initialisiere die TextView, um die zufällige Zahl anzuzeigen
        final TextView randomNumberTextView = findViewById(R.id.tv_random_number);

        // Initialisiere die Buttons
        final Button btnChoice1 = findViewById(R.id.btn_choice1);
        final Button btnChoice2 = findViewById(R.id.btn_choice2);

        // Setze die OnClickListener für die Buttons
        btnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Rufe generateRndNumTen() auf
                int randomNumber = Village.generateRndNumTen();
                // Zeige die zufällige Zahl in der TextView an
                randomNumberTextView.setText(String.valueOf(randomNumber));

                // Überprüfe, ob fünf Wiederholungen erreicht wurden
                if (++counter >= 5) {
                    // Wechsle zur End_Activity
                    startActivity(new Intent(Village_Activity.this, End_Activity.class));
                    finish(); // Beende die aktuelle Activity
                }
            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Rufe generateRndNumFive() auf
                int randomNumber = Village.generateRndNumFive();
                // Zeige die zufällige Zahl in der TextView an
                randomNumberTextView.setText(String.valueOf(randomNumber));

                // Überprüfe, ob fünf Wiederholungen erreicht wurden
                if (++counter >= 5) {
                    // Wechsle zur End_Activity
                    startActivity(new Intent(Village_Activity.this, End_Activity.class));
                    finish(); // Beende die aktuelle Activity
                }
            }
        });
    }
}
