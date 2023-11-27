package com.example.copcashapp.Retrofit;

import com.example.copcashapp.model.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIEndpoints {
    @POST("/auth/login")
    Call<login> authUser(@Body login loginRequest);

}
