package com.example.alzheimer_project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class End_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // Get the List with the numbers from the activity before
        ArrayList<Integer> numbers = getIntent().getIntegerArrayListExtra("randomNumbers");

        // Call Add and Subtract method
        int endResult = addNumbers(numbers);

        // Show End Result
        TextView specialSumTextView = findViewById(R.id.tv_math);
        specialSumTextView.setText("Ergebnis: " + String.valueOf(endResult));

        // Get a random button index
        int randomButtonIndex = getRandomButtonIndex();

        // Set the endResult text on a random button
        setEndResultButtonText(randomButtonIndex, endResult);
    }

    private int addNumbers(ArrayList<Integer> numbers) {

        return calculateSum(numbers);
    }

    // Füge die calculateSum Methode hier hinzu
    private int calculateSum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private int getRandomButtonIndex() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    // The right result will be shown as a button text on a random button
    private void setEndResultButtonText(int buttonIndex, int endResult) {
        int buttonId = getResources().getIdentifier("btn_option" + buttonIndex, "id", getPackageName());
        Button selectedButton = findViewById(buttonId);
        //set text to chosen button
        selectedButton.setText(String.valueOf(endResult));

        //sets the numbers of the other buttons around the result
        for (int i = 1; i <= 5; i++) {
            if (i != buttonIndex) {
                int otherButtonId = getResources().getIdentifier("btn_option" + i, "id", getPackageName());
                Button otherButton = findViewById(otherButtonId);

                // Number in area of +/-5 of result
                int randomNumber = endResult + (i - buttonIndex);
                //Damit die Nummer nicht negativ ist:
                randomNumber = Math.max(0, randomNumber);

                // Setze den Text auf den anderen Button
                otherButton.setText(String.valueOf(randomNumber));
            }
        }
    }
}
