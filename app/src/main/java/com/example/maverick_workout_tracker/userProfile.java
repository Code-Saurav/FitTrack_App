package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maverick_workout_tracker.R;

public class userProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button trackProgressBtn = findViewById(R.id.trackMyProgress);

        trackProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadUserProgress = new Intent(getApplicationContext(),WeightTracker.class);
                startActivity(loadUserProgress);
            }
        });
    }
}