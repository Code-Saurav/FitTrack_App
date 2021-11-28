package com.example.maverick_workout_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maverick_workout_tracker.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Button reviewBtn = findViewById(R.id.reviewSubmit);

        EditText userEnteredReview;
        EditText userEnteredStar;

        TextInputLayout comment1Text ;
        TextInputLayout star1Text;


        String instructorName = "Harry Shan"; // TODO: 11/24/2021  Connect it to the instructor Profile
        String memberName = "John";// TODO: 11/24/2021  Connect it with the user writing the comment


        // Database Reference
        FirebaseDatabase db = FirebaseDatabase.getInstance();

        //Instance fo the reveiw child of the database
        DatabaseReference rootReview = db.getReference().child("review");

        TextView comments1Target = findViewById(R.id.comment1);
        TextView comments2Target = findViewById(R.id.comment2);

        userEnteredReview = findViewById(R.id.writeComment);
        userEnteredStar = findViewById(R.id.noOfStars);

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String writeComment = userEnteredReview.getText().toString();
                String noOfStars = userEnteredStar.getText().toString();

                // Update the review in Database
                updateReview(writeComment,noOfStars);


                    /* Retrieve the Review from the firebase and Display it on the Prfile as Text View */
                    Query checkReview = rootReview.orderByChild("memberName").equalTo("John");

                    checkReview.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                String retriveComment1 = snapshot.child("Instructor").child("reviewComments").getValue(String.class);
                                String retriveComment2 = snapshot.child("Instructor").child("reviewcomments2").getValue(String.class);
                                if (retriveComment2 == null){
                                    comments2Target.setVisibility(View.INVISIBLE);
                                }
                                comments1Target.setText(retriveComment1);

                                userEnteredReview.setVisibility(View.INVISIBLE);
                                userEnteredStar.setVisibility(View.INVISIBLE);


//                            Toast.makeText(getApplicationContext(), retriveComment, Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "No review Available at this time", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


            }



            void updateReview(String writeComment, String noOfStars){

                if( writeComment != null ){
                    reviewHelper reveiwHelp= new reviewHelper(instructorName,memberName,writeComment,noOfStars);
                    Toast.makeText(getApplicationContext(), "Review Successfully", Toast.LENGTH_SHORT).show();


                    //Instructor Name can be user here as a child for the review
                    rootReview.child("Instructor").setValue(reveiwHelp) ;               }
            }
        });

       // Button displayReviewBtn = findViewById(R.id.showReview);
            }
}