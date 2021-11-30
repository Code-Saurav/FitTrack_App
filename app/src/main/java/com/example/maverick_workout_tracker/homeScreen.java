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

                Intent registrationP = new Intent(getApplicationContext(), login_page.class);
                startActivity(registrationP);
//                Load suscription page
//                Intent intent = new Intent(homeScreen.this,SubscriptionPage.class);
//                startActivity(intent);
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
                showToast("Search Clicked");
            }
        });

        cardinstructor.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v)
                    {

                        Intent loadpayment = new Intent(getApplicationContext(), SubscriptionPage.class);
                        startActivity(loadpayment);
//                Load suscription page
//                Intent intent = new Intent(homeScreen.this,SubscriptionPage.class);
//                startActivity(intent);
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