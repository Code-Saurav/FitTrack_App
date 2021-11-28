package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.maverick_workout_tracker.R;

public class SubscriptionPage extends AppCompatActivity
{

    public Button homepage;
    public Button credit_debit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscription_page);

        homepage = (Button) findViewById(R.id.back_to_home);

        homepage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SubscriptionPage.this, homeScreen.class);
                startActivity(intent);
            }
        });

        credit_debit = (Button) findViewById(R.id.credit_debit);

        credit_debit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SubscriptionPage.this,CreditPaymentPage.class);
                startActivity(intent);
            }
        });
    }
}