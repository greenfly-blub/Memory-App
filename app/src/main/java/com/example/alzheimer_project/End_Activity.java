package com.example.alzheimer_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class End_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // Get the List with the numbers from the activity before
        ArrayList<Integer> numbers = getIntent().getIntegerArrayListExtra("randomNumbers");


        // Call Add and Substract mehtod
        int endResult = addAndSubstract(numbers);

        // Show End Result
        TextView specialSumTextView = findViewById(R.id.tv_math);
        specialSumTextView.setText("Ergebnis: " + String.valueOf(endResult));
    }

    // Summierung und Subtraktion
    private int addAndSubstract(ArrayList<Integer> numbers)
    {
        int sum = 0;

        // Subtrahiere die Zahl an der 3. Position 2 MAL - weil sie bei der Addition dazu gezählt wurde
        sum = calculateSum(numbers) - 2 * numbers.get(2);

        return sum;
    }

    // Füge die calculateSum Methode hier hinzu
    private int calculateSum(ArrayList<Integer> numbers)
    {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
