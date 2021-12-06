package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        Button searchWorkoutBtn = findViewById(R.id.searchWorkout);

                Button searchWorkoutPlanBtn = findViewById(R.id.searchWorkoutPlan);
                Button searchSupplementBtn = findViewById(R.id.searchSupplement);


                searchSupplementBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("https://www.bodybuilding.com/?gclid=Cj0KCQiA-qGNBhD3ARIsAO_o7yloKfOB9DFcfGCAkS2XPO-lb_UcFcs0fhVA5J73sknt6_A-FFwiItkaAuQtEALw_wcB"); // missing 'http://' will cause crashed
                        Intent loadWebsite = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(loadWebsite);
                    }
                });
                searchWorkoutBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent loadWorkout = new Intent(getApplicationContext(),workoutActivity.class);
                        startActivity(loadWorkout);
                    }
                });

                searchWorkoutPlanBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent loadPlan = new Intent(getApplicationContext(),IntActivity.class);
                        startActivity(loadPlan);
                    }
                });

    }
}