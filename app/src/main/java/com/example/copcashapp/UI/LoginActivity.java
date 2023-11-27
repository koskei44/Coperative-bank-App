package com.example.copcashapp.UI;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.copcashapp.R;
import com.google.android.material.button.MaterialButton;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class LoginActivity extends AppCompatActivity {
    /*    @BindView(R.id.appname)
        TextView textViewAppName;*/
//    @BindView(R.id.editTextEmail)
//    EditText editTextEmail;
//    @BindView(R.id.editTextPassword)
//    EditText editTextPassword;
//
//    @BindView(R.id.loginButton)
//    MaterialButton loginButton;

    int PERMISSION_ALL = 1;
    public ProgressDialog mprogress;
    private static int SPLASH_TIME_OUT = 3000;
    private boolean retrofitSuccess = false;
    private HashMap<Integer, String> userRoles;

    String[] PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };


    private Intent serviceIntent;


    static String uri;
    static String baseUsername;
    static String basePassword;
    static String name;
    static String pasword;
    private String userDirectorate = "";
    private static final int DATA_SETUP_SERVICE_ID = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

}

