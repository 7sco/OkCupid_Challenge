package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchResponse {

    @Expose
    @SerializedName("data")
    private List<Match> data;
    public List<Match> getData() {
        return data;
    }
}
