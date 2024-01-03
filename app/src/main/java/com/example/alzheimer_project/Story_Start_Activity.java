package com.example.alzheimer_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Story_Start_Activity extends AppCompatActivity {
    TextView tv_crossroads;
    Button btn_village, btn_forest;

    Story_Start story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        tv_crossroads = findViewById(R.id.tv_crossroads);
        btn_village = findViewById(R.id.btn_village);
        btn_forest = findViewById(R.id.btn_forest);

        story = new Story_Start(this);
        story.startingPoint();
    }
}

