package com.example.copcashapp.controller;

import android.app.Application;
import android.graphics.Typeface;

import com.example.copcashapp.R;
import com.example.copcashapp.Retrofit.APIEndpoints;
import com.example.copcashapp.util.Settings;
import com.example.copcashapp.util.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class CoopAPP extends Application {
    private static CoopAPP mInstance;
    public Settings settings;
    private TypeFactory mFontFactory;
    public APIEndpoints apiService;
    private String token = "";
    private Gson gson;
    private OkHttpClient.Builder httpClient;
    private HttpLoggingInterceptor loggingInterceptor;

    private static Retrofit retrofit;

    public static synchronized CoopAPP getApp() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        settings = new Settings(getApplicationContext());

//        Stetho.initializeWithDefaults(this);

        initializeRetrofit();

        mInstance = this;
    }

    public Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new TypeFactory(this);

        switch (type) {
            case Constants.BOLD:
                return mFontFactory.getBold();

            default:
                return mFontFactory.getRegular();
        }
    }

    private void initializeRetrofit(){
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.callTimeout(30, TimeUnit.SECONDS);
        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(loggingInterceptor);
        httpClient.addInterceptor(chain -> {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Bearer " + token)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);

        });

        OkHttpClient client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.baseURIAPI))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(APIEndpoints.class);
    }

    public interface Constants {
        int REGULAR = 1,
                BOLD = 2;
    }





    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static CoopAPP getmInstance() {
        return mInstance;
    }

    public static void setmInstance(CoopAPP mInstance) {
        CoopAPP.mInstance = mInstance;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public TypeFactory getmFontFactory() {
        return mFontFactory;
    }

    public void setmFontFactory(TypeFactory mFontFactory) {
        this.mFontFactory = mFontFactory;
    }

    public APIEndpoints getApiService() {
        return apiService;
    }

    public void setApiService(APIEndpoints apiService) {
        this.apiService = apiService;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public OkHttpClient.Builder getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(OkHttpClient.Builder httpClient) {
        this.httpClient = httpClient;
    }

    public HttpLoggingInterceptor getLoggingInterceptor() {
        return loggingInterceptor;
    }

    public void setLoggingInterceptor(HttpLoggingInterceptor loggingInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static void setRetrofit(Retrofit retrofit) {
        CoopAPP.retrofit = retrofit;
    }
}