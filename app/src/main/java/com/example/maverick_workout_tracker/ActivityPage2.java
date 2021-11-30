package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ActivityPage2 extends AppCompatActivity implements View.OnClickListener {


    Button cstbtn, sldbtn, bckbtn, legbtn, armbtn, InterButton, AdvButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        cstbtn = (Button) findViewById(R.id.cstbtn);
        sldbtn = (Button) findViewById(R.id.sldbtn);
        bckbtn = (Button) findViewById(R.id.bckbtn);
        legbtn = (Button) findViewById(R.id.legbtn);
        armbtn = (Button) findViewById(R.id.armbtn);
        InterButton = (Button) findViewById(R.id.InterButton);
        AdvButton = (Button) findViewById(R.id.AdvButton);


        cstbtn.setOnClickListener(this);
        sldbtn.setOnClickListener(this);
        bckbtn.setOnClickListener(this);
        legbtn.setOnClickListener(this);
        armbtn.setOnClickListener(this);
        InterButton.setOnClickListener(this);
        AdvButton.setOnClickListener(this);

    }

    private void openChestPage() {
        Intent intent = new Intent(this, ChestPage.class);
        startActivity(intent);
    }

    private void openShouldersPage() {
        Intent intent = new Intent(this, ShouldersPage.class);
        startActivity(intent);
    }

    private void openBackPage() {
        Intent intent = new Intent(this, BackPage.class);
        startActivity(intent);
    }

    private void openLegPage() {
        Intent intent = new Intent(this, LegPage.class);
        startActivity(intent);
    }

    private void openArmPage() {
        Intent intent = new Intent(this, ArmPage.class);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cstbtn:
                openChestPage();
                break;
            case R.id.sldbtn:
                openShouldersPage();
                break;
            case R.id.bckbtn:
                openBackPage();
                break;
            case R.id.legbtn:
                openLegPage();
                break;
            case R.id.armbtn:
                openArmPage();
                break;
            case R.id.InterButton:
                openIntActivity();
                break;
            case R.id.AdvButton:
                openAdvActivity();
                break;
            default:
                break;

        }
    }

}