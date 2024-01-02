package com.example.alzheimer_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Title_Screen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        Button startButton = findViewById(R.id.btn_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Game_Screen_Activity when the button is clicked
                Intent intent = new Intent(Title_Screen_Activity.this, Story_Start_Activity.class);
                startActivity(intent);
            }
        });
    }
}
