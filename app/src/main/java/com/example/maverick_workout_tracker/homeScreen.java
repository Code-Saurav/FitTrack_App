package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class homeScreen extends AppCompatActivity
{

    CardView cardprofile;
    CardView cardchat;
    CardView cardcalender;
    CardView cardworkout;
    CardView cardsearch;
    CardView cardlogout;
    CardView cardinstructor;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        
        cardprofile = findViewById(R.id.profile_card);
        cardchat = findViewById(R.id.chat_card);
        cardcalender = findViewById(R.id.calender_card);
        cardworkout= findViewById(R.id.workout_card);
        cardsearch = findViewById(R.id.search_card);
        cardlogout = findViewById(R.id.logout_card);
        cardinstructor = findViewById(R.id.instructor_card);
        
        cardprofile.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {

                Intent loadProfile = new Intent(getApplicationContext(), userProfile.class);
                startActivity(loadProfile);
            }
        });

        cardchat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(homeScreen.this,CommunicationActivity.class);
                startActivity(intent);
            }
        });

        cardcalender.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(homeScreen.this,calanderActivity.class);
                startActivity(intent);
            }
        });

        cardworkout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent loadWorkoutPage = new Intent(homeScreen.this, workoutActivity.class);
                startActivity(loadWorkoutPage);
            }
        });

        cardsearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent loadSearchPage = new Intent(homeScreen.this, search.class);
                startActivity(loadSearchPage);

            }
        });

        cardinstructor.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v)
                    {

                        Intent loadInstructors = new Intent(homeScreen.this, instructors.class);
                        startActivity(loadInstructors);
                    }


        });

        cardlogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showToast("Logging Out");
                Intent registrationP = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(registrationP);
            }

        });
    }
    
    private void showToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}