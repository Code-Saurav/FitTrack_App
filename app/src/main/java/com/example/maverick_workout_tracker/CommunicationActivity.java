package com.example.maverick_workout_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CommunicationActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();
    public Spinner spinner;
    public EditText subject;
    public EditText message;
    public Button submit_com;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communication);

        List<String> emails = Arrays.asList("MaverickWorkoutTracker@gmail.com","","");

        spinner = (Spinner)findViewById(R.id.spinner);
        subject = (EditText)findViewById(R.id.subject_id);
        message = (EditText)findViewById(R.id.message_id);
        submit_com = (Button) findViewById(R.id.send_message);

        String spinner1 = spinner.getSelectedItem().toString();
        String subject1 = subject.getText().toString();
        String message1 = message.getText().toString();

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,emails);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submit_com.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createMessage(spinner.getSelectedItem().toString(),subject.getText().toString(),message.getText().toString());
                Intent intent = new Intent(CommunicationActivity.this, homeScreen.class);
                startActivity(intent);
            }
        });


    }




        /*
        Log.d("Main Thread", "Main Thread ID: " + Thread.currentThread().getId());

            Request request =  new Request.Builder().url("https://ultrainer.herokuapp.com/sendemail").build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                    Log.d("Thread", "Thread ID: " + Thread.currentThread().getId());

                    if(response.isSuccessful()){
                        ResponseBody responseBody = response.body();
                        String body = responseBody.string();
                        Log.d("URL", "onResponse:  " + body);

                    }
                }
            });
GET*/



    void createMessage(String email, String subject, String message) {

        ObjectMapper objectMapper = new ObjectMapper();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        SendEmail sendEmail = new SendEmail(email, subject, message);
        try {
            RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(sendEmail));
            Request request = new Request.Builder()
                    .url("https://ultrainer.herokuapp.com/sendemail")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                    Log.d("Thread", "Thread ID: " + Thread.currentThread().getId());

                    if (response.isSuccessful()) {
                        ResponseBody responseBody = response.body();
                        String body = responseBody.string();
                        Log.d("URL", "onResponse:  " + body);

                    }
                }
            });
        } catch (Exception ex) {
            System.out.println("error calling email microservice");
        }

//        RequestBody formBody = new FormBody.Builder()
//                .add("email", email)
//                .add("subject", subject)
//                .add("message", message)
//                .build();
//
//
//        Request request = new Request.Builder()
//                .url("https://ultrainer.herokuapp.com/sendemail")
//                .post(formBody)
//                .build();
    }
}