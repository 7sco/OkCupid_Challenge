package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FullPaths  implements Serializable{
    @Expose
    @SerializedName("original")
    private String original;
    @Expose
    @SerializedName("medium")
    private String medium;
    @Expose
    @SerializedName("small")
    private String small;
    @Expose
    @SerializedName("large")
    private String large;

    public String getOriginal() {
        return original;
    }

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }
}
