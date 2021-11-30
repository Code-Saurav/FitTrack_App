package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AdvActivity extends AppCompatActivity implements View.OnClickListener {


    Button cstbtn, sldbtn, bckbtn, legbtn, armbtn, BeginButton, InterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv);

        cstbtn = (Button) findViewById(R.id.cstbtn);
        sldbtn = (Button) findViewById(R.id.sldbtn);
        bckbtn = (Button) findViewById(R.id.bckbtn);
        legbtn = (Button) findViewById(R.id.legbtn);
        armbtn = (Button) findViewById(R.id.armbtn);
        BeginButton = (Button) findViewById(R.id.BeginButton);
        InterButton = (Button) findViewById(R.id.InterButton);



        cstbtn.setOnClickListener(this);
        sldbtn.setOnClickListener(this);
        bckbtn.setOnClickListener(this);
        legbtn.setOnClickListener(this);
        armbtn.setOnClickListener(this);
        BeginButton.setOnClickListener(this);
        InterButton.setOnClickListener(this);

    }

    private void openAdvChest() {
        Intent intent = new Intent(this, AdvChest.class);
        startActivity(intent);
    }

    private void openAdvShoulder() {
        Intent intent = new Intent(this, AdvShoulder.class);
        startActivity(intent);
    }

    private void openAdvBack() {
        Intent intent = new Intent(this, AdvBack.class);
        startActivity(intent);
    }

    private void openAdvLegs() {
        Intent intent = new Intent(this, AdvLegs.class);
        startActivity(intent);
    }

    private void openAdvArms() {
        Intent intent = new Intent(this, AdvArms.class);
        startActivity(intent);
    }

    private void openActivityPage2() {
        Intent intent = new Intent(this, ActivityPage2.class);
        startActivity(intent);
    }

    private void openIntActivity() {
        Intent intent = new Intent(this, IntActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cstbtn:
                openAdvChest();
                break;
            case R.id.sldbtn:
                openAdvShoulder();
                break;
            case R.id.bckbtn:
                openAdvBack();
                break;
            case R.id.legbtn:
                openAdvLegs();
                break;
            case R.id.armbtn:
                openAdvArms();
                break;
            case R.id.BeginButton:
                openActivityPage2();
                break;
            case R.id.InterButton:
                openIntActivity();
                break;
            default:
                break;

        }
    }

}