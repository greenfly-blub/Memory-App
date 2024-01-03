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
        int endResult = addAndSubtract(numbers);

        // Show End Result
        TextView specialSumTextView = findViewById(R.id.tv_math);
        specialSumTextView.setText("Ergebnis: " + String.valueOf(endResult));

        // Get a random button index
        int randomButtonIndex = getRandomButtonIndex();

        // Set the endResult text on a random button
        setEndResultButtonText(randomButtonIndex, endResult);
    }

    // Summation and Subtraction
    private int addAndSubtract(ArrayList<Integer> numbers) {
        // Subtrahiere die Zahl an der 3. Position 2 MAL - weil sie bei der Addition dazu gezählt wurde
        return calculateSum(numbers) - 2 * numbers.get(2);
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
        selectedButton.setText(String.valueOf(endResult));
    }
}
