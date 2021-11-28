package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maverick_workout_tracker.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button rTolBtn,signUpBtn;
        rTolBtn = findViewById(R.id.rToL);
        signUpBtn = findViewById(R.id.signUp);

        EditText fullName;
        EditText email;
        EditText phone;
        EditText password;

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference().child("User");

        fullName = findViewById(R.id.regName);
        email = findViewById(R.id.regEmail);
        phone = findViewById(R.id.regPhone);
        password = findViewById(R.id.regPassword);

        rTolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadLogin = new Intent(getApplicationContext(),login_page.class);
                startActivity(loadLogin);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    Toast toast = Toast.makeText(getApplicationContext(),"signUpBtn",Toast.LENGTH_SHORT);
//                    toast.show();
                String regName = fullName.getText().toString();
                String regEmail = email.getText().toString();
                String regPhone  = phone.getText().toString();
                String regPassword = password.getText().toString();

//              As soon as user sign up they automatically becomes a member, they will be able to access the member feauture. This will be recognized by database as setting the initIsMember to True;
                Boolean initIsMember  = true;
//              initIsPremium is feature become true when they purchase workout plan, they will be able to access
                Boolean initIsPremium = false;

                Boolean initIsInstructor = false;

                // get all the value
                helper help = new helper(regName, regEmail,regPhone,regPassword, initIsMember, initIsPremium, initIsInstructor);

                root.child(regPhone).setValue(help);

                if(regEmail != null && regName != null && regPhone != null && regPassword != null) {
                    Toast.makeText(getApplicationContext(), "Registration Completed, Please Proceed with Login", Toast.LENGTH_SHORT).show();
                    Intent loadLogin = new Intent(getApplicationContext(), login_page.class);
                    startActivity(loadLogin);
                }
                else{
                    Toast.makeText(getApplicationContext(), "read the instruction carefully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}