package com.example.alzheimer_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Forest_Activity extends AppCompatActivity {
    private int counter = 0;
    private ArrayList<Integer> randomNumbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forest); // Achte darauf, dass du das richtige Layout verwendest

        final TextView randomNumberTextView = findViewById(R.id.tv_random_number);
        final Button btnChoice1 = findViewById(R.id.btn_choice1);
        final Button btnChoice2 = findViewById(R.id.btn_choice2);

        btnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forest.setRandomNumberAndButtonText(btnChoice1, randomNumberTextView, randomNumbers);

                if (++counter >= 5) {
                    Log.d("Forest_Activity", "counter over 5 - choice 1");
                    startEndActivity();
                }
            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forest.setRandomNumberAndButtonText(btnChoice2, randomNumberTextView, randomNumbers);

                if (++counter >= 5) {
                    Log.d("Forest_Activity", "counter over 5 - choice 2");
                    startEndActivity();
                }
            }
        });
    }

    private void startEndActivity() {
        Log.d("Forest_Activity", "startEndActivity started");
        Intent intent = new Intent(Forest_Activity.this, End_Activity.class);
        intent.putIntegerArrayListExtra("randomNumbers", randomNumbers);
        startActivity(intent);
        finish();
    }
}
