package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class action extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        Button instructorReviewBtn = findViewById(R.id.instructorReview);
        Button instructorPurchaseBtn = findViewById(R.id.instructorPurchasse);


        instructorReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadReviewPage = new Intent(getApplicationContext(),review.class);
                startActivity(loadReviewPage);
            }
        });

        instructorPurchaseBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadPurchase = new Intent(getApplicationContext(),SubscriptionPage.class);
                startActivity(loadPurchase);
            }
        }));
    }
}