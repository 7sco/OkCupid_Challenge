package com.example.franciscoandrade.okcupidchallenge.data.api;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientService {
    public static Retrofit retrofit=null;

    public static Retrofit getClient(@NonNull String domain){
        if(retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(domain)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    @NonNull
    public MatchApi getFoodApi() {
        return retrofit.create(MatchApi.class);
    }
}