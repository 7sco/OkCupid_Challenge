package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cursors {
    @Expose
    @SerializedName("after")
    private String after;
    @Expose
    @SerializedName("current")
    private String current;
    @Expose
    @SerializedName("before")
    private String before;

    public String getAfter() {
        return after;
    }

    public String getCurrent() {
        return current;
    }

    public String getBefore() {
        return before;
    }
}
