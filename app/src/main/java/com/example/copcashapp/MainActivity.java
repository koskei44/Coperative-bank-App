package com.example.copcashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.copcashapp.controller.CoopAPP;

public class MainActivity extends AppCompatActivity {

    TextView loggedinuser;

    CoopAPP coopAPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coopAPP = (CoopAPP) getApplication();

        loggedinuser = findViewById(R.id.loggedinuser);


        loggedinuser.setText("Welcome" +coopAPP.getUserName()+"to the new Co-op Bank app!");
    }
}