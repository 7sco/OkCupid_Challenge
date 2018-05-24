package com.example.franciscoandrade.okcupidchallenge.data.api;

import com.example.franciscoandrade.okcupidchallenge.data.model.MatchResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchApi {
    @GET("/matchSample.json")
    Call<MatchResponse> getFoodList();

}
