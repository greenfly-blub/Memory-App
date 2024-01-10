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

        // Get the List with the numbers from the Forest_Activity
        ArrayList<Integer> numbers = getIntent().getIntegerArrayListExtra("randomNumbers");

        // Call Add and Subtract method
        int endResult = addNumbers(numbers);

        // Show End Result
        TextView specialSumTextView = findViewById(R.id.tv_math);
        specialSumTextView.setText("Ergebnis: " + String.valueOf(endResult) + " Array: " + numbers.toString());

        // Get a random button index
        int randomButtonIndex = getRandomButtonIndex();

        // Set the endResult text on a random button
        setEndResultButtonText(randomButtonIndex, endResult);
    }

    private int addNumbers(ArrayList<Integer> numbers) {
        return calculateSum(numbers);
    }

    // Add the calculateSum method here
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
                //To ensure the number is not negative:
                randomNumber = Math.max(0, randomNumber);

                // Set the text on the other button
                otherButton.setText(String.valueOf(randomNumber));
            }
        }
    }
}

