package com.example.maverick_workout_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class instructors extends AppCompatActivity {
    CardView instructor1CardBtn;
    CardView instructor2CardBtn;
    CardView instructor3CardBtn;
    CardView instructor4CardBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructors);

        instructor1CardBtn = findViewById(R.id.instructor1);
        instructor2CardBtn = findViewById(R.id.instructor2);
        instructor3CardBtn = findViewById(R.id.instructor3);
        instructor4CardBtn = findViewById(R.id.instructor4);


        instructor1CardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Instructor 1 Clicked", Toast.LENGTH_SHORT).show();

                Intent load = new Intent(getApplicationContext(),action.class);
                startActivity(load);
            }
        });

        instructor2CardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Instructor 2 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        instructor3CardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Instructor 3 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        instructor4CardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Instructor 4 Clicked", Toast.LENGTH_SHORT).show();

            }
        });

    }
}