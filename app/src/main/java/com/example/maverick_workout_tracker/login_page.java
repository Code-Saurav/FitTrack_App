package com.example.maverick_workout_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.maverick_workout_tracker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login_page extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        EditText userEmail, userPassword, userPhone;
        Button signInBtn, lTorBtn;

        userEmail = findViewById(R.id.logPhone);
        userPhone = findViewById(R.id.logPhone);
        userPassword = findViewById(R.id.logPassword);

        signInBtn = findViewById(R.id.signIn);
        lTorBtn = findViewById(R.id.lTor);
        ProgressBar loginPb = findViewById(R.id.progressBar);

        loginPb.setVisibility(ProgressBar.INVISIBLE);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(!validateUserPhone() || !validateUserPassword()){
                   return;
               }
               else{
                   String userEnteredPassword = userPassword.getEditableText().toString();
                   String userEnteredPhone = userPhone.getEditableText().toString();
                   //Get the data base reference
                   DatabaseReference root = FirebaseDatabase.getInstance().getReference("User");
                   Query CheckUser = root.orderByChild("hphone").equalTo(userEnteredPhone);

                   CheckUser.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           if (snapshot.exists()){
//                               Toast.makeText(getApplicationContext(), "Logging In", Toast.LENGTH_SHORT).show();
                               String passwordFromDb = snapshot.child(userEnteredPhone).child("hpassword").getValue(String.class);
//                               Toast.makeText(getApplicationContext(), "User Password is : " + passwordFromDb , Toast.LENGTH_SHORT).show();
                               if ( passwordFromDb.equals(userEnteredPassword)){
                                   Toast.makeText(getApplicationContext(), "Verified Login", Toast.LENGTH_SHORT).show();
                                   loginPb.setVisibility(ProgressBar.VISIBLE);

                                   Intent loadUserProfile = new Intent(getApplicationContext(), userProfile.class);
                                   startActivity(loadUserProfile);
                               }
                               else{
                                   Toast.makeText(getApplicationContext(), "Incorrect Password, ", Toast.LENGTH_SHORT).show();
                               }
                           }
                           else{
                               Toast.makeText(getApplicationContext(), "User Not Found", Toast.LENGTH_SHORT).show();
                           }

                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                       }

                   });

               }
            }
            Boolean validateUserPhone(){
                String entry = userPhone.getText().toString();
                if(entry.isEmpty()){
                    userPhone.setError("Field cannot be empty");
                    return false;
                }
                else {
                    return true;
                }


            }

            Boolean validateUserPassword(){
                String entryPassword = userPassword.getText().toString();
                if(entryPassword.isEmpty()){
                    userPassword.setError("Field cannot be Empty");
                    return false;
                }
                else{
                    userPassword.setError(null);
                    return true;
                }
            }
        });

//         loginpage to Register page
        lTorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast toast = Toast.makeText(getApplicationContext(), "lTorBtn working", Toast.LENGTH_SHORT);
//                toast.show();
                Intent loadRegister = new Intent(getApplicationContext(),registration.class);
                startActivity(loadRegister);
            }
        });


    } //End of the onCreate


}