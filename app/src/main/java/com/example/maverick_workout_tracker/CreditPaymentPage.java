package com.example.maverick_workout_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class CreditPaymentPage extends AppCompatActivity
{
    public Button submit;
    public EditText credit_card;
    public EditText expdate;
    public EditText cvv;
    public EditText state;
    public EditText zip;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_payment_page);

        submit=(Button)findViewById(R.id.submit_payment);

            submit.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(CreditPaymentPage.this, homeScreen.class);
                    startActivity(intent);
                }


            });

    }

}