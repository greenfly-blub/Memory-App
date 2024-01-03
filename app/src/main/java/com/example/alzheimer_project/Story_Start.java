package com.example.alzheimer_project;

import android.content.Intent;
import android.util.Log;

public class Story_Start {
    private Story_Start_Activity ssa;

    public Story_Start(Story_Start_Activity ssa) {
        this.ssa = ssa;
    }

    public void startingPoint() {
        ssa.tv_crossroads.setText("Gehst du in das Dorf oder in den Wald?");
        Log.d("Starting Point", "starting point");

        ssa.btn_village.setText("Dorf");
        ssa.btn_forest.setText("Wald");

        ssa.btn_village.setOnClickListener(view -> {
            // Here you click Dorf and start Village Activity
            Log.d("Village_Activity", "Button Dorf clicked");
            ssa.getApplicationContext().startActivity(new Intent(ssa, Village_Activity.class));

        });

        ssa.btn_forest.setOnClickListener(view -> {
            // Here you click Dorf and start Village Activity
            Log.d("Forest_Activity", "Button Wald clicked");
            ssa.getApplicationContext().startActivity(new Intent(ssa, Forest_Activity.class));
        });
    }
}
