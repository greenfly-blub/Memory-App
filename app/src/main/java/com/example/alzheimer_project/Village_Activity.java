package com.example.alzheimer_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Village_Activity extends AppCompatActivity {
    private int counter = 0;
    private ArrayList<Integer> randomNumbers = new ArrayList<>();
    int negCounterPos;
    int initialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);

        final TextView randomNumberTextView = findViewById(R.id.tv_random_number);
        final Button btnChoice1 = findViewById(R.id.btn_choice1);
        final Button btnChoice2 = findViewById(R.id.btn_choice2);

        // Set initialNumber to be the first number shown and the first in the array - between 1 and 7
        Random rnd = new Random();
        initialNumber = rnd.nextInt(4) + 5;
        randomNumbers.add(initialNumber);
        updateRandomNumberTextView(randomNumberTextView, initialNumber);

        // Generate the negation position once during initialization
        negCounterPos = rnd.nextInt(3) + 1;

        btnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomNumber(randomNumberTextView);
                checkAndStartEndActivity();
            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomNumber(randomNumberTextView);
                checkAndStartEndActivity();
            }
        });
    }

    private void checkAndStartEndActivity() {
        if (++counter == negCounterPos) {
            int lastNumber = randomNumbers.get(randomNumbers.size() - 1);
            int sumSoFar = sumArrayList(randomNumbers);

            // multiply chosen neg position with -1 (excluding the initial number)
            int negNumber = Math.min(lastNumber, sumSoFar - 1);
            randomNumbers.set(randomNumbers.size() - 1, negNumber * -1);
        }

        if (counter == 4) {
            Log.d("Village_Activity", "counter over 4");
            startEndActivity(randomNumbers);
        }
    }

    private int sumArrayList(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    private void startEndActivity(ArrayList<Integer> randomNumbers) {
        Log.d("Village_Activity", "startEndActivity started");
        Intent intent = new Intent(Village_Activity.this, End_Activity.class);
        intent.putIntegerArrayListExtra("randomNumbers", randomNumbers);
        startActivity(intent);
        finish();
    }

    private void setRandomNumber(TextView randomNumberTextView) {
        int randomNumber = generateRndNumFive();
        randomNumbers.add(randomNumber);
        updateRandomNumberTextView(randomNumberTextView, randomNumber);
    }

    private void updateRandomNumberTextView(TextView randomNumberTextView, int number) {
        // Display number with a negative sign if it's meant to be negated
        if (counter == negCounterPos - 1 && counter != 0) {
            randomNumberTextView.setText(String.format("-%d", number));
        } else {
            randomNumberTextView.setText(String.valueOf(number));
        }
    }

    private int generateRndNumFive() {
        Random random = new Random();
        return random.nextInt(5) + 1; // Zahl zwischen 1 und 5
    }
}
