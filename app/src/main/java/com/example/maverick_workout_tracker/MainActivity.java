package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maverick_workout_tracker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button welcomeBtn;
        welcomeBtn = findViewById(R.id.welcome);

        welcomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadLoginMain = new Intent(getApplicationContext(),login_page.class);
                startActivity(loadLoginMain);
            }
        });
    }



}