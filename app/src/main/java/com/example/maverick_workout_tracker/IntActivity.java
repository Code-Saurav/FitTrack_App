package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class IntActivity extends AppCompatActivity implements View.OnClickListener {


    Button cstbtn, sldbtn, bckbtn, legbtn, armbtn, BeginButton, AdvButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_int);

        cstbtn = (Button) findViewById(R.id.cstbtn);
        sldbtn = (Button) findViewById(R.id.sldbtn);
        bckbtn = (Button) findViewById(R.id.bckbtn);
        legbtn = (Button) findViewById(R.id.legbtn);
        armbtn = (Button) findViewById(R.id.armbtn);
        BeginButton = (Button) findViewById(R.id.BeginButton);
        AdvButton = (Button) findViewById(R.id.AdvButton);


        cstbtn.setOnClickListener(this);
        sldbtn.setOnClickListener(this);
        bckbtn.setOnClickListener(this);
        legbtn.setOnClickListener(this);
        armbtn.setOnClickListener(this);
        BeginButton.setOnClickListener(this);
        AdvButton.setOnClickListener(this);

    }

    private void openChestInt() {
        Intent intent = new Intent(this, ChestInt.class);
        startActivity(intent);
    }

    private void openShoulderInt() {
        Intent intent = new Intent(this, ShoulderInt.class);
        startActivity(intent);
    }

    private void openBackInt() {
        Intent intent = new Intent(this, BackInt.class);
        startActivity(intent);
    }

    private void openLegInt() {
        Intent intent = new Intent(this, LegInt.class);
        startActivity(intent);
    }

    private void openArmInt() {
        Intent intent = new Intent(this, ArmInt.class);
        startActivity(intent);
    }

    private void openActivityPage2() {
        Intent intent = new Intent(this, ActivityPage2.class);
        startActivity(intent);
    }

    private void openAdvActivity() {
        Intent intent = new Intent(this, AdvActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cstbtn:
                openChestInt();
                break;
            case R.id.sldbtn:
                openShoulderInt();
                break;
            case R.id.bckbtn:
                openBackInt();
                break;
            case R.id.legbtn:
                openLegInt();
                break;
            case R.id.armbtn:
                openArmInt();
                break;
            case R.id.BeginButton:
                openActivityPage2();
                break;
            case R.id.AdvButton:
                openAdvActivity();
                break;
            default:
                break;

        }
    }

}