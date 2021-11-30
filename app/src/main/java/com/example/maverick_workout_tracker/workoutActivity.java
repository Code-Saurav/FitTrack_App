package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class workoutActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    private void openActivityPage2() {
        Intent intent = new Intent(this, ActivityPage2.class);
        startActivity(intent);
    }

    private void openIntActivity() {
        Intent intent = new Intent(this, IntActivity.class);
        startActivity(intent);
    }

    private void openAdvActivity() {
        Intent intent = new Intent(this, AdvActivity.class);
        startActivity(intent);
    }

    private void openWeightTracker() {
        Intent intent = new Intent(this, WeightTracker.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                openActivityPage2();
                break;
            case R.id.btn2:
                openIntActivity();
                break;
            case R.id.btn3:
                openAdvActivity();
                break;
            case R.id.btn4:
                openWeightTracker();
                break;
            default:
                break;

        }
    }
}