package com.example.copcashapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.copcashapp.controller.CoopAPP;
import com.example.copcashapp.model.login;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText usernames;
    EditText password;
    Button btnlogin;
    String usersname, pass;
    CoopAPP coopAPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernames = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.loginButton);
        coopAPP = (CoopAPP) getApplication();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersname = usernames.getText().toString().trim();
                pass = password.getText().toString().trim();
                if (usersname.isEmpty()) { //Username and Password Validation
                    Toast.makeText(getApplicationContext(), "Username and password required", Toast.LENGTH_LONG);
                }else {
                    login login = new login(
                            usersname,
                            pass
                    );

                    Call<login> call = coopAPP.apiService.authUser(login);
                    call.clone().enqueue(new Callback<login>() {
                        @Override
                        public void onResponse(Call<login> call, Response<login> response) {
                            if (response.code() == 200) {
                                Toast.makeText(getApplicationContext(), "Logged Successfully !", Toast.LENGTH_LONG).show();
                                coopAPP.setUserName(usersname);
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Sorry, invalid username or password!", Toast.LENGTH_LONG).show();
                                coopAPP.setUserName("Minchele");
//                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                startActivity(intent);
//                                finish();
                            }
                        }
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull Throwable t) {

                        }
                    });
                }
            }
        });


    }
}
